package rockpaperscissors;

import java.util.*;

public class RockPaperScissors {

    public static Scanner input = new Scanner(System.in);
    public static Random random = new Random();
    public static String[] choices = new String[]{"ROCK", "PAPER", "SCISSORS"};
    public static int current = 0;
    public static int userScore = 0;
    public static int compScore = 0;
    public static int rounds = 0;

    public static void main(String[] args) {
        gameplay();
    }

    public static void gameplay() {

        boolean x = true;
        System.out.println("Welcome to Rock Paper Scissors!");
        System.out.println("Please choose how many rounds you want to play: ");
        while (x == true) {
            try {
                rounds = input.nextInt();
                x = false;
            } catch (Exception e) {
                System.out.println("Please enter a number: ");
                input.next();
            }
        }

        while (current < rounds) {
            String compChoice = choices[random.nextInt(3)];
            System.out.println("Please make your choice (Rock/Paper/Scissors): ");
            String userChoice = input.nextLine();
            userChoice = input.next();
            userChoice = userChoice.toUpperCase();
            System.out.println("You picked: " + userChoice);
            System.out.println("The computer picked: " + compChoice);

            if (userChoice.equals(compChoice)) {
                System.out.println("It was a draw!");
            } else if (userChoice.equals("ROCK")) {
                if (compChoice.equals("PAPER")) {
                    System.out.println("You lose!");
                    compScore = compScore + 1;
                } else if (compChoice.equals("SCISSORS")) {
                    System.out.println("You win!");
                    userScore = userScore + 1;
                }
            } else if (userChoice.equals("PAPER")) {
                if (compChoice.equals("SCISSORS")) {
                    System.out.println("You lose!");
                    compScore = compScore + 1;
                } else if (compChoice.equals("ROCK")) {
                    System.out.println("You win!");
                    userScore = userScore + 1;
                }
            } else if (userChoice.equals("SCISSORS")) {
                if (compChoice.equals("ROCK")) {
                    System.out.println("You lose!");
                    compScore = compScore + 1;
                } else if (compChoice.equals("PAPER")) {
                    System.out.println("You win!");
                    userScore = userScore + 1;
                }
            }
            current = current + 1;
        }
        System.out.println("You had " + userScore + " points...");
        System.out.println("The computer had " + compScore + " points...");
        if (userScore >= compScore) {
            System.out.println("You win!");
        } else {
            System.out.println("You lost!");
        }
        replay();
    }

    public static void replay() {
        System.out.println("Would you like to play again (Y/N): ");
        String replay = input.nextLine();
        replay = input.nextLine();
        if (replay.equalsIgnoreCase("Y")) {
            gameplay();
        }
    }
}
