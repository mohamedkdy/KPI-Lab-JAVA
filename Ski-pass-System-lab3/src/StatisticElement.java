import java.time.LocalDateTime;

/** Класс определяет статистику проверки карты на турникете, хранится в классе SkiPassSystem в List<StatisticlEment> statistic*/
public class StatisticElement
{
    private final SkiPass SKI_PASS; // обьект класса SkiPass - описывает созданную карту SkiPass
    private final boolean VERIFYING_RESULT; // хранит результат проверки карты на турникете
    private final LocalDateTime DATE; // хранит дату проверки крты на турникете

    public StatisticElement(SkiPass sp, boolean verifyingResult, LocalDateTime date) // конструктор с параметрами
    {
        this.SKI_PASS = sp;
        this.VERIFYING_RESULT = verifyingResult;
        this.DATE = date;
    }

    public SkiPass getSKI_PASS()  // возвращаем обьект класса SkiPass (описывает карты)
    {
        return SKI_PASS;
    }
    public boolean isVERIFYING_RESULT()  //возвращаем результат проверки карты на турникете
    {
        return VERIFYING_RESULT;
    }

    public LocalDateTime getDATE()// возвращаем  дату проверки карты на турникете
    {
        return DATE;
    }
}
