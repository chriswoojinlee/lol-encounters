import com.merakianalytics.orianna.types.common.Queue;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.common.Season;
import com.merakianalytics.orianna.types.common.Tier;
import com.merakianalytics.orianna.types.core.league.League;
import com.merakianalytics.orianna.types.core.summoner.Summoner;

import java.util.ArrayList;

// Represents a player and his/her stats
public class Player {
    private League league;                     // player's current ranked solo/duo queue league
    private String name;                       // summoner name
    private int wins;                          // number of games that player has won in ranked solo/duo queue
    private int losses;                        // number of games that player has lost in ranked solo/duo queue
    private boolean hasLossStreak;             // whether or not player is on a loss streak (2+ consecutive losses)
    private String currentTier;                // player's current tier
    private String currentDivision;            // player's current division within a tier
    private int currentLP;                     // player's current amount of LP
    private String currentRank;                // player's current rank (current tier, division, and LP)
    private String previousRanks;   // player's ranks in previous seasons (if applicable)

    public Player(Summoner summoner) {
        this.league = summoner.getLeague(Queue.RANKED_SOLO);
        this.name = summoner.getName();
        this.wins = league.get(getPlayerLeagueNum(name, league)).getWins();
        this.losses = league.get(getPlayerLeagueNum(name, league)).getLosses();
        this.currentTier = league.getTier().toString();
        this.currentDivision = league.get(getPlayerLeagueNum(name, league)).getDivision().toString();
        this.currentLP = league.get(getPlayerLeagueNum(name, league)).getLeaguePoints();
        this.currentRank = getCurrentTier() + getCurrentDivision() + getCurrentLP();
        this.previousRanks = getPreviousRanks();
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

    public int getPlayerLeagueNum(String name, League league) {
        for(int i = 0; i < 100; i++) {
            if(league.get(i).getSummoner().getName().equals(name)) {
                return i;
            }
        }

        return 0;
    }

    // returns ranked solo/duo queue win rate % (% of games won out of total games)
    public String getWinRate() {
        return String.valueOf(Math.floor((double) getWins()/(getWins()+getLosses()) * 1000)/10) + "%";
    }

    public String getCurrentTier() {
        return currentTier;
    }

    public String getCurrentDivision() {
        return currentDivision;
    }

    public String getCurrentLP() {
        return String.valueOf(currentLP);
    }

    public String getCurrentRank() {
        return currentRank;
    }

    // TODO
    public String getPreviousRanks() {
        ArrayList<String> ranks = new ArrayList<>();
        return "";
    }
}
