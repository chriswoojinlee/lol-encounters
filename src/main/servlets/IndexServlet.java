package servlets;

import model.User;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "IndexServlet", urlPatterns = "/")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String error;
        String userIGN = request.getParameter("userIGN");
        HttpSession session = request.getSession();

        if ((userIGN == null) || userIGN == "" || new User(userIGN).getNumGames() < 10) {
            error = "No in-game username was provided. Please try again.";
        } else {
            error = "";
            session.setAttribute("userIGN", userIGN);
        }

        session.setAttribute("error", error);
        session.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
