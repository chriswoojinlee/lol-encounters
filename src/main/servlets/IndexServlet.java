package servlets;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "IndexServlet", urlPatterns = "/")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userIGN = request.getParameter("userIGN");
        String registeredAccount = request.getParameter("registeredAccount");
        HttpSession session = request.getSession();

        if((userIGN == null || userIGN.isBlank()) && (registeredAccount == null || registeredAccount.isBlank())) {
            String error = "No in-game username was provided. Please try again.";
            session.setAttribute("error", error);
        } else {
            session.setAttribute("userIGN", userIGN);
        }

        session.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        HttpSession session = request.getSession();
        session.getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);
    }
}
