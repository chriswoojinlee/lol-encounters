import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Represents current game lobby of all 5 players on same team including the user
public class Lobby {
    private final List<Player> players;  // players in the current lobby
    private final User user;             // user

    // create a new lobby with all summoners loaded in
    public Lobby(List<Player> players, User user) {
        this.players = players;
        this.user = user;
    }

    public List<Player> findBlacklistedPlayersInLobby() {
        Map<String, PlayerInfo> blacklist = user.getBlacklist();
        List<Player> blacklistedPlayersInLobby = new ArrayList<>();

        for(int i = 0; i < 4; i++) {
            if(blacklist.containsKey(players.get(i).getName())) {
                blacklistedPlayersInLobby.add(players.get(i));
            }
        }

        return blacklistedPlayersInLobby;
    }

//    public List<Player> findPreviouslyEncounteredPlayers() {
//        return
//    }
}
