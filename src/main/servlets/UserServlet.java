package servlets;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Platform;
import model.User;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String error;
        String profileIcon;
        String level;
        String tier;
        String division;
        String lp;
        String wins;
        String losses;
        String winRate;
        User user;
        String lobbyText;
        String tierIcon = "";
        Orianna.Configuration config = new Orianna.Configuration();
        Orianna.loadConfiguration(config);
        config.setDefaultPlatform(Platform.NORTH_AMERICA);
        Orianna.setDefaultLocale("en_US");
        Orianna.setRiotAPIKey("RGAPI-9cf02e96-0ea2-4606-9c0b-0cb79be20ffb");
        HttpSession session = request.getSession(false);
        String userIGN = request.getParameter("userIGN");

        if(new User(userIGN).getLeague() == null) {
            error = "Account is unranked. Please try again.";
            profileIcon = "";
            level = "";
            tier = "";
            division = "";
            lp = "";
            wins = "";
            losses = "";
            winRate = "";
            lobbyText = "";
        } else {
            error = "";
            user = new User(userIGN);
            profileIcon = user.getSummoner().getProfileIcon().getImage().getURL();
            level = "Level " + user.getSummoner().getLevel();
            tier = user.getCurrentTier();
            division = user.getCurrentDivision();
            lp = user.getCurrentLP() + " LP";
            wins = " / " + user.getWins() + "W";
            losses = " " + user.getLosses() + "L";
            winRate = user.getWinRate() + "% Win Ratio";
            switch(tier + " " + division) {
                case "IRON IV": tierIcon = "//opgg-static.akamaized.net/images/medals/iron_4.png?image=q_auto:best&amp;v=1"; break;
                case "IRON III": tierIcon = "//opgg-static.akamaized.net/images/medals/iron_3.png?image=q_auto:best&amp;v=1"; break;
                case "IRON II": tierIcon = "//opgg-static.akamaized.net/images/medals/iron_2.png?image=q_auto:best&amp;v=1"; break;
                case "IRON I": tierIcon = "//opgg-static.akamaized.net/images/medals/iron_1.png?image=q_auto:best&amp;v=1"; break;
                case "BRONZE IV": tierIcon = "//opgg-static.akamaized.net/images/medals/bronze_4.png?image=q_auto:best&amp;v=1"; break;
                case "BRONZE III": tierIcon = "//opgg-static.akamaized.net/images/medals/bronze_3.png?image=q_auto:best&amp;v=1"; break;
                case "BRONZE II": tierIcon = "//opgg-static.akamaized.net/images/medals/bronze_2.png?image=q_auto:best&amp;v=1"; break;
                case "BRONZE I": tierIcon = "//opgg-static.akamaized.net/images/medals/bronze_1.png?image=q_auto:best&amp;v=1"; break;
                case "SILVER IV": tierIcon = "//opgg-static.akamaized.net/images/medals/silver_4.png?image=q_auto:best&amp;v=1"; break;
                case "SILVER III": tierIcon = "//opgg-static.akamaized.net/images/medals/silver_3.png?image=q_auto:best&amp;v=1"; break;
                case "SILVER II": tierIcon = "//opgg-static.akamaized.net/images/medals/silver_2.png?image=q_auto:best&amp;v=1"; break;
                case "SILVER I": tierIcon = "//opgg-static.akamaized.net/images/medals/silver_1.png?image=q_auto:best&amp;v=1"; break;
                case "GOLD IV": tierIcon = "//opgg-static.akamaized.net/images/medals/gold_4.png?image=q_auto:best&amp;v=1"; break;
                case "GOLD III": tierIcon = "//opgg-static.akamaized.net/images/medals/gold_3.png?image=q_auto:best&amp;v=1"; break;
                case "GOLD II": tierIcon = "//opgg-static.akamaized.net/images/medals/gold_2.png?image=q_auto:best&amp;v=1"; break;
                case "GOLD I": tierIcon = "//opgg-static.akamaized.net/images/medals/gold_1.png?image=q_auto:best&amp;v=1"; break;
                case "PLATINUM IV": tierIcon = "//opgg-static.akamaized.net/images/medals/platinum_4.png?image=q_auto:best&amp;v=1"; break;
                case "PLATINUM III": tierIcon = "//opgg-static.akamaized.net/images/medals/platinum_3.png?image=q_auto:best&amp;v=1"; break;
                case "PLATINUM II": tierIcon = "//opgg-static.akamaized.net/images/medals/platinum_2.png?image=q_auto:best&amp;v=1"; break;
                case "PLATINUM I": tierIcon = "//opgg-static.akamaized.net/images/medals/platinum_1.png?image=q_auto:best&amp;v=1"; break;
                case "DIAMOND IV": tierIcon = "//opgg-static.akamaized.net/images/medals/diamond_4.png?image=q_auto:best&amp;v=1"; break;
                case "DIAMOND III": tierIcon = "//opgg-static.akamaized.net/images/medals/diamond_3.png?image=q_auto:best&amp;v=1"; break;
                case "DIAMOND II": tierIcon = "//opgg-static.akamaized.net/images/medals/diamond_2.png?image=q_auto:best&amp;v=1"; break;
                case "DIAMOND I": tierIcon = "//opgg-static.akamaized.net/images/medals/diamond_1.png?image=q_auto:best&amp;v=1"; break;
                case "MASTER I": tierIcon = "//opgg-static.akamaized.net/images/medals/master_1.png?image=q_auto:best&amp;v=1"; break;
                case "GRANDMASTER I": tierIcon = "//opgg-static.akamaized.net/images/medals/grandmaster_1.png?image=q_auto:best&amp;v=1"; break;
                case "CHALLENGER I": tierIcon = "//opgg-static.akamaized.net/images/medals/challenger_1.png?image=q_auto:best&amp;v=1"; break;
            }

            lobbyText = request.getParameter("lobbyText");
        }

        session.setAttribute("userIGN", userIGN);
        session.setAttribute("error", error);
        session.setAttribute("profileIcon", profileIcon);
        session.setAttribute("level", level);
        session.setAttribute("tierIcon", tierIcon);
        session.setAttribute("tier", tier);
        session.setAttribute("division", division);
        session.setAttribute("lp", lp);
        session.setAttribute("wins", wins);
        session.setAttribute("losses", losses);
        session.setAttribute("winRate", winRate);
        session.setAttribute("lobbyText", lobbyText);
        session.getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);
    }
}
