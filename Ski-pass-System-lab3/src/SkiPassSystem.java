import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



/** Класс хранит статистику использования и создания карт и может вывести её в консоль.*/
public class SkiPassSystem
{
    private static List<SkiPass> skiPasses = new ArrayList<>(); // список всех созданных карт SkiPass (любого типа)
    private static long skiPassCounter = 0; // счетчик созданых карт SkiPass (любого типа), определяет ID карт

    private static List<StatisticElement> statistic = new ArrayList<>(); // лист со статистикой проверки (использования) карты на турникете

    public SkiPassSystem() //конструктор по умолчанию
    {
    }
    public long GetSkiPassCounter () // возвращает количество изданых карт
    {
        return skiPassCounter;
    }

    static List<StatisticElement> getStatistic() // возвращает ссылку на  список статистики (исп. для обьекта класса Turnstile)
    {                                                // static - можно вызывать без обьекта, через имя класса
        return statistic;
    }

    public void addSkiPass(SkiPass sp) //Метод добавляет карту в список всех созданных карт SkiPass и увеличивает счетчик - ID карт
    {
        skiPasses.add(sp); // добавление в список всех созданных карт (всех типов)
        skiPassCounter++;  // увеличение счетчика - ID карт
    }


    public String skiPassVerifyingInfo(StatisticElement el) //Возвращает строку со статистикой проверки (использования) карты на турникете
    {
       String str= "Информация о карте SkiPass\n" + el.getSKI_PASS().toString() + "\n" + "Доступ подтвержден: "
                + el.isVERIFYING_RESULT() + ". Дата проверки: " + el.getDATE();
       return str;

    }

    public void statistic(LocalDateTime since, LocalDateTime till) //Метод для вывода на консоль статистики использования карт указанного типа  за указанный период
    {
        for(StatisticElement el: statistic) // перебор листа со статистикой проверки (использования) карт на турникете (еl - для каждого прохода через турникет)
        {
            LocalDateTime date = el.getDATE(); // дата проверки карты на турникете для каждого элемента в листе
            if(  date.isAfter(since)  &&  date.isBefore(till)   ) // вывод инфо из списка при условии
            {
                System.out.println(skiPassVerifyingInfo(el)); // вывод в консоль строку со статистикой проверки (использования) карты на турникете
            }
        }
    }

}
