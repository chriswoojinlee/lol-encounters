package model;

import com.merakianalytics.orianna.types.core.match.Match;
import com.merakianalytics.orianna.types.core.match.Participant;

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

    public List<Match> findPreviouslyEncounteredPlayers() {
        ArrayList<Match> matchesInCommon = new ArrayList<>();
        String userName = user.getName();

        for(int i = 0; i < user.getNumGames(); i++) {
            Match match = user.getMatch(i);
            for(int j = 0; j < 4; j++) {
                if(matchHasPlayer(userName, match) && matchHasPlayer(players.get(j).getName(), match)) {
                    matchesInCommon.add(match);
                }
            }
        }

        return matchesInCommon;
    }

    public boolean matchHasPlayer(String playerName, Match match) {
        List<Participant> participants = match.getParticipants();

        for(int i = 0; i < 10; i++) {
            if(participants.get(i).getSummoner().getName().equals(playerName)) {
                return true;
            }
        }

        return false;
    }
}
