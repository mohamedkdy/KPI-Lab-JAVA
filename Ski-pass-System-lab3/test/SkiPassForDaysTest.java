import static org.junit.Assert.*;
import org.junit.Test;
import java.time.LocalDate;

public class SkiPassForDaysTest
{
    @Test
    public void testVerify_IsSetStartUseAfterFirstVerifying() // проверка активирована ли карта
    {
        SkiPassForDays skiPassForDays = new SkiPassForDays(1, true, NumberOfDays.ONE);
        skiPassForDays.verify(); // вызов метода проверки карты, который её активирует
        assertTrue(skiPassForDays.isActivated()); // проверка активации карты
    }

    @Test
    public void testVerify_IsSetBlockedDateCorrectlyAfterFirstVerifying() // проверка даты блокировки 2-дневной карты
    {
        SkiPassForDays skiPassForDays = new SkiPassForDays(1, true, NumberOfDays.TWO);
        skiPassForDays.verify();// вызов метода проверки карты, который её активирует

        LocalDate nextDate = LocalDate.now().plusDays(2); // установка будущей даты
        assertEquals(nextDate, skiPassForDays.getBlockDate()); // проверка дня блокировки
    }

    @Test
public void testVerify_cloneDays() // проверка успешности глубокого копирования обьекта SkiPassForDays
{
    SkiPass skiPassForDays1 = new SkiPassForDays(1, true, NumberOfDays.FIVE);
    //создаем обьект класса SkiPassForDays, и передаем его ссылке типа базового класса

    SkiPass skiPassForDays2;
    skiPassForDays2 =skiPassForDays1.clone(); // копирование
    assertEquals(((SkiPassForDays) skiPassForDays1).getNumberOfDays(),((SkiPassForDays)skiPassForDays2).getNumberOfDays());
    // перед сравнение приведем обьекты к от типа базового класса (SkiPass) к классу наследнику (SkiPassForDays)
    // проверка на то что обьекты хранят одинаковые значения  перечисления NUMBER_OF_DAYS
}

 }