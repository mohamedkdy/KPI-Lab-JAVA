import org.junit.Test;

import static org.junit.Assert.*;


public class SkiPassSystemTest {


    @Test
    public void addSkiPassToList()  // проверка количества изданых карт
    {
        SkiPassSystem sps = new SkiPassSystem(); //Класс хранит статистику использования и создания карт
        SkiPass sp1 = new SkiPassForDays(1, true, NumberOfDays.ONE);
        sps.addSkiPass(sp1);

        SkiPass sp2 = new SkiPassForDays(1, true, NumberOfDays.ONE);
        sps.addSkiPass(sp2);

        assertEquals(2, sps.GetSkiPassCounter()); // т.к. добавлена 1 карта
    }

}