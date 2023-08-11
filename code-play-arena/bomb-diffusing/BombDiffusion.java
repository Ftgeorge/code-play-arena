import java.util.Scanner;

public class BombDiffusion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        while (true) {
            System.out.println("Enter your name or type \"quit\" to exit:");
            String playerName = scanner.nextLine();
            if (playerName.equals("quit")) {
                break;
            }
            Player player = game.addPlayer(playerName);
            if (player != null) {
                System.out.println("Welcome, " + player.getName() + "!");
                game.play(player);
                System.out.println("Your score is: " + player.getScore());
            } else {
                System.out.println("Sorry, the player name \"" + playerName + "\" is invalid.");
            }
        }
        game.displayScores();
    }
}

