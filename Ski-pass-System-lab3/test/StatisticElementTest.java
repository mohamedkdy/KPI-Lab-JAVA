import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class StatisticElementTest {

    @Test
    public void testVerify_IsVerifResTrue() // проверка работы конструктора класса
    {
        SkiPass skiPassForDays = new SkiPassForDays(1, false, NumberOfDays.ONE);
        StatisticElement stat1 = new StatisticElement(skiPassForDays, true, LocalDateTime.now());

        boolean date1= stat1.isVERIFYING_RESULT();

        assertTrue(date1);
    }
}