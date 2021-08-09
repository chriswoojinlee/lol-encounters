import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;

import java.util.HashMap;
import java.util.Map;

public class Blacklist {
    private Map<String, PlayerInfo> blacklist;

    public Blacklist(Player user) {
        this.blacklist = new HashMap<>();
    }

    public void addToBlacklist(String playerName) {
        Summoner summoner = Summoner.named(playerName).withRegion(Region.NORTH_AMERICA).get();
        Player player = new Player(summoner);
        blacklist.put(playerName, new PlayerInfo(player));
    }

    public void removeFromBlacklist(String playerName) {
        blacklist.remove(playerName);
    }
}
