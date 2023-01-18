package hexlet.code;

import java.util.Random;

public class Engine {
    public static Random random = new Random();
    private static String gamerName;
    public static final int REQUIRED_NUMBER_ATTEMPTS = 3;
    private static int numberAttempts = 0;
    public static final String[] QUESTIONS = new String[REQUIRED_NUMBER_ATTEMPTS];
    public static final String[] TRUE_ANSWERS = new String[REQUIRED_NUMBER_ATTEMPTS];

    public static void greet() {
        System.out.println();
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        gamerName = App.scanner.next();
        System.out.println("Hello, " + gamerName + "!");
    }

    public static void showTaskDescription(String text) {
        System.out.println(text);
    }

    public static void startTask() {
        for (var i = 0; i < Engine.REQUIRED_NUMBER_ATTEMPTS; i++) {
            System.out.println("Question: " + QUESTIONS[i]);
            System.out.print("Your answer: ");
            var answer = App.scanner.next();

            if (answer.equals(TRUE_ANSWERS[i])) {
                System.out.println("Correct!");
            } else {
                var message = """
                        '%s' is wrong answer ;(. Correct answer was '%s'.
                        Let's try again, %s!
                        """.formatted(answer, TRUE_ANSWERS[i], gamerName);
                System.out.print(message);
                break;
            }
            numberAttempts++;
        }
        if (numberAttempts == REQUIRED_NUMBER_ATTEMPTS) {
            System.out.println("Congratulations, " + gamerName + "!");
        }
    }
}
