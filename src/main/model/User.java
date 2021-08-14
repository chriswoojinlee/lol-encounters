package model;

import java.util.HashMap;
import java.util.Map;

public class User extends Player {
    private Map<String, PlayerInfo> blacklist;

    public User(String userName) {
        super(userName);
        this.blacklist = new HashMap<>();
    }

    public Map<String, PlayerInfo> getBlacklist() {
        return blacklist;
    }

    public void addToBlacklist(String playerName) {
        blacklist.put(playerName, new PlayerInfo(playerName));
    }

    public void removeFromBlacklist(String playerName) {
        blacklist.remove(playerName);
    }

    public PlayerInfo getBlacklistedPlayerInfo(String playerName) {
        return blacklist.get(playerName);
    }
}
