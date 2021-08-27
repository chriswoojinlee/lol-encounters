package servlets;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Platform;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import model.Player;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Orianna.Configuration config = new Orianna.Configuration();
        Orianna.loadConfiguration(config);
        config.setDefaultPlatform(Platform.NORTH_AMERICA);
        Orianna.setDefaultLocale("en_US");
        Orianna.setRiotAPIKey("RGAPI-f7d8a98d-9f45-46c4-9a14-b28ddaa00e04");
        HttpSession session = request.getSession(false);
        String userIGN = (String) session.getAttribute("userIGN");
        Summoner user = Summoner.named("LeeWooJin").withRegion(Region.NORTH_AMERICA).get();
        Player player = new Player("LeeWooJin");
        String profileIcon = user.getProfileIcon().getImage().getURL();
        int level = user.getLevel();
        String tier = player.getCurrentTier();
        String division = player.getCurrentDivision();
        String lp = player.getCurrentLP();
        int wins = player.getWins();
        int losses = player.getLosses();
        double winRate = player.getWinRate();
        session.setAttribute("userIGN", userIGN);
        session.setAttribute("profileIcon", profileIcon);
        session.setAttribute("level", level);
        session.setAttribute("lp", lp);
        session.setAttribute("wins", wins);
        session.setAttribute("losses", losses);
        session.setAttribute("winRate", winRate);
        session.getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

    }
}
