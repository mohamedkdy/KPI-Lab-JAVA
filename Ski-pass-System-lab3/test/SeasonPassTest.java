import static org.junit.Assert.*;
import org.junit.Test;

public class SeasonPassTest
{

    @Test
    public void testVerify_IsReturnFalseIfCorrespondingSesonIsNotNow() // проверка если сезон не сейчас
    {
        SeasonPass seasonPass = new SeasonPass(1, Season.HIGHT_SEASON_NEXT_YEAR);
        assertFalse(seasonPass.verify());
    }

    @Test
    public void testVerify_IsSetBlockIfCorrespondingSesonIsNotNow() //проверка на блокировку если сезон не сейчас
    {
        SeasonPass seasonPass = new SeasonPass(1, Season.LOW_SEASON_BEFORE);
        seasonPass.verify(); // вызов метода проверки карты, который её блокирует,т.к сезон не начался
        assertTrue(seasonPass.isBlocked());
    }
    @Test
    public void testVerify_testVerify_cloneSeason() // проверка успешности глубокого копирования обьекта SeasonPass
    {
        SkiPass seasonPass1 = new SeasonPass(1, Season.LOW_SEASON_AFTER_NEXT_YEAR);
        //создаем обьект класса SeasonPass, и передаем его ссылке типа базового класса

        SkiPass seasonPass2;
        seasonPass2 =seasonPass1.clone(); // копирование
        assertEquals(((SeasonPass) seasonPass1).getStartOfSeason(),((SeasonPass)seasonPass2).getStartOfSeason());
        // перед сравнение приведем обьекты к от типа базового класса (SkiPass) к классу наследнику (SeasonPass)
        // проверка на то что обьекты хранят одинаковые значения  перечисления SEASON.START_DATE
    }
}
