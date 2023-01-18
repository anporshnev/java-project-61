package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    private static final int MAX_RANDOM_NUMBER = 100;

    public static void startGame() {
        for (var i = 0; i < Engine.REQUIRED_NUMBER_ATTEMPTS; i++) {
            var randomNumber = Engine.RANDOM.nextInt(MAX_RANDOM_NUMBER) + 1;
            var trueAnswer = randomNumber % 2 == 0 ? "yes" : "no";
            Engine.QUESTIONS[i] = Integer.toString(randomNumber);
            Engine.TRUE_ANSWERS[i] = trueAnswer;
        }
        Engine.greet();
        Engine.showTaskDescription("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Engine.startTask();
    }
}
