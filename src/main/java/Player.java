import com.merakianalytics.orianna.types.common.Queue;
import com.merakianalytics.orianna.types.common.Season;
import com.merakianalytics.orianna.types.core.league.League;
import com.merakianalytics.orianna.types.core.match.Match;
import com.merakianalytics.orianna.types.core.match.MatchHistory;
import com.merakianalytics.orianna.types.core.summoner.Summoner;

// Represents a player and his/her stats
public class Player {
    private static final Season currentSeason = Season.getLatest();

    private final League league;                     // player's current ranked solo/duo queue league
    private final String name;                       // summoner name
    private final int wins;                          // number of games that player has won in ranked solo/duo queue
    private final int losses;                        // number of games that player has lost in ranked solo/duo queue
    private final String currentTier;                // player's current tier
    private final String currentDivision;            // player's current division within a tier
    private final int currentLP;                     // player's current amount of LP
    private final String currentRank;                // player's current rank (current tier, division, and LP)
    private boolean hasWinStreak;              // whether or not player is on a win streak (2+ consecutive wins)
    private boolean hasLossStreak;             // whether or not player is on a loss streak (2+ consecutive losses)
    private boolean isAutofilled;              // whether or not player is autofilled (not on primary or secondary role)

    public Player(Summoner summoner) {
        this.league = summoner.getLeague(Queue.RANKED_SOLO);
        this.name = summoner.getName();
        this.wins = league.get(getPlayerLeagueNum(name, league)).getWins();
        this.losses = league.get(getPlayerLeagueNum(name, league)).getLosses();
        this.currentTier = league.getTier().toString();
        this.currentDivision = league.get(getPlayerLeagueNum(name, league)).getDivision().toString();
        this.currentLP = league.get(getPlayerLeagueNum(name, league)).getLeaguePoints();
        this.currentRank = getCurrentTier() + getCurrentDivision() + getCurrentLP();
        this.hasWinStreak = getWinStreak(summoner);
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
    public boolean getWinStreak(Summoner summoner) {
        int winCounter = 0;

        for(int i = 0; i < 10; i++) {
            Match match = summoner.matchHistory().withQueues(Queue.RANKED_SOLO).withSeasons(currentSeason).get().get(0);

            if(winCounter >= 2 && (match.getBlueTeam().isWinner() && match.getBlueTeam().getParticipants().contains(summoner))
                    || match.getRedTeam().isWinner() && match.getRedTeam().getParticipants().contains(summoner)) {
                winCounter++;
                hasWinStreak = true;
            } else if((match.getBlueTeam().isWinner() && match.getBlueTeam().getParticipants().contains(summoner))
            || match.getRedTeam().isWinner() && match.getRedTeam().getParticipants().contains(summoner)) {
                winCounter++;
            }
        }

        return hasWinStreak;
    }

    // TODO
    public boolean getLossStreak() {
        return false;
    }

    // TODO
    public boolean getAutofilled() {
        return false;
    }
}
