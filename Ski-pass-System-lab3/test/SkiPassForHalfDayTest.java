import static org.junit.Assert.*;
import org.junit.Test;

public class SkiPassForHalfDayTest
{

    @Test
    public void testVerify_IsReturnTrueIfCorrespondingTimeIsNow1() {
        SkiPassForHalfDay skiPassForHalfDay = new SkiPassForHalfDay(1, true, HalfOfDay.FIRST_HALF);
      //  assertTrue(skiPassForHalfDay.verify());

      assertFalse(skiPassForHalfDay.verify()); // выбор в зависимости от времени суток
        // выбор в зависимости от текущей половины дня
    }

    /*@Test
    public void testVerify_IsReturnTrueIfCorrespondingTimeIsNow2()
    {
        SkiPassForHalfDay skiPassForHalfDay = new SkiPassForHalfDay(1, true, HalfOfDay.SECOND_HALF);
       // assertTrue(skiPassForHalfDay.verify());
        assertFalse(skiPassForHalfDay.verify()); // выбор в зависимости от времени суток
    }    */

    @Test
    public void testVerify_cloneHalfDays() // проверка успешности глубокого копирования обьекта SkiPassForHalfDay
    {
        SkiPass skiPassForHalfDay1 = new SkiPassForHalfDay(1, true, HalfOfDay.SECOND_HALF);
        //создаем обьект класса SkiPassForHalfDay, и передаем его ссылке типа базового класса

        SkiPass skiPassForHalfDay2;
        skiPassForHalfDay2 =skiPassForHalfDay1.clone(); // копирование
        assertEquals(((SkiPassForHalfDay) skiPassForHalfDay1).getFinishTime(),((SkiPassForHalfDay)skiPassForHalfDay2).getFinishTime());
        // перед сравнение приведем обьекты к от типа базового класса (SkiPass) к классу наследнику (SkiPassForHalfDay)
        // проверка на то что обьекты хранят одинаковые значения  перечисления FINISH_TIME
    }

}