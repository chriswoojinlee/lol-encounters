package servlets;

import model.Lobby;
import model.Player;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "BlacklistServlet", urlPatterns = {"", "/"})
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userIGN");
        List<Player> players;
        String error;

        if(userName == null) {
            error = "No user in-game name was provided. Please try again.";

            request.setAttribute("error", error);
        } else {
            //Lobby lobby = new Lobby(players, userName);
        }

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

    }

    public void destroy() {
    }
}
