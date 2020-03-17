import java.time.LocalDate;
import java.time.Month;

public enum Season //перечисление - типы сезонов (для сезонной карты типа SeasonPass)
{
    LOW_SEASON_BEFORE(LocalDate.of(LocalDate.now().getYear(), Month.NOVEMBER, 15),  // константа перечисления (содержит - start_date: 15 ноября 2018, finish_date:  1 января 2019)
            LocalDate.of(LocalDate.now().getYear() + 1, Month.JANUARY, 1)),    // создание с использованием конструктора

    HIGHT_SEASON_NEXT_YEAR(LocalDate.of(LocalDate.now().getYear() + 1, Month.JANUARY, 2),  // 2 января 2019 - 1 марта 2019
            LocalDate.of(LocalDate.now().getYear() + 1, Month.MARCH, 1)),

    LOW_SEASON_AFTER_NEXT_YEAR(LocalDate.of(LocalDate.now().getYear() + 1, Month.MARCH, 2),  // 2 марта 2019 - 15 апреля 2019
            LocalDate.of(LocalDate.now().getYear() + 1, Month.APRIL, 15));

    private final LocalDate START_DATE;  // начальная дата сезона

    private final LocalDate FINISH_DATE;  // финальная дата сезона

    Season(LocalDate startDate, LocalDate finishDate)   // конструктор для перечисления - задает начальную/конечную дату сезона
    {
        this.START_DATE = startDate;
        this.FINISH_DATE = finishDate;
    }

    public LocalDate getStartDate()  // возвращаем начальную дату сезона
    {
        return START_DATE;
    }

    public LocalDate getFinishDate() // возвращаем конечную дату сезона
    {
        return FINISH_DATE;
    }
}
