import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Queue;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.common.Season;
import com.merakianalytics.orianna.types.core.match.MatchHistory;
import com.merakianalytics.orianna.types.core.summoner.Summoner;

public class AnalyzeSummoner {
    private Summoner account;   // represents player's account fetched from Riot's Summoner API
    private int points;         // total criteria points of player

    // initializes player with 0 criteria points
    public AnalyzeSummoner(String name) {
        points = 0;
        account = Orianna.summonerNamed(name).withRegion(Region.NORTH_AMERICA).get();
        account.getHighestTier(Season.SEASON_8);
        MatchHistory.Builder matches = account.matchHistory().withQueues(Queue.RANKED_SOLO);
    }

    /* Adds points and determines solely from winrate whether player is inflated/negative wr in rank (+0),
    hardstuck (+1), slowly climbing (+3), rapidly climbing (+5), or smurfing (+7)

    Point allocation justification: inflated/hardstuck players significantly reduce chances of winning (they lack some
    fundamental, yet critical game knowledge), whereas players clearly able to climb (slowly, at least) greatly
    increase chances of winning */
    public String getWinRateFeedback(Player player) {
        return "";
    }
}
