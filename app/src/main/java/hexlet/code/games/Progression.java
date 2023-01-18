package hexlet.code.games;

import hexlet.code.Engine;

import java.util.StringJoiner;

public class Progression {
    private static final int MAX_RANDOM_NUMBER = 100;
    private static final int PROGRESSION_LENGTH = Engine.RANDOM.nextInt(5, 11);
    private static final int[] PROGRESSION = new int[PROGRESSION_LENGTH];
    private static String trueAnswer;

    public static void startGame() {
        for (var i = 0; i < Engine.REQUIRED_NUMBER_ATTEMPTS; i++) {
            generateProgression();
            Engine.QUESTIONS[i] = generateQuestion();
            Engine.TRUE_ANSWERS[i] = trueAnswer;
        }
        Engine.greet();
        Engine.showTaskDescription("What number is missing in the progression?");
        Engine.startTask();
    }

    private static void generateProgression() {
        var startNumber = Engine.RANDOM.nextInt(MAX_RANDOM_NUMBER) + 1;
        var step = Engine.RANDOM.nextInt(MAX_RANDOM_NUMBER) + 1;

        var currentNumber = startNumber;
        for (int j = 0; j < PROGRESSION_LENGTH; j++) {
            PROGRESSION[j] = currentNumber;
            currentNumber += step;
        }
    }

    private static String generateQuestion() {
        var indexHiddenElement = Engine.RANDOM.nextInt(PROGRESSION_LENGTH);
        var result = new StringJoiner(" ");

        for (int i = 0; i < PROGRESSION_LENGTH; i++) {
            var currentValue = Integer.toString(PROGRESSION[i]);
            if (i == indexHiddenElement) {
                result.add("..");
                trueAnswer = currentValue;
            } else {
                result.add(currentValue);
            }
        }
        return result.toString();
    }
}
