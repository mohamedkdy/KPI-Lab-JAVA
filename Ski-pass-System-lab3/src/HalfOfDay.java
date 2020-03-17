import java.time.LocalDate;
import java.time.LocalDateTime;

public enum HalfOfDay // перечисление для определения нужной половины дня - для карты SkiPassForHalfDay
{
    FIRST_HALF // константы перечисления, для создания используем конструктор (START_TIME: 9:00 , FINISH_TIME: 13:00)
            (
                    LocalDateTime.of(
                            LocalDate.now().getYear(),
                            LocalDate.now().getMonth(),
                            LocalDate.now().getDayOfMonth(),
                            9, 0),

                    LocalDateTime.of(
                            LocalDate.now().getYear(),
                            LocalDate.now().getMonth(),
                            LocalDate.now().getDayOfMonth(),
                            13, 0)
            ),
    SECOND_HALF // константы перечисления, для создания используем конструктор (START_TIME: 13:00 , FINISH_TIME: 17:00)
            (
                    LocalDateTime.of(
                            LocalDate.now().getYear(),
                            LocalDate.now().getMonth(),
                            LocalDate.now().getDayOfMonth(),
                            13, 0),

                    LocalDateTime.of(
                            LocalDate.now().getYear(),
                            LocalDate.now().getMonth(),
                            LocalDate.now().getDayOfMonth(),
                            17, 0)
            );

    private final LocalDateTime START_TIME; // поле хранит время начала работы карты на пол дня
    private final LocalDateTime FINISH_TIME; // поле хранит время окончания работы карты на пол дня

    HalfOfDay(LocalDateTime startTime, LocalDateTime finishTime)  // конструктор для перечисления
    {
        this.START_TIME = startTime;
        this.FINISH_TIME = finishTime;
    }

    public LocalDateTime get_StartTime() // возвращает время начала работы карты на пол дня
    {
        return START_TIME;
    }

    public LocalDateTime get_FinishTime() // возвращает время окончания работы карты на пол дня
    {
        return FINISH_TIME;
   }
}
