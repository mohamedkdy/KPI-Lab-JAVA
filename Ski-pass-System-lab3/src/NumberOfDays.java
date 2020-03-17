public enum NumberOfDays // перечисление для всех возможных количеств дней на карте SkiPass(1,2,5) - для карты SkiPassForDays
{
    ONE(1),  // константы перечисления, для создания используем конструктор (numberOfDays: 1)
    TWO(2),
    FIVE(5);

    private final int numberOfDays;  // определяет количество дней на карте в начале использования

    NumberOfDays(int numberOfDays)   //конструктор -  установка количества дней на карте
    {
        this.numberOfDays = numberOfDays;
    }
    public int get_NumberOfDays()  // возвращает количество дней на карте
    {
        return numberOfDays;
    }
}
