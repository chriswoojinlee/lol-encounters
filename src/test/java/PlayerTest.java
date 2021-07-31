import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    Summoner summoner1;
    Player player1;
    Summoner summoner2;
    Player player2;
    Summoner summoner3;
    Player player3;
    Summoner summoner4;
    Player player4;
    Summoner summoner5;
    Player player5;
    Summoner summoner6;
    Player player6;

    @BeforeEach
    void setup() {
        Orianna.setRiotAPIKey(""); // must be blank API key before committing
        //summoner1 = Summoner.named("GeneralSn1per").withRegion(Region.NORTH_AMERICA).get();
        summoner2 = Summoner.named("LeeWooJin").withRegion(Region.NORTH_AMERICA).get();
        //summoner3 = Summoner.named("jojopyun 16").withRegion(Region.NORTH_AMERICA).get();
        //summoner4 = Summoner.named("Tactical").withRegion(Region.NORTH_AMERICA).get();
        //summoner5 = Summoner.named("From Iron").withRegion(Region.NORTH_AMERICA).get();
        //summoner6 = Summoner.named("Woojin Lee").withRegion(Region.NORTH_AMERICA).get();
        //player1 = new Player(summoner1); // top laner datapoint
        player2 = new Player(summoner2); // jungler datapoint
        //player3 = new Player(summoner3); // mid laner datapoint
        //player4 = new Player(summoner4); // adc datapoint
        //player5 = new Player(summoner5); // support datapoint
        // player6 = new Player(summoner6); // unranked account test datapoint (8 ranked solo/duo queue games played)
    }

    @Test
    void testGetName() {
        assertEquals("LeeWooJin", player2.getName());
    }

    @Test
    void testGetWins() {
        assertEquals(69, player2.getWins());
    }

    @Test
    void testGetLosses() {
        assertEquals(42, player2.getLosses());
    }

    @Test
    void testGetCurrentRank() {
        assertEquals("DIAMONDI94", player2.getCurrentRank());
    }

    @Test
    void testGetWinRate() {
        assertEquals("62.1%", player2.getWinRate());
    }

    @Test
    void testGetWinStreak() {
        assertTrue(player2.getWinStreak());
    }

    @Test
    void testGetLossStreak() {
        assertFalse(player2.getLossStreak());
    }

    @Test
    void testGetLastTenGameOutcomes() {
        ArrayList<String> matches = new ArrayList<>();
        matches.add("W");
        matches.add("W");
        for(int i = 0; i < 3; i++) {
            matches.add("L");
        }
        matches.add("W");
        matches.add("L");
        for(int i = 0; i < 3; i++) {
            matches.add("W");
        }

        assertEquals(matches, player2.getLastTenGameOutcomes());
    }

    @Test
    void testGetPreferredPosition() {
        assertEquals("JUNGLE", player2.getPreferredPosition());
    }

    @Test
    void testGetLanes() {
        ArrayList<String> lanes = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            lanes.add("JUNGLE");
        }
        lanes.add("NONE");
        for(int i = 0; i < 6; i++) {
            lanes.add("JUNGLE");
        }

        assertEquals(lanes, player2.getLanes());
    }

    @Test
    void testGetRoles() {
        ArrayList<String> roles = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            roles.add("NONE");
        }
        roles.add("DUO_SUPPORT");
        for(int i = 0; i < 6; i++) {
            roles.add("NONE");
        }

        assertEquals(roles, player2.getRoles());
    }

    @Test
    void testGetFilteredPositions() {
        ArrayList<String> positions = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            positions.add("JUNGLE");
        }
        positions.add("SUPPORT");

        assertEquals(positions, player2.getFilteredPositions(player2.getCombinedPositions()));
    }

    @Test
    void testGetCombinedPositions() {
        ArrayList<String> positions = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            positions.add("JUNGLE");
        }
        positions.add("NONE");
        for(int i = 0; i < 6; i++) {
            positions.add("JUNGLE");
        }
        for(int i = 0; i < 3; i++) {
            positions.add("NONE");
        }
        positions.add("DUO_SUPPORT");
        for(int i = 0; i < 6; i++) {
            positions.add("NONE");
        }

        assertEquals(positions, player2.getCombinedPositions());
    }
}