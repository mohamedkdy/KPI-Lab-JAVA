import static org.junit.Assert.*;
import org.junit.Test;


public class SkiPassForLiftsTest
{
    @Test
    public void testVerify_IsReturnTrueIfNotBlockedAndLiftsStillHave() // проверка карты
    {
        SkiPassForLifts skiPassForLifts = new SkiPassForLifts(1, true, NumberOfLifts.TEN);
        assertTrue(skiPassForLifts.verify());
    }

    @Test
    public void testVerify_IsReturnFalseIfLiftsNotLeft() // проверка карты на 20 поездок после 20 проездок
    {
        SkiPass skiPassForLifts = new SkiPassForLifts(1, true, NumberOfLifts.TWENTY);  // полиморфизм - вызывам через ссылку на базовый класс
        for(int i = 0; i < 20; i++) {
            skiPassForLifts.verify();  // осуществление 20 проверок (поездок)
        }
        assertFalse(skiPassForLifts.verify()); // проверка 21-ая
    }

    @Test
    public void testVerify_IsSetBlockIfLiftsNotLeft() // проверка карты на 50 поездок после 50 проездок на блокировку
    {
        SkiPassForLifts skiPassForLifts = new SkiPassForLifts(1, true, NumberOfLifts.FIFTY);
        for(int i = 0; i < 51; i++) {
            skiPassForLifts.verify(); // осуществление 11 проверок (поездок)
        }
        assertTrue(skiPassForLifts.isBlocked());
    }

    @Test
    public void testGetNumberOfLiftsLeft_IsWorkCorrectly() // проверка оставшихся поездок (99 из 100)
    {
        SkiPassForLifts skiPassForLifts = new SkiPassForLifts(1, true, NumberOfLifts.ONE_HUNDRED);
        skiPassForLifts.verify(); // осуществление 1 проверки (поездки)
        int expected = 99;
        assertEquals(expected, skiPassForLifts.getNumberOfLiftsLeft());
    }

    @Test
    public void testVerify_cloneLifts() // проверка успешности глубокого копирования обьекта SkiPassForLifts
    {
        SkiPass skiPassForLifts1 = new SkiPassForLifts(1, true, NumberOfLifts.ONE_HUNDRED);
        //создаем обьект класса SkiPassForDays, и передаем его ссылке типа базового класса

        SkiPass skiPassForLifts2;
        skiPassForLifts2 =skiPassForLifts1.clone(); // копирование
        assertEquals(((SkiPassForLifts) skiPassForLifts1).getNumberOfLiftsLeft(),((SkiPassForLifts)skiPassForLifts2).getNumberOfLiftsLeft());
        // перед сравнение приведем обьекты к от типа базового класса (SkiPass) к классу наследнику (SkiPassForLifts)
        // проверка на то что обьекты хранят одинаковые значения  перечисления NUMBER_OF_LIFTS
    }
}