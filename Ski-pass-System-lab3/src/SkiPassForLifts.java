/** Класс наследует суперкласс SkiPass, описывает карту с определенным количеством поездок*/

public class SkiPassForLifts extends SkiPass
{
    private int counter; // поле определяет количество поездок которое уже совершено по карте SkiPass
    private final NumberOfLifts NUMBER_OF_LIFTS; // константа перечисления - количество поездок на карте в начале использования (10,20,50,100)

    SkiPassForLifts(long skiPassId, boolean accessForHolidays, NumberOfLifts numberOfLifts) // конструктор - с параметром перечисления numberOfLifts
    {
        super(skiPassId, accessForHolidays); // вызов конструктора суперкласса SkiPass с параметрами
        this.NUMBER_OF_LIFTS = numberOfLifts; // задаем количество поездок для карты - переменная перечисления
    }

    public int getNumberOfLiftsLeft() //метод считает количество оставшихся поездок на карте - доступ по методу указаному в перечислении
    {
        return NUMBER_OF_LIFTS.getNumberOfLifts() - counter;
    }

    @Override
    public String additionalInformation() // возвращаем строку о начальном кол-ве поездок на карте и оставшемся
    {
        return "Карта на -" + NUMBER_OF_LIFTS + "- подъёмов, Осталось подъёмов=" + getNumberOfLiftsLeft();
    }

    @Override
    protected boolean specialCheck()  //Метод проверяет баланс карты по поездкам
    {
        ++counter;
        if (getNumberOfLiftsLeft() >= 0)
        {
            return true;
        }
        return false;
    }

}
