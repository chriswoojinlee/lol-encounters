package model;

import com.merakianalytics.orianna.Orianna;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    Player player;

    @BeforeEach
    void setup() {
        player = new Player("LeeWooJin");
    }

    @Test
    void testGetName() {
        assertEquals("LeeWooJin", player.getName());
    }

    @Test
    void testGetCurrentRank() {
        assertEquals("DIAMONDI50", player.getCurrentRank());
    }

    @Test
    void testGetWinRate() {
        assertEquals(60.3, player.getWinRate());
    }

    @Test
    void testGetWinStreak() {
        assertFalse(player.getWinStreak());
    }

    @Test
    void testGetLossStreak() {
        assertFalse(player.getLossStreak());
    }

    @Test
    void testGetLastTenGameOutcomes() {
        ArrayList<String> matches = new ArrayList<>();
        matches.add("W");
        for(int i = 0; i < 4; i++) {
            matches.add("L");
        }
        matches.add("W");
        matches.add("L");
        for(int i = 0; i < 2; i++) {
            matches.add("W");
        }
        matches.add("L");
        assertEquals(matches, player.getLastTenGameOutcomes());
    }

    @Test
    void testGetPreferredPosition() {
        assertEquals("JUNGLE", player.getPreferredPosition());
    }

    @Test
    void testGetLanes() {
        ArrayList<String> lanes = new ArrayList<>();
        lanes.add("JUNGLE");
        lanes.add("BOTTOM");
        for(int i = 0; i < 3; i++) {
            lanes.add("JUNGLE");
        }
        for(int i = 0; i < 3; i++) {
            lanes.add("NONE");
        }
        for(int i = 0; i < 2; i++) {
            lanes.add("JUNGLE");
        }

        assertEquals(lanes, player.getLanes());
    }

    @Test
    void testGetRoles() {
        ArrayList<String> roles = new ArrayList<>();
        roles.add("NONE");
        roles.add("DUO_CARRY");
        for(int i = 0; i < 3; i++) {
            roles.add("NONE");
        }
        for(int i = 0; i < 3; i++) {
            roles.add("DUO_SUPPORT");
        }
        for(int i = 0; i < 2; i++) {
            roles.add("NONE");
        }

        assertEquals(roles, player.getRoles());
    }

    @Test
    void testGetFilteredPositions() {
        ArrayList<String> positions = new ArrayList<>();
        positions.add("JUNGLE");
        positions.add("ADC");
        for(int i = 0; i < 5; i++) {
            positions.add("JUNGLE");
        }
        positions.add("ADC");
        for(int i = 0; i < 3; i++) {
            positions.add("SUPPORT");
        }

        assertEquals(positions, player.getFilteredPositions(player.getCombinedPositions()));
    }

    @Test
    void testGetCombinedPositions() {
        ArrayList<String> positions = new ArrayList<>();
        positions.add("JUNGLE");
        positions.add("BOTTOM");
        for(int i = 0; i < 3; i++) {
            positions.add("JUNGLE");
        }
        for(int i = 0; i < 3; i++) {
            positions.add("NONE");
        }
        positions.add("JUNGLE");
        positions.add("JUNGLE");
        positions.add("NONE");
        positions.add("DUO_CARRY");
        for(int i = 0; i < 3; i++) {
            positions.add("NONE");
        }
        for(int i = 0; i < 3; i++) {
            positions.add("DUO_SUPPORT");
        }
        positions.add("NONE");
        positions.add("NONE");

        assertEquals(positions, player.getCombinedPositions());
    }
}