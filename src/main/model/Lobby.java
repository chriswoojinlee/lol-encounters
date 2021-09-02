package model;

import com.merakianalytics.orianna.types.core.match.Match;
import com.merakianalytics.orianna.types.core.match.Participant;
import java.util.ArrayList;
import java.util.List;

// Represents current game lobby of all 5 players on same team including the user
public class Lobby {
    private final User user;

    // create a new lobby with all summoners loaded in
    public Lobby(User user) {
        this.user = user;
    }

    // find any shared matches between the user and a given player
    public List<Match> findPreviouslySharedMatches(String playerName) {
        ArrayList<Match> matches = new ArrayList<>();
        String userName = user.getName();
        int matchHistoryLength;

        if(user.getNumGames() > 20) {
            matchHistoryLength = 20;
        } else {
            matchHistoryLength = user.getNumGames();
        }

        for(int i = 0; i < matchHistoryLength; i++) {
            Match match = user.getMatch(i);

            if(matchHasPlayer(userName, match) && matchHasPlayer(playerName, match)) {
                matches.add(match);
            }
        }

        return matches;
    }

    // given a single match, check if a player has played in it
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
