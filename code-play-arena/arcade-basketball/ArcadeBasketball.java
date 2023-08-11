import java.util.Scanner;

public class ArcadeBasketball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        while (true) {
            System.out.println("Enter your name or type \"quit\" to exit:");
            String playerName = scanner.nextLine();
            if (playerName.equals("quit")) {
                break;
            }
            System.out.println("Enter the name of your NBA team:");
            String teamName = scanner.nextLine();
            System.out.println("Enter the names of 10 players in your team:");
            String[] playerNames = new String[10];
            for (int i = 0; i < playerNames.length; i++) {
                System.out.print((i + 1) + ". ");
                playerNames[i] = scanner.nextLine();
            }
            Player player = game.addPlayer(playerName, teamName, playerNames);
            if (player != null) {
                System.out.println("Welcome, " + player.getName() + "!");
                game.play(player);
                System.out.println("Your total score is: " + player.getScore());
                if (player.getScore() < 50) {
                    System.out.println("Sorry, you lost.");
                } else {
                    System.out.println("Congratulations, you win!");
                }
            } else {
                System.out.println("Sorry, the player name \"" + playerName + "\" is invalid.");
            }
        }
        game.displayScores();
    }
}

