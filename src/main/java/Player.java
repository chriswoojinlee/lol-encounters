import com.merakianalytics.orianna.types.common.Queue;
import com.merakianalytics.orianna.types.core.summoner.Summoner;

import java.util.ArrayList;

// Represents a player and his/her stats
public class Player {
    private String name;                       // summoner name
    private int wins;                          // overall number of ranked solo/duo queue wins
    private int losses;                        // overall number of solo/duo queue losses
    private boolean hasLossStreak;             // whether or not player is on a loss streak (2+ consecutive losses)
    private String currentRank;                // player's current tier, division, and LP
    private ArrayList<String> previousRanks;   // player's ranks in previous seasons (if applicable)

    public Player(Summoner summoner) {
        this.name = summoner.getName();
        this.wins = summoner.getLeague(Queue.RANKED_SOLO).get(7).getWins();
        this.losses = summoner.getLeague(Queue.RANKED_SOLO).get(8).getLosses();
        this.currentRank = summoner.getLeague(Queue.RANKED_SOLO).getTier().toString();
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getWinRate() {
        return wins/losses;
    }

    public int getNumTotalGames() {
        return wins + losses;
    }

    public String getCurrentRank() {
        return currentRank;
    }
}
