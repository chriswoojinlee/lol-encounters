import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    User user;

    @BeforeEach
    void setup() {
        Orianna.setRiotAPIKey("RGAPI-3f69808b-690a-4c8d-8119-d73f5b23b23f"); // must be blank API key before committing
        user = new User("LeeWooJin");
    }

    @Test
    void testUser() {
        assertEquals("LeeWooJin", user.getUser().getName());
        assertEquals(60.3, user.getUser().getWinRate());
    }

    @Test
    public void testGetBlacklist() {
        Map<String, PlayerInfo> testBlacklist = new HashMap<>();
        Summoner summoner1 = Summoner.named("college board xd").withRegion(Region.NORTH_AMERICA).get();
        Summoner summoner2 = Summoner.named("UofT UBC McGill").withRegion(Region.NORTH_AMERICA).get();
        Summoner summoner3 = Summoner.named("DoinADoinBDoinZ").withRegion(Region.NORTH_AMERICA).get();
        testBlacklist.put("college board xd", new PlayerInfo(summoner1));
        testBlacklist.put("UofT UBC McGill", new PlayerInfo(summoner2));
        testBlacklist.put("DoinADoinBDoinZ", new PlayerInfo(summoner3));

        user.addToBlacklist("college board xd");
        user.addToBlacklist("UofT UBC McGill");
        user.addToBlacklist("DoinADoinBDoinZ");
        user.removeFromBlacklist("DoinADoinBDoinZ");
        user.addToBlacklist("DoinADoinBDoinZ");

        assertTrue(user.getBlacklist().equals(testBlacklist));
    }

    @Test
    public void testGetBlacklistedPlayerInfo() {
        Summoner summoner = Summoner.named("college board xd").withRegion(Region.NORTH_AMERICA).get();
        PlayerInfo playerInfo = new PlayerInfo(summoner);

        user.addToBlacklist("college board xd");

        assertEquals(playerInfo, user.getBlacklistedPlayerInfo("college board xd"));
    }

}
