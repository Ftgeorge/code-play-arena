import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private static final int NUM_GUESSES = 5;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 5;
    private List<Player> players;
    private Random random;

    public Game() {
        players = new ArrayList<>();
        random = new Random();
    }

    public Player addPlayer(String name) {
        if (name == null || name.trim().isEmpty()) {
            return null;
        }
        Player player = new Player(name);
        players.add(player);
        return player;
    }

    public void play(Player player) {
        System.out.println("Guess a number between " + MIN_VALUE + " and " + MAX_VALUE + ":");
        int target = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
        for (int i = 0; i < NUM_GUESSES; i++) {
            int guess = readGuess();
            if (guess == target) {
                System.out.println("Congratulations, you escaped the time bomb!");
                player.addScore(NUM_GUESSES - i);
                return;
            } else {
                System.out.println("Sorry, that's not the correct number.");
            }
        }
        System.out.println("Bomb diffused! Better luck next time.");
    }

    private int readGuess() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNextInt()) {
                int guess = scanner.nextInt();
                if (guess >= MIN_VALUE && guess <= MAX_VALUE) {
                    return guess;
                }
            }
            System.out.println("Invalid guess. Please enter a number between " + MIN_VALUE + " and " + MAX_VALUE + ":");
            scanner.nextLine(); 
        }
    }

    public void displayScores() {
        System.out.println("Player Scores:");
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getScore());
        }
    }
}

