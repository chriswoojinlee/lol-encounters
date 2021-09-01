package servlets;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Platform;
import com.merakianalytics.orianna.types.core.match.Match;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import model.Lobby;
import model.Player;
import model.PlayersParser;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LobbyServlet", urlPatterns = "/lobby")
public class LobbyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> playerNames = new ArrayList<>();
        List<String> profileIcons = new ArrayList<>();
        List<String> levels = new ArrayList<>();
        List<String> tiers = new ArrayList<>();
        List<String> divisions = new ArrayList<>();
        List<String> lp = new ArrayList<>();
        List<String> wins = new ArrayList<>();
        List<String> losses = new ArrayList<>();
        List<String> winRates = new ArrayList<>();
        List<String> tierIcons = new ArrayList<>();
        List<String> numEncounters = new ArrayList<>();
        Orianna.Configuration config = new Orianna.Configuration();
        Orianna.loadConfiguration(config);
        config.setDefaultPlatform(Platform.NORTH_AMERICA);
        Orianna.setDefaultLocale("en_US");
        Orianna.setRiotAPIKey("RGAPI-9cf02e96-0ea2-4606-9c0b-0cb79be20ffb");
        HttpSession session = request.getSession(false);
        String userIGN = session.getAttribute("userIGN").toString();
        User user = new User(userIGN);
        PlayersParser playersParser = new PlayersParser(request.getParameter("lobbyText"), userIGN);
        List<Player> players = playersParser.getPlayers();
        Lobby lobby = new Lobby(players, user);
        for(Player p : players) {
            if(p != null) {
                Summoner playerSummoner = p.getSummoner();
                String tier = p.getCurrentTier();
                String division = p.getCurrentDivision();
                playerNames.add(playerSummoner.getName());
                profileIcons.add(playerSummoner.getProfileIcon().getImage().getURL());
                levels.add("Level " + playerSummoner.getLevel());
                tiers.add(tier);
                divisions.add(division);
                lp.add(p.getCurrentLP() + " LP");
                wins.add(p.getWins() + "W");
                losses.add(p.getLosses() + "L");
                winRates.add(p.getWinRate() + "% Win Ratio");
                switch(tier + " " + division) {
                    case "IRON IV": tierIcons.add("//opgg-static.akamaized.net/images/medals/iron_4.png?image=q_auto:best&amp;v=1"); break;
                    case "IRON III": tierIcons.add("//opgg-static.akamaized.net/images/medals/iron_3.png?image=q_auto:best&amp;v=1"); break;
                    case "IRON II": tierIcons.add("//opgg-static.akamaized.net/images/medals/iron_2.png?image=q_auto:best&amp;v=1"); break;
                    case "IRON I": tierIcons.add("//opgg-static.akamaized.net/images/medals/iron_1.png?image=q_auto:best&amp;v=1"); break;
                    case "BRONZE IV": tierIcons.add("//opgg-static.akamaized.net/images/medals/bronze_4.png?image=q_auto:best&amp;v=1"); break;
                    case "BRONZE III": tierIcons.add("//opgg-static.akamaized.net/images/medals/bronze_3.png?image=q_auto:best&amp;v=1"); break;
                    case "BRONZE II": tierIcons.add("//opgg-static.akamaized.net/images/medals/bronze_2.png?image=q_auto:best&amp;v=1"); break;
                    case "BRONZE I": tierIcons.add("//opgg-static.akamaized.net/images/medals/bronze_1.png?image=q_auto:best&amp;v=1"); break;
                    case "SILVER IV": tierIcons.add("//opgg-static.akamaized.net/images/medals/silver_4.png?image=q_auto:best&amp;v=1"); break;
                    case "SILVER III": tierIcons.add("//opgg-static.akamaized.net/images/medals/silver_3.png?image=q_auto:best&amp;v=1"); break;
                    case "SILVER II": tierIcons.add("//opgg-static.akamaized.net/images/medals/silver_2.png?image=q_auto:best&amp;v=1"); break;
                    case "SILVER I": tierIcons.add("//opgg-static.akamaized.net/images/medals/silver_1.png?image=q_auto:best&amp;v=1"); break;
                    case "GOLD IV": tierIcons.add("//opgg-static.akamaized.net/images/medals/gold_4.png?image=q_auto:best&amp;v=1"); break;
                    case "GOLD III": tierIcons.add("//opgg-static.akamaized.net/images/medals/gold_3.png?image=q_auto:best&amp;v=1"); break;
                    case "GOLD II": tierIcons.add("//opgg-static.akamaized.net/images/medals/gold_2.png?image=q_auto:best&amp;v=1"); break;
                    case "GOLD I": tierIcons.add("//opgg-static.akamaized.net/images/medals/gold_1.png?image=q_auto:best&amp;v=1"); break;
                    case "PLATINUM IV": tierIcons.add("//opgg-static.akamaized.net/images/medals/platinum_4.png?image=q_auto:best&amp;v=1"); break;
                    case "PLATINUM III": tierIcons.add("//opgg-static.akamaized.net/images/medals/platinum_3.png?image=q_auto:best&amp;v=1"); break;
                    case "PLATINUM II": tierIcons.add("//opgg-static.akamaized.net/images/medals/platinum_2.png?image=q_auto:best&amp;v=1"); break;
                    case "PLATINUM I": tierIcons.add("//opgg-static.akamaized.net/images/medals/platinum_1.png?image=q_auto:best&amp;v=1"); break;
                    case "DIAMOND IV": tierIcons.add("//opgg-static.akamaized.net/images/medals/diamond_4.png?image=q_auto:best&amp;v=1"); break;
                    case "DIAMOND III": tierIcons.add("//opgg-static.akamaized.net/images/medals/diamond_3.png?image=q_auto:best&amp;v=1"); break;
                    case "DIAMOND II": tierIcons.add("//opgg-static.akamaized.net/images/medals/diamond_2.png?image=q_auto:best&amp;v=1"); break;
                    case "DIAMOND I": tierIcons.add("//opgg-static.akamaized.net/images/medals/diamond_1.png?image=q_auto:best&amp;v=1"); break;
                    case "MASTER I": tierIcons.add("//opgg-static.akamaized.net/images/medals/master_1.png?image=q_auto:best&amp;v=1"); break;
                    case "GRANDMASTER I": tierIcons.add("//opgg-static.akamaized.net/images/medals/grandmaster_1.png?image=q_auto:best&amp;v=1"); break;
                    case "CHALLENGER I": tierIcons.add("//opgg-static.akamaized.net/images/medals/challenger_1.png?image=q_auto:best&amp;v=1"); break;
                }

                int count = 0;
                List<Match> matches = lobby.findPreviouslySharedMatches(p.getName());
                for(int i = 0; i < matches.size(); i++) {
                    count++;
                }

                numEncounters.add(String.valueOf(count));

            } else {
                playerNames.add("");
                profileIcons.add("");
                levels.add("");
                tiers.add("");
                divisions.add("");
                lp.add("");
                wins.add("");
                losses.add("");
                winRates.add("");
                tierIcons.add("");
                numEncounters.add("");
            }
        }

        session.setAttribute("p1PlayerName", playerNames.get(0));
        session.setAttribute("p2PlayerName", playerNames.get(1));
        session.setAttribute("p3PlayerName", playerNames.get(2));
        session.setAttribute("p4PlayerName", playerNames.get(3));
        session.setAttribute("p1ProfileIcon", profileIcons.get(0));
        session.setAttribute("p2ProfileIcon", profileIcons.get(1));
        session.setAttribute("p3ProfileIcon", profileIcons.get(2));
        session.setAttribute("p4ProfileIcon", profileIcons.get(3));
        session.setAttribute("p1Level", levels.get(0));
        session.setAttribute("p2Level", levels.get(1));
        session.setAttribute("p3Level", levels.get(2));
        session.setAttribute("p4Level", levels.get(3));
        session.setAttribute("p1TierIcon", tierIcons.get(0));
        session.setAttribute("p2TierIcon", tierIcons.get(1));
        session.setAttribute("p3TierIcon", tierIcons.get(2));
        session.setAttribute("p4TierIcon", tierIcons.get(3));
        session.setAttribute("p1Tier", tiers.get(0));
        session.setAttribute("p2Tier", tiers.get(1));
        session.setAttribute("p3Tier", tiers.get(2));
        session.setAttribute("p4Tier", tiers.get(3));
        session.setAttribute("p1Division", divisions.get(0));
        session.setAttribute("p2Division", divisions.get(1));
        session.setAttribute("p3Division", divisions.get(2));
        session.setAttribute("p4Division", divisions.get(3));
        session.setAttribute("p1LP", lp.get(0));
        session.setAttribute("p2LP", lp.get(1));
        session.setAttribute("p3LP", lp.get(2));
        session.setAttribute("p4LP", lp.get(3));
        session.setAttribute("p1Wins", wins.get(0));
        session.setAttribute("p2Wins", wins.get(1));
        session.setAttribute("p3Wins", wins.get(2));
        session.setAttribute("p4Wins", wins.get(3));
        session.setAttribute("p1Losses", losses.get(0));
        session.setAttribute("p2Losses", losses.get(1));
        session.setAttribute("p3Losses", losses.get(2));
        session.setAttribute("p4Losses", losses.get(3));
        session.setAttribute("p1WinRate", winRates.get(0));
        session.setAttribute("p2WinRate", winRates.get(1));
        session.setAttribute("p3WinRate", winRates.get(2));
        session.setAttribute("p4WinRate", winRates.get(3));
        session.setAttribute("p1NumEncounters", numEncounters.get(0));
        session.setAttribute("p2NumEncounters", numEncounters.get(1));
        session.setAttribute("p3NumEncounters", numEncounters.get(2));
        session.setAttribute("p4NumEncounters", numEncounters.get(3));
        session.getServletContext().getRequestDispatcher("/lobby.jsp").forward(request, response);
    }
}
