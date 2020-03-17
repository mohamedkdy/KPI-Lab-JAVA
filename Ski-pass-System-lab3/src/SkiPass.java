import java.time.DayOfWeek;
import java.time.LocalDate;

/** Написати програму, яка моделює роботу вбудованого процесора турнікету лижного підйомника щодо перевірки доступу по skipass.
 Турнікет контролює вхід лижників на підйомник по ski-pass. Ski-pass бувають наступних видів:
 1. На робочі дні:
 a. Без обліку кількості підйомів: на півдня (з 9 до 13 або з 13 до 17), на день, два дні, 5 днів.
 b. По кількості підйомів: на 10 підйомів, на 20 підйомів, на 50 підйомів, на 100 підйомів.
 2. На вихідні дні (---т.е. все дни включая рабочие и выходные---):
 a. Без обліку кількості поїздок: на півдня (з 9 до 13 або з 13 до 17), на день, два дні.
 b. По кількості підйомів: на 10 підйомів, на 20 підйомів, на 50 підйомів, на 100 підйомів.
 3. Абонемент на сезон.
 Турнікет повинен бути зв’язаний з системою, в який ведеться реєстр виданих карток. В цій системі можливо:
 а. випустити ski-pass;
 б. заблокувати ski-pass через порушення правил підйому.
 Дані щодо картки зберігаються на самій картці, а саме: унікальний ідентифікатор, тип картки, термін дії, кількість поїздок тощо.
 Турнікет зчитує дані з картки та виконує її перевірку. Якщо дані не вдалося зчитати, чи картка прострочена, чи заблокована, чи на ній не
 залишилося кредитів для поїздок, то прохід заборонено. Інакше з картки знімається одна поїздка (якщо для картки передбачається облік підйомів) і
 прохід дозволяється.
 Турнікет здійснює облік дозволів та відмов проходу. При цьому турнікет вміє видавати по запиту:
 1) сумарні дані та 2) дані розбиті по типах ski-pass

 1. Успадкування повинно бути застосоване для побудови ієрархії типів проїзних документів.
 2. Інкапсуляція повинна бути застосована для приховування даних щодо проїзних документів, а також деталей реалізації процесору турнікету.
 3. Поліморфізм повинен бути застосований для перевірки дійсності картки та списання з неї поїздки

 * */

/**Основной класс для определения карт SkiPass. Содержит общие поля и методы.*/

public abstract class SkiPass implements Cloneable // класс реализует интерфейс Cloneable (интерфейс не реализует ни одного метода,
                                                    //а яв.  маркером, говорящим, что данный класс реализует клонирование (глубокое)объекта - метод Clone()
{
    private final long SKI_PASS_ID;  // уникальный ID для карты
    private boolean blocked;  // состояние карты (заблокирована или нет)
    private final boolean ACCESS_FOR_HOLIDAYS;  //доступ в праздничные и выходные дни


    public SkiPass(long skiPassId, boolean accessForHolidays)  // конструктор (принимает номер карты и доступ по выходным)
    {
        this.SKI_PASS_ID = skiPassId;
        this.blocked = false;
        this.ACCESS_FOR_HOLIDAYS = accessForHolidays;
    }

    public boolean isBlocked() // возвращаем состояние карты (заблокирована или нет)
    {
        return blocked;
    }
    public void setBlocked(boolean blocked) // установка состояние карты (заблокирована или нет)
    {
        this.blocked = blocked;
    }
    public boolean isAccessForHolidays()  // возвращаем состояние карты - есть ли доступ  в праздничные и выходные дни
    {
        return ACCESS_FOR_HOLIDAYS;
    }

    @Override  // Переопределение toString
    public String toString()
    {
        String result = "Карта ID=" + SKI_PASS_ID + ", Заблокировна=" + blocked + ", Доступ на выходных=" + ACCESS_FOR_HOLIDAYS;
        result += ", " + additionalInformation();
        return result;
    }

    public SkiPass clone()  // копирование обьекта (в классе Turnstile (турникет) для добавления элемента класса skiPass в лист статистики)
    {
        SkiPass sp = null; // инициальзация обьекта класса SkiPass
        try
        {
            sp =  (SkiPass) super.clone(); //  клонирование (глубокое) объекта и возвращение его sp c явным преобразованием
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        return sp;
    }

    public abstract String additionalInformation(); //абстрактный метод добавляет доп. информацию о конкретном типе карты SkiPass к стандартному описанию toString() переоредилим в наследниках

    public boolean verify()  //роверка данных карты для авторизации или отказа в поездке. Блокирует карту (blocked - true) если на карте нет поездок или нет доступа.
    {
        if (standartCheck())  //проверяет заблокирована ли уже карта, совпадают ли параметра доступа (рабочий / выходной день)
        {
            if (specialCheck())
            {
                return true;
            }
            else
            {
                setBlocked(true); // блокировка любого типа карты
            }
        }
        return false;
    }

    public boolean standartCheck() //Метод проверяет заблокирована ли карта, совпадают ли параметра доступа (рабочий / выходной день)
     {
        if (isBlocked() || (checkForHolidays(LocalDate.now()) && !isAccessForHolidays()))  //0 ||( 1 && 0) - выходной  0 || (0 && 1)
        {
            return false;
        }
        return true;
     }

    boolean checkForHolidays(LocalDate date) //Метод проверят входящую дату - это праздник или выходной
    {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SUNDAY || dayOfWeek == DayOfWeek.SATURDAY ) {
            return true;
        }
        return false;
    }

      protected abstract boolean specialCheck(); // полиморфизм (произойдет вызов нужной реализации метода из текущего класса наследника)
                                                //абстрактный метод  - проверяет доп. условия для карты SkiPass - переоредилим в наследниках
}
