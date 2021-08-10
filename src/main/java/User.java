import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;

import java.util.HashMap;
import java.util.Map;

public class User {
    private final Player user;
    private Map<String, PlayerInfo> blacklist;

    public User(String userName) {
        Summoner userSummoner = Summoner.named(userName).withRegion(Region.NORTH_AMERICA).get();
        this.user = new Player(userSummoner);
        this.blacklist = new HashMap<>();
    }

    public Player getUser() {
        return user;
    }

    public Map<String, PlayerInfo> getBlacklist() {
        return blacklist;
    }

    public void addToBlacklist(String playerName) {
        Summoner summoner = Summoner.named(playerName).withRegion(Region.NORTH_AMERICA).get();
        blacklist.put(playerName, new PlayerInfo(summoner));
    }

    public void removeFromBlacklist(String playerName) {
        blacklist.remove(playerName);
    }

    public PlayerInfo getBlacklistedPlayerInfo(String playerName) {
        return blacklist.get(playerName);
    }
}
