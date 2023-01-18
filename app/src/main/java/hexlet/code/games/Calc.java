package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    public static void startGame() {
        for (var i = 0; i < Engine.REQUIRED_NUMBER_ATTEMPTS; i++) {
            String[] operands = {"+", "-", "*"};
            var firstRandomNumber = Engine.random.nextInt(100) + 1;
            var twoRandomNumber = Engine.random.nextInt(100) + 1;
            var randomIndex = Engine.random.nextInt(3);
            var operand = operands[randomIndex];

            var trueAnswer = switch (operand) {
                case "+" -> Integer.toString(firstRandomNumber + twoRandomNumber);
                case "-" -> Integer.toString(firstRandomNumber - twoRandomNumber);
                default -> Integer.toString(firstRandomNumber * twoRandomNumber);
            };

            Engine.questions[i] = "%s %s %s".formatted(firstRandomNumber, operand, twoRandomNumber);
            Engine.trueAnswers[i] = trueAnswer;
        }

        Engine.greet();
        Engine.showTaskDescription("What is the result of the expression?");
        Engine.startTask();
    }
}
