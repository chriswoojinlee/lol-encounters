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
        Orianna.Configuration config = new Orianna.Configuration();
        Orianna.loadConfiguration(config);
        config.setDefaultPlatform(Platform.NORTH_AMERICA);
        Orianna.setDefaultLocale("en_US");
        Orianna.setRiotAPIKey("");
        HttpSession session = request.getSession(false);
        String userIGN = request.getParameter("userIGN");
        User user = new User(userIGN);
        String profileIcon = user.getSummoner().getProfileIcon().getImage().getURL();
        int level = user.getSummoner().getLevel();
        String tier = user.getCurrentTier();
        String division = user.getCurrentDivision();
        String lp = user.getCurrentLP();
        int wins = user.getWins();
        int losses = user.getLosses();
        double winRate = user.getWinRate();
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
