import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;

import java.util.HashMap;
import java.util.Map;

public class User {
    private final Player user;
    private Blacklist blacklist;

    public User(String userName) {
        Summoner userSummoner = Summoner.named(userName).withRegion(Region.NORTH_AMERICA).get();
        this.user = new Player(userSummoner);
        this.blacklist = new Blacklist(user);
    }

    public Player getUser() {
        return user;
    }

    public Blacklist getBlacklist() {
        return blacklist;
    }
}
