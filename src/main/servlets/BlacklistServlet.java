package servlets;

import model.Player;
import model.PlayersParser;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "BlacklistServlet", urlPatterns = "/")
public class BlacklistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PlayersParser playersParser;
        List<Player> players;
        String error;
        String userIGN = request.getParameter("userIGN");
        String lobbyText = request.getParameter("lobby");

        if(userIGN == null || userIGN.isBlank() || lobbyText == null || lobbyText.isBlank()) {
            error = "No in-game username was provided. Please try again.";

            request.setAttribute("error", error);
        } else {
            //playersParser = new PlayersParser(lobbyText, userIGN);
            //Lobby lobby = new Lobby(playersParser.getPlayers(), new User(userIGN));

            request.setAttribute("userIGN", userIGN);
        }

        getServletContext().getRequestDispatcher("/landing.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        getServletContext().getRequestDispatcher("/landing.jsp").forward(request, response);
    }

}
