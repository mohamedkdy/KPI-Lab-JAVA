import static org.junit.Assert.*;
import org.junit.Test;

public class TurnstileTest
{
    @Test
    public void testVerify_IsAddVerifyingToStatistic() // проверка на количество записей в листе статистики после 2-ух поездок
    {
        SkiPass sp = new SkiPassForDays(1, true, NumberOfDays.ONE);


        Turnstile t = new Turnstile(); // создание обьекта класса - турникет, который проверяет лыжные карты SkiPass
                                        //и делает записи об использовании карт (статистика).
        t.verify(sp); // провекрака карты пользователя на турникете  по карте ID=1 (1-ый подьем)
        t.verify(sp); // провекрака карты пользователя на турникете  по карте ID=1 (2-ой подьем)
        assertEquals(2, SkiPassSystem.getStatistic().size()); // т.к. сделано 2 проверки, то в листе только 2 запи
                                                                        // вызов static метода .getStatistic() с размером ArrayList
    }
}