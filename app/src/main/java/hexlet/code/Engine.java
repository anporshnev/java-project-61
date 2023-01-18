package hexlet.code;

import java.util.Random;

public class Engine {
    public static Random random = new Random();
    public static String gamerName;
    public static final int REQUIRED_NUMBER_ATTEMPTS = 3;
    public static int numberAttempts = 0;
    public static String[] questions = new String[REQUIRED_NUMBER_ATTEMPTS];
    public static String[] trueAnswers = new String[REQUIRED_NUMBER_ATTEMPTS];

    public static void greet() {
        System.out.println();
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        gamerName = App.scanner.next();
        System.out.println("Hello, " + gamerName + "!");
        App.scanner.close();
    }

    public static void showTaskDescription(String text) {
        System.out.println(text);
    }

    public static void startTask() {
        for (var i = 0; i < Engine.REQUIRED_NUMBER_ATTEMPTS; i++) {
            System.out.println("Question: " + questions[i]);
            System.out.print("Your answer: ");
            var answer = App.scanner.next();

            if (answer.equals(trueAnswers[i])) {
                System.out.println("Correct!");
            } else {
                var message = """
                        '%s' is wrong answer ;(. Correct answer was '%s'.
                        Let's try again, %s!
                        """.formatted(answer, trueAnswers[i], gamerName);
                System.out.print(message);
                break;
            }
            numberAttempts++;
        }
        if (numberAttempts == REQUIRED_NUMBER_ATTEMPTS) {
            System.out.println("Congratulations, " + gamerName + "!");
        }
        App.scanner.close();
    }
}
