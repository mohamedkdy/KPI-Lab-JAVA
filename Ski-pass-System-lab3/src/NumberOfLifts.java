public enum NumberOfLifts // перечисление для всех возможных количеств поездок на карте (10,20,50,100) - для карты типа SkiPassForLifts
{
    TEN(10), // константы перечисления, для создания используем конструктор (NUMBER_OF_LIFTS: 10)
    TWENTY(20),
    FIFTY(50),
    ONE_HUNDRED(100);

    private final int NUMBER_OF_LIFTS; // количество поездок на карте в начале использования

    NumberOfLifts(int numberOfLifts)  // задаем количество поездок для карты
    {
        this.NUMBER_OF_LIFTS = numberOfLifts;
    }

    public int getNumberOfLifts()  // возвращаем количество поездок для карты
    {
        return NUMBER_OF_LIFTS;
    }
}
