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
        Orianna.Configuration config = new Orianna.Configuration();
        Orianna.loadConfiguration(config);
        config.setDefaultPlatform(Platform.NORTH_AMERICA);
        Orianna.setDefaultLocale("en_US");
        Orianna.setRiotAPIKey("RGAPI-10828af1-ef54-40a4-bf22-2022c5f6a329");
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
        } else {
            error = "";
            User user = new User(userIGN);
            profileIcon = user.getSummoner().getProfileIcon().getImage().getURL();
            level = "Level " + user.getSummoner().getLevel();
            tier = user.getCurrentTier();
            division = user.getCurrentDivision();
            lp = user.getCurrentLP() + " LP";
            wins = " / " + user.getWins() + "W";
            losses = " " + user.getLosses() + "L";
            winRate = user.getWinRate() + "% Win Ratio";
        }

        session.setAttribute("error", error);
        session.setAttribute("profileIcon", profileIcon);
        session.setAttribute("level", level);
        session.setAttribute("tier", tier);
        session.setAttribute("division", division);
        session.setAttribute("lp", lp);
        session.setAttribute("wins", wins);
        session.setAttribute("losses", losses);
        session.setAttribute("winRate", winRate);

        session.getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

    }
}
