import java.util.Random;
import java.util.Scanner;

public class RPS {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        boolean runProgram = true;
        System.out.println("Let's Play Rock, Paper, Scissors");

        while (runProgram) {

            int userScore = 0;
            int compScore = 0;

            while (userScore < 5 && compScore < 5) {
                int choice = getChoice(input);
                int compChoice = rand.nextInt(3) + 1;

                System.out.println("User has: " + showPick(choice));
                System.out.println("Computer has: " + showPick(compChoice));

                String win = winner(choice, compChoice);
                System.out.println(win);

                if (win.equals("User wins!")) {
                    userScore++;
                } else if (win.equals("Computer wins!")) {
                    compScore++;
                }

                System.out.println("Score → User: " + userScore + " | Computer: " + compScore);
                System.out.println();
            }

            System.out.println("Game Over!");
            if (userScore > compScore) {
                System.out.println("User wins the match!");
            } else {
                System.out.println("Computer wins the match!");
            }

            System.out.println("Final Score:");
            System.out.println("User: " + userScore);
            System.out.println("Computer: " + compScore);
            System.out.println();

            System.out.print("Do you want to play again? (y/n): ");
            String again = input.next();

            if (!again.equalsIgnoreCase("y")) {
                runProgram = false;
                System.out.println("Thank you for playing!");
            }
        }

        input.close();
    }

    public static String showPick(int value) {
        switch (value) {
            case 1: return "Rock";
            case 2: return "Paper";
            case 3: return "Scissors";
            default: return "";
        }
    }

    public static String winner(int choice, int compChoice) {
        if (choice == compChoice) {
            return "Tie";
        } else if ((choice == 1 && compChoice == 3) ||
                (choice == 2 && compChoice == 1) ||
                (choice == 3 && compChoice == 2)) {
            return "User wins!";
        } else {
            return "Computer wins!";
        }
    }

    public static int getChoice(Scanner input) {
        System.out.print("Enter 1 for Rock, 2 for Paper, or 3 for Scissors: ");
        int choice = input.nextInt();

        while (choice < 1 || choice > 3) {
            System.out.println("Invalid input! Please try again.");
            System.out.print("Enter 1 for Rock, 2 for Paper, or 3 for Scisors: ");
            choice = input.nextInt();
        }

        return choice;
    }
}

