public class Player {
    private String name;
    private String teamName;
    private String[] playerNames;
    private int score;

    public Player(String name, String teamName, String[] playerNames) {
        this.name = name;
        this.teamName = teamName;
        this.playerNames = playerNames;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public String getTeamName() {
        return teamName;
    }

    public String[] getPlayerNames() {
        return playerNames;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int points) {
        score += points;
    }
}

