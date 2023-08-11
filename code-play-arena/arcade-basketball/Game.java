import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
  private static final int NUM_PLAYERS = 10;
  private static final int TIME_LIMIT = 10;
  private List<Player> players;

  public Game() { players = new ArrayList<>(); }

  public Player addPlayer(String name, String teamName, String[] playerNames) {
    if (name == null || name.trim().isEmpty()) {
      return null;
    }
    if (teamName == null || teamName.trim().isEmpty()) {
      return null;
    }
    if (playerNames == null || playerNames.length != NUM_PLAYERS) {
      return null;
    }
    for (String playerName : playerNames) {
      if (playerName == null || playerName.trim().isEmpty()) {
        return null;
      }
    }
    Player player = new Player(name, teamName, playerNames);
    players.add(player);
    return player;
  }

  public void play(Player player) {
    int numCorrect = 0;
    Scanner scanner = new Scanner(System.in);
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < NUM_PLAYERS; i++) {
      System.out.print("Player " + (i + 1) + " ");
      String guess = scanner.nextLine();
      if (guess.equalsIgnoreCase(player.getPlayerNames()[i])) {
        System.out.println("Good shot!");
        player.addScore(10);
        numCorrect++;
      }
      if (System.currentTimeMillis() - startTime >= TIME_LIMIT * 1000) {
        break;
      }
    }
    int numIncorrect = NUM_PLAYERS - numCorrect;
    if (numIncorrect > 0) {
      System.out.println("You missed " + numIncorrect + " player(s).");
    }
  }

  public void displayScores() {
    System.out.println("Final Scores:");
    for (Player player : players) {
      System.out.println(player.getName() + " (" + player.getTeamName() +
                         "): " + player.getScore());
    }
  }
}
