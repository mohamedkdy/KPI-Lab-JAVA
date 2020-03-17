import java.time.LocalDateTime;
import java.util.List;


/** Класс описывает  турникет, который проверяет лыжные карты SkiPass и делает записи об использовании карт.*/
public class Turnstile
{
    //возвращаем ссылку на лист StatisticlEment со статистикой проверки (использования) карты на турникете из класса SkiPassSystem class
    //для возможности добавление инфы картах */

    private static List<StatisticElement> statistic1 = SkiPassSystem.getStatistic();

    public Turnstile() //конструктор по умолчанию
    {    }

      public boolean verify(SkiPass skiPass) //Метод проверяет карты SkiPass и записи (добавляет элемент в листе статистике) о проверке
    {
        boolean verifyingResult = skiPass.verify(); // полиморфизм (в зависимости от типа карты метод verify реализован по разному)
        statistic1.add(new StatisticElement(skiPass.clone(), verifyingResult, LocalDateTime.now()));//добавляет элемент в листе статистике
        return verifyingResult;
    }

}
