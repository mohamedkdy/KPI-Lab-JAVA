import java.time.LocalDateTime;

/** Класс наследует суперкласс SkiPass, описывает карту с работой на пол дня (первая 9-13 или вторая 13-17 половина дня).*/
public class SkiPassForHalfDay extends SkiPass {

    private final HalfOfDay HALF_OF_DAY; //  константа перечисления - определяет половину дня (первая 9-13 или вторая 13-17 половина дня)

    SkiPassForHalfDay(long id, boolean accessForHolidays, HalfOfDay halfOfDay)  // конструктор класса SkiPassForHalfDay - с параметром перечисления HalfOfDay
    {
        super(id, accessForHolidays);  // вызов конструктора суперкласса SkiPass с параметрами
        this.HALF_OF_DAY = halfOfDay;  // задаем нужную половину дня - переменная перечисления
    }

    public LocalDateTime getStartTime()  // возвращает время начала работы карты на пол дня
    {
        return HALF_OF_DAY.get_StartTime();
    }

    public LocalDateTime getFinishTime() // возвращает время окончания работы карты на пол дня
    {
        return HALF_OF_DAY.get_FinishTime();
    }

    @Override
    public String additionalInformation() // возвращает строку с доп. инфо. о время начала/окончания работы карты на пол дня
    {
        return "Начало использования карты=" + getStartTime() + ", Конец использования карты=" + getFinishTime();
    }

    @Override
    protected boolean specialCheck() //Метод проверяет - текущее время входит во время определенного для карты половины дня
    {
        LocalDateTime now = LocalDateTime.now();
        if (now.isAfter(getStartTime()) && now.isBefore(getFinishTime())) {
            return true;
        }
        return false;
    }

}
