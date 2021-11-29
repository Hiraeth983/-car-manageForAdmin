package demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import model.User;
import implement.*;

@WebServlet("/verify-admin")
public class verifyAdmin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        String number = request.getParameter("number");
        String password = request.getParameter("password");
        try {
            LoginDaoImpl login = new LoginDaoImpl();
            User user = login.verifyStatus(number, password);

            if (user != null) {
                StationDaoImpl station = new StationDaoImpl();
                if (user.getStatus().equals("管理员")) {
                    request.getServletContext().setAttribute("status",number);
                    request.getSession().setAttribute("siteList", station.allStationQuery());
                    request.getRequestDispatcher("home.jsp").forward(request, response);   //请求转发到管理员首页

                } else if (user.getStatus().equals("站长")) {

                } else {
                    response.sendRedirect("loginError.jsp");
                }
            } else {
                response.sendRedirect("loginError.jsp");
            }

        } catch (Exception e) {
            response.sendRedirect("loginError.jsp");
            e.printStackTrace();
        }

    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }

}
