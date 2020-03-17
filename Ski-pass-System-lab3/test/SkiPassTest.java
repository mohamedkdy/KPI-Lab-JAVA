import static org.junit.Assert.*;
import org.junit.Test;

public class SkiPassTest
{
    @Test
    public void testVerify_IsReturnFalseIfAlreadyBlocked() // проверка блокировки карты
    {
        SkiPass skiPassForDays = new SkiPassForDays(1, false, NumberOfDays.ONE);
        skiPassForDays.setBlocked(true); // блокировка карты
        assertFalse(skiPassForDays.verify()); // проверка на блокировку
    }



    @Test
    public void testVerify_Clone() // проверка успешности глубокого копирования обьекта SkiPass
    {
        SkiPass skiPassForDays = new SkiPassForDays(1, false, NumberOfDays.ONE); //
        SkiPass skiPassForDays2;
        skiPassForDays2=skiPassForDays.clone(); // копирование
        assertEquals(skiPassForDays2.isAccessForHolidays(),skiPassForDays.isAccessForHolidays()); // проверка на то что обьекты хранят одинаковые значения поля ACCESS_FOR_HOLIDAYS
                                                                                                    // это общее поле от данного базового класса
    }
 }
