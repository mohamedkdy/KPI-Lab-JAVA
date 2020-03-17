import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        SkiPassForLifts skiPassForLifts = new SkiPassForLifts(1, true, NumberOfLifts.TEN);
        Turnstile turnstile = new Turnstile();

        for (int i = 1; i < 15; i++) {
            System.out.println("Проход номер " + i + ": " + turnstile.verify(skiPassForLifts));
        }
    }
}
