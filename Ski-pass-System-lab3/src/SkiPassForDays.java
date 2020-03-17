import java.time.LocalDate;

/** Класс наследует суперкласс SkiPass, описывает карту с определенное количество дней. Подсчет начинается с даты первого использования.*/
public class SkiPassForDays extends SkiPass
{
    private boolean activated; // определяет карта SkiPass активирована или нет
    private final NumberOfDays NUMBER_OF_DAYS; // константа перечисления - определяет количество дней на карте SkiPass в начале использования
    private LocalDate blockDate; // определяет конечную дату использования карты SkiPass

    SkiPassForDays(long skiPassId, boolean accessForHolidays, NumberOfDays numberOfDays)  // конструктор SkiPassForDays - с параметром перечисления numberOfDays
    {
        super(skiPassId, accessForHolidays); // вызов конструктора суперкласса SkiPass с параметрами
        this.NUMBER_OF_DAYS = numberOfDays;  // задаем количество дней для карты - переменная перечисления
    }

    public LocalDate getBlockDate() // возвращает  конечную дату использования карты
    {
        return blockDate;
    }

    public int getNumberOfDays()   // возвращаем количество дней на карте в начале - доступ по методу указаному в перечислении
    {
        return NUMBER_OF_DAYS.get_NumberOfDays();
    }

    public boolean isActivated()  // возвращает true если карта активирована (важно для времени использования)
    {
        return activated;
    }

    @Override
    public String additionalInformation()  // возвращает строку с доп. инфо. о количестве дней (начальном) на карте и дате окончания работы карты
    {
        return "Карта на -" + NUMBER_OF_DAYS + "- дней, Карту использовать до=" + blockDate;
    }

    @Override
    protected boolean specialCheck() //Метод активирует карту, если это её первая проверка и проверяет не достигнута ли дата блокировки карты
    {
        if (!isActivated())
        {
            activate(); // активация карты - установка blockDate
        }
        if (LocalDate.now().isBefore(getBlockDate())) {
            return true;
        }
        return false;
    }

    private void activate() //Метод активирует карту и устанавливает дату окончания работы карты  blockDate
    {
        setStartUse(true);
        if (isAccessForHolidays())  // если у карты есть доступ по выходным дням (т.е. в любой день)
        {
            this.blockDate = LocalDate.now().plusDays(NUMBER_OF_DAYS.get_NumberOfDays());
            // дата блокировки = текущая дата + количество дней доступа по карте
        }
        else  // если у карты нет доступа по выходным дням (только рабочие дни недели)
        {
            this.blockDate = LocalDate.now().plusDays( NUMBER_OF_DAYS.get_NumberOfDays() + countAdditionalDays() );
           //  дата блокировки = текущая дата + количество дней доступа по карте + количество доп. дней (компенсация выходных)//
        }
    }

    private void setStartUse(boolean startUse)  // активируем карту
    {
        this.activated = startUse;
    }

    private int countAdditionalDays() //етод определяет количество дополнительных дней для карты не активной в выходные, для компенсация выходных дней
    {
        int additionalDays = 0;
        for(int i = 0; i < getNumberOfDays(); i++)  // проход по всем дням от текущего и проверка является ли он выходным,
        {
            while( checkForHolidays( LocalDate.now().plusDays(i) ) )   //если является, то увеличиваетя количество дополнительных дней
            {                                                           // while //
                additionalDays++;
                i++;  // если несколько выходных подряд
            }
        }
        return additionalDays;
    }

}
