public class PlayerInfo {
    private final String name;
    private final double winRate;
    private final int numWins;
    private final int numLosses;
    private final String position;
    private String notes;
    private String reasons;

    public PlayerInfo(Player player) {
        this.name = player.getName();
        this.winRate = player.getWinRate();
        this.numWins = player.getWins();
        this.numLosses = player.getLosses();
        this.position = player.getPreferredPosition();
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setReasonsForBlacklist(String reasons) {
        this.reasons = reasons;
    }

    public String getNotes() {
        return notes;
    }

    public String getReasonsForBlacklist() {
        return reasons;
    }

    public String getName() {
        return name;
    }

    public double getWinRate() {
        return winRate;
    }

    public int getNumWins() {
        return numWins;
    }

    public int getNumLosses() {
        return numLosses;
    }

    public String getPosition() {
        return position;
    }
}


