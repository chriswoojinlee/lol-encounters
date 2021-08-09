import com.merakianalytics.orianna.types.common.Queue;
import com.merakianalytics.orianna.types.common.Season;
import com.merakianalytics.orianna.types.core.league.League;
import com.merakianalytics.orianna.types.core.league.LeaguePositions;
import com.merakianalytics.orianna.types.core.match.Match;
import com.merakianalytics.orianna.types.core.match.MatchHistory;
import com.merakianalytics.orianna.types.core.match.Participant;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import org.cache2k.core.Entry;

import java.util.*;

// Represents a player and his/her stats
public class Player {
    private static final Season currentSeason = Season.getLatest();
    private static final int matchHistoryLength = 10;

    private final Summoner summoner;                // player's summoner datapoint
    private final League league;                    // player's current ranked solo/duo queue league

    public Player(Summoner summoner) {
        this.summoner = summoner;
        this.league = summoner.getLeague(Queue.RANKED_SOLO);
    }

    public String getName() {
        return summoner.getName();
    }

    public int getPlayerLeagueNum() {
        for(int i = 0; i < league.size(); i++) {
            if(league.get(i).getSummoner().getName().equals(summoner.getName())) {
                return i;
            }
        }

        return 0;
    }

    public int getWins() {
        return league.get(getPlayerLeagueNum()).getWins();
    }

    public int getLosses() {
        return league.get(getPlayerLeagueNum()).getLosses();
    }

    public int getNumGames() {
        return getWins() + getLosses();
    }

    public double getWinRate() {
        return Math.floor((double) getWins()/(getNumGames()) * 1000)/10;
    }

    public String getCurrentTier() {
        return league.getTier().toString();
    }

    public String getCurrentDivision() {
        return league.get(getPlayerLeagueNum()).getDivision().toString();
    }

    public String getCurrentLP() {
        return String.valueOf(league.get(getPlayerLeagueNum()).getLeaguePoints());
    }

    public String getCurrentRank() {
        return getCurrentTier() + getCurrentDivision() + getCurrentLP();
    }

    public boolean getWinStreak() {
        boolean hasWinStreak;
        int winStreakCounter = 0;
        ArrayList<String> gameOutcomes = getLastTenGameOutcomes();

        for(int i = 9; i >= 0; i--) {
            if(gameOutcomes.get(i).equals("W")) {
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

    public boolean getLossStreak() {
        boolean hasLossStreak;
        int lossStreakCounter = 0;
        ArrayList<String> gameOutcomes = getLastTenGameOutcomes();

        for(int i = 9; i >= 0; i--) {
            if(gameOutcomes.get(i).equals("L")) {
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

    public ArrayList<String> getLastTenGameOutcomes() {
        ArrayList<String> matches = new ArrayList<>();
        MatchHistory matchHistory = summoner.matchHistory().withQueues(Queue.RANKED_SOLO).withSeasons(currentSeason).
                get();

        for (int i = 0; i < 10; i++) {
            Match match = matchHistory.get(i);

            if ((match.getBlueTeam().isWinner() && match.getBlueTeam().getParticipants().contains(summoner))
                    || match.getRedTeam().isWinner() && match.getRedTeam().getParticipants().contains(summoner)) {
                matches.add("W");
            } else {
                matches.add("L");
            }
        }

        return matches;
    }

    public String getPreferredPosition() {
        ArrayList<String> positions = getFilteredPositions(getCombinedPositions());
        int topCounter = 0;
        int jgCounter = 0;
        int midCounter = 0;
        int adCounter = 0;
        int supCounter = 0;
        Map<String, Integer> posMap = new HashMap<>();

        for(int i = 0; i < positions.size(); i++) {
            switch (positions.get(i)) {
                case "TOP":
                    topCounter++;
                    break;
                case "JUNGLE":
                    jgCounter++;
                    break;
                case "MIDDLE":
                    midCounter++;
                    break;
                case "ADC":
                    adCounter++;
                    break;
                case "SUPPORT":
                    supCounter++;
                    break;
            }
        }

        posMap.put("TOP", topCounter);
        posMap.put("JUNGLE", jgCounter);
        posMap.put("MID", midCounter);
        posMap.put("ADC", adCounter);
        posMap.put("SUPPORT", supCounter);

        Map.Entry<String, Integer> max = null;

        for (Map.Entry<String, Integer> e : posMap.entrySet()) {
            if (max == null || e.getValue() > max.getValue())
                max = e;
        }

        return max.getKey();
    }

    public ArrayList<String> getFilteredPositions(ArrayList<String> positions) {
        for(int i = 0; i < positions.size(); i++) {
            if(positions.get(i).equals("NONE") || positions.get(i).equals("SOLO") || positions.get(i).equals("DUO")) {
                positions.remove(i);
                i--;
            }
        }

        for(int i = 0; i < positions.size(); i++) {
            if(positions.get(i).equals("DUO_SUPPORT")) {
                positions.set(i, "SUPPORT");
            }
        }

        for(int i = 0; i < positions.size(); i++) {
            if(positions.get(i).equals("DUO_CARRY")) {
                positions.set(i, "ADC");
            }
        }

        return positions;
    }

    public ArrayList<String> getCombinedPositions() {
        ArrayList<String> positions = new ArrayList<>();
        ArrayList<String> lanes = getLanes();
        ArrayList<String> roles = getRoles();

        for(int i = 0; i < matchHistoryLength; i++) {
            positions.add(lanes.get(i));
        }
        for(int i = 0; i < matchHistoryLength; i++) {
            positions.add(roles.get(i));
        }

        return positions;
    }

    public ArrayList<String> getLanes() {
        ArrayList<String> lanes = new ArrayList<>();

        for (int i = 0; i < matchHistoryLength; i++) {
            Match match = getMatch(i);
            lanes.add(match.getParticipants().get(getMatchSummonerId(match)).getLane().toString());
        }

        return lanes;
    }

    public ArrayList<String> getRoles() {
        ArrayList<String> roles = new ArrayList<>();

        for (int i = 0; i < matchHistoryLength; i++) {
            Match match = getMatch(i);
            roles.add(match.getParticipants().get(getMatchSummonerId(match)).getRole().toString());
        }

        return roles;
    }

    public int getMatchSummonerId(Match match) {
        int summonerId = 0;

        for(int i = 0; i < 10; i++) {
            if(match.getParticipants().get(i).getSummoner().equals(summoner)) {
                summonerId = i;
            }
        }

        return summonerId;
    }

    public Match getMatch(int matchNum) {
        Match match = summoner.matchHistory().withQueues(Queue.RANKED_SOLO).withSeasons(currentSeason).get().
                get(matchNum);

        return match;
    }
}
