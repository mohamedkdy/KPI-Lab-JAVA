import java.time.LocalDate;


/** Класс наследует суперкласс SkiPass, описывает сезонную карту  */
public class SeasonPass extends SkiPass
{
    private final Season SEASON; // поле тип перечисление - содержит название сезона

    SeasonPass(long skiPassId, Season season) // конструктор класса SeasonPass
    {
        super(skiPassId, true); // вызов конструктора суперкласса SkiPass с параметрами (инициализация true для accessForHolidays)
        this.SEASON = season;    // задаем поле SEASON (перечисление)
    }

    public LocalDate getStartOfSeason()  // возвращаем начальную дату для текущего сезона
    {
        return SEASON.getStartDate();
    }

    public LocalDate getFinishOfSeason() // возвращаем конечную дату для текущего сезона
    {
        return SEASON.getFinishDate();
    }

    @Override
    public String additionalInformation()  // возвращаем строку о начальной/конечной дате сезона
    {
        return "Дата начала сезона=" + getStartOfSeason() + ", Дата конца сезона=" + getFinishOfSeason();
    }

    @Override  //маркер переопределения метода (если нарушены правила - ошибка компиляции)
    protected boolean specialCheck() //Метод проверяет - текущая дата входит ли в выбраный сезон
    {
        LocalDate now = LocalDate.now();
        if (now.isAfter(getStartOfSeason()) && now.isBefore(getFinishOfSeason())) {
            return true;
        }
        return false;
    }

}
