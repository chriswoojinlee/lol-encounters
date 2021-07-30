import com.merakianalytics.orianna.types.common.Queue;
import com.merakianalytics.orianna.types.common.Season;
import com.merakianalytics.orianna.types.core.league.League;
import com.merakianalytics.orianna.types.core.league.LeaguePositions;
import com.merakianalytics.orianna.types.core.match.Match;
import com.merakianalytics.orianna.types.core.match.Participant;
import com.merakianalytics.orianna.types.core.summoner.Summoner;

import java.util.ArrayList;

// Represents a player and his/her stats
public class Player {
    private static final Season currentSeason = Season.getLatest();

    private final League league;               // player's current ranked solo/duo queue league
    private final String name;                 // summoner name
    private final int wins;                    // number of games that player has won in ranked solo/duo queue
    private final int losses;                  // number of games that player has lost in ranked solo/duo queue
    private int numGames;                      // number of games that player has played in ranked solo/duo queue
    private final String currentTier;          // player's current tier
    private final String currentDivision;      // player's current division within a tier
    private final int currentLP;               // player's current amount of LP
    private final String currentRank;          // player's current rank (current tier, division, and LP)
    private ArrayList<String> matchOutcomes;   // outcomes of player's last 10 matches
    private boolean hasWinStreak;              // whether or not player is on a win streak (2+ consecutive wins)
    private boolean hasLossStreak;             // whether or not player is on a loss streak (2+ consecutive losses)

    public Player(Summoner summoner) {
        this.league = summoner.getLeague(Queue.RANKED_SOLO);
        this.name = summoner.getName();
        this.wins = league.get(getPlayerLeagueNum(name, league)).getWins();
        this.losses = league.get(getPlayerLeagueNum(name, league)).getLosses();
        this.currentTier = league.getTier().toString();
        this.currentDivision = league.get(getPlayerLeagueNum(name, league)).getDivision().toString();
        this.currentLP = league.get(getPlayerLeagueNum(name, league)).getLeaguePoints();
        this.currentRank = getCurrentTier() + getCurrentDivision() + getCurrentLP();
        matchOutcomes = getLastTenGameOutcomes(summoner);
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

    public int getNumGames() {
        return getWins() + getLosses();
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
        return String.valueOf(Math.floor((double) getWins()/(getNumGames()) * 1000)/10) + "%";
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

    public boolean getWinStreak(Summoner summoner) {
        int winStreakCounter = 0;

        for(int i = 9; i >= 0; i--) {
           if(matchOutcomes.get(i).equals("W")) {
               winStreakCounter++;
           } else {
               winStreakCounter = 0;
           }
        }

        if(winStreakCounter >= 2) {
            hasWinStreak = true;
        } else {
            hasWinStreak = false;
        }

        return hasWinStreak;
    }

    public boolean getLossStreak(Summoner summoner) {
        int lossStreakCounter = 0;

        for(int i = 9; i >= 0; i--) {
            if(matchOutcomes.get(i).equals("L")) {
                lossStreakCounter++;
            } else {
                lossStreakCounter = 0;
            }
        }

        if(lossStreakCounter >= 2) {
            hasLossStreak = true;
        } else {
            hasLossStreak = false;
        }

        return hasLossStreak;
    }

    public ArrayList<String> getLastTenGameOutcomes(Summoner summoner) {
        ArrayList<String> matches = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Match match = summoner.matchHistory().withQueues(Queue.RANKED_SOLO).withSeasons(currentSeason).get().get(i);

            if ((match.getBlueTeam().isWinner() && match.getBlueTeam().getParticipants().contains(summoner))
                    || match.getRedTeam().isWinner() && match.getRedTeam().getParticipants().contains(summoner)) {
                matches.add("W");
            } else {
                matches.add("L");
            }
        }

        return matches;
    }

    // TODO
    public ArrayList<String> getLanes(Summoner summoner) {
        ArrayList<String> lanes = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Match match = summoner.matchHistory().withQueues(Queue.RANKED_SOLO).withSeasons(currentSeason).get().get(i);

            for(int j = 0; j < 10; j++) {
                if(match.getParticipants().get(j).getSummoner().equals(summoner)) {
                    lanes.add(match.getParticipants().get(j).getLane().toString());
                }
            }
        }

        return lanes;
    }

    // TODO
    public ArrayList<String> getRoles(Summoner summoner) {
        ArrayList<String> roles = new ArrayList<>();

        for (int i = 0; i < getNumGames(); i++) {
            Match match = summoner.matchHistory().withQueues(Queue.RANKED_SOLO).withSeasons(currentSeason).get().get(i);
            int summonerId = 0;

            for(int j = 0; j < 10; j++) {
                if(match.getParticipants().get(j).getSummoner().equals(summoner)) {
                    summonerId = j;
                }
            }

            roles.add(match.getParticipants().get(summonerId).getRole().toString());
        }

        return roles;
    }
}
