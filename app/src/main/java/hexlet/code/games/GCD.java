package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    public static void startGame() {
        for (var i = 0; i < Engine.REQUIRED_NUMBER_ATTEMPTS; i++) {
            var firstRandomNumber = Engine.random.nextInt(100) + 1;
            var twoRandomNumber = Engine.random.nextInt(100) + 1;
            var gcd = Integer.toString(gcd(firstRandomNumber, twoRandomNumber));

            Engine.questions[i] = "%s %s".formatted(firstRandomNumber, twoRandomNumber);
            Engine.trueAnswers[i] = gcd;
        }

        Engine.greet();
        Engine.showTaskDescription("Find the greatest common divisor of given numbers.");
        Engine.startTask();
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            var tempValue = a % b;
            a = b;
            b = tempValue;
        }
        return a;
    }
}
