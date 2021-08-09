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

    private final User user;                        // user's datapoint
    private final Summoner summoner;                // player's summoner datapoint
    private final League league;                    // player's current ranked solo/duo queue league

    public Player(User user, Summoner summoner) {
        this.user = user;
        this.summoner = summoner;
        this.league = summoner.getLeague(Queue.RANKED_SOLO);
    }

    public String getName() {
        return summoner.getName();
    }

    public int getPlayerLeagueNum() {
        for(int i = 0; i < 100; i++) {
            if(league.get(i).getSummoner().getName().equals(summoner.getName())) {
                return i;
            }
        }

        return 0;
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
