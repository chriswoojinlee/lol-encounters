package model;

import com.merakianalytics.orianna.Orianna;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    User user;

    @BeforeEach
    void setup() {
        Orianna.setRiotAPIKey(""); // must be blank API key before committing
        user = new User("LeeWooJin");
    }

    @Test
    void testUser() {
        assertEquals("LeeWooJin", user.getName());
        assertEquals(60.3, user.getWinRate());
    }

    @Test
    public void testGetBlacklist() {
        Map<String, PlayerInfo> testBlacklist = new HashMap<>();
        testBlacklist.put("college board xd", new PlayerInfo("college board xd"));
        testBlacklist.put("UofT UBC McGill", new PlayerInfo("UofT UBC McGill"));
        testBlacklist.put("DoinADoinBDoinZ", new PlayerInfo("DoinADoinBDoinZ"));

        user.addToBlacklist("college board xd");
        user.addToBlacklist("UofT UBC McGill");
        user.addToBlacklist("DoinADoinBDoinZ");
        user.removeFromBlacklist("DoinADoinBDoinZ");
        user.addToBlacklist("DoinADoinBDoinZ");

        assertEquals(user.getBlacklist(), testBlacklist);
    }

    @Test
    public void testGetBlacklistedPlayerInfo() {
        PlayerInfo playerInfo = new PlayerInfo("college board xd");

        user.addToBlacklist("college board xd");

        assertEquals(playerInfo, user.getBlacklistedPlayerInfo("college board xd"));
    }

}
