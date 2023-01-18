package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    private static final int MAX_RANDOM_NUMBER = 100;

    public static void startGame() {
        createTasks();
        Engine.greet();
        Engine.showTaskDescription("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        Engine.startTask();
    }

    private static void createTasks() {
        for (var i = 0; i < Engine.REQUIRED_NUMBER_ATTEMPTS; i++) {
            var randomNumber = Engine.random.nextInt(MAX_RANDOM_NUMBER) + 1;
            var trueAnswer = isPrime(randomNumber) ? "yes" : "no";
            Engine.QUESTIONS[i] = Integer.toString(randomNumber);
            Engine.TRUE_ANSWERS[i] = trueAnswer;
        }
    }

    private static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        var startNumber = 2;
        while (startNumber < number) {
            if (number % startNumber == 0) {
                return false;
            }
            startNumber++;
        }
        return true;
    }
}
