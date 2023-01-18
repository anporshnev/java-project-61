package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    public static void startGame() {
        for (var i = 0; i < Engine.REQUIRED_NUMBER_ATTEMPTS; i++) {
            var randomNumber = Engine.random.nextInt(100) + 1;
            var trueAnswer = randomNumber % 2 == 0 ? "yes" : "no";
            Engine.questions[i] = Integer.toString(randomNumber);
            Engine.trueAnswers[i] = trueAnswer;
        }
        Engine.greet();
        Engine.showTaskDescription("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Engine.startTask();
    }
}
