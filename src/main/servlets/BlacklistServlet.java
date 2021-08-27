package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "BlacklistServlet", urlPatterns = "/blacklist")
public class BlacklistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String userIGN = (String) session.getAttribute("userIGN");
        session.setAttribute("userIGN", userIGN);
        session.getServletContext().getRequestDispatcher("/blacklist.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        HttpSession session = request.getSession(false);
        session.getServletContext().getRequestDispatcher("/blacklist.jsp").forward(request, response);
    }
}
