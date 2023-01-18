package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    private static final int MAX_RANDOM_NUMBER = 100;
    private static final int MAX_RANDOM_INDEX = 3;

    public static void startGame() {
        for (var i = 0; i < Engine.REQUIRED_NUMBER_ATTEMPTS; i++) {
            String[] operands = {"+", "-", "*"};
            var firstRandomNumber = Engine.RANDOM.nextInt(MAX_RANDOM_NUMBER) + 1;
            var twoRandomNumber = Engine.RANDOM.nextInt(MAX_RANDOM_NUMBER) + 1;
            var randomIndex = Engine.RANDOM.nextInt(MAX_RANDOM_INDEX);
            var operand = operands[randomIndex];

            var trueAnswer = switch (operand) {
                case "+" -> Integer.toString(firstRandomNumber + twoRandomNumber);
                case "-" -> Integer.toString(firstRandomNumber - twoRandomNumber);
                default -> Integer.toString(firstRandomNumber * twoRandomNumber);
            };

            Engine.QUESTIONS[i] = "%s %s %s".formatted(firstRandomNumber, operand, twoRandomNumber);
            Engine.TRUE_ANSWERS[i] = trueAnswer;
        }

        Engine.greet();
        Engine.showTaskDescription("What is the result of the expression?");
        Engine.startTask();
    }
}
