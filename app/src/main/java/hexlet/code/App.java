package hexlet.code;

import hexlet.code.games.GCD;
import hexlet.code.games.Calc;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;
import hexlet.code.games.Even;

import java.util.Scanner;

public class App {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        String menuItems = """
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit
                """;
        System.out.println("Please enter the game number and press Enter.");
        System.out.println(menuItems);
        System.out.print("Your choice: ");
        String choice = SCANNER.next();

        switch (choice) {
            case "1" -> Engine.greet();
            case "2" -> Even.startGame();
            case "3" -> Calc.startGame();
            case "4" -> GCD.startGame();
            case "5" -> Progression.startGame();
            case "6" -> Prime.startGame();
            case "0" -> { }
            default -> System.out.println("There is no game under this number!");
        }
        SCANNER.close();
    }
}
