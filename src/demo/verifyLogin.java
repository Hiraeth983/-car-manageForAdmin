package demo;


import implement.AdminLogDaoImpl;
import model.AdminLog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/verifyLogin")
public class verifyLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        try {
            // 首先判断是否为平台管理员
            if ("admin".equals(userName) && "admin".equals(password)) {
                response.sendRedirect("manageStation.jsp");
            } else {
                AdminLogDaoImpl ldi = new AdminLogDaoImpl();
                AdminLog adminLog = ldi.getAdminLogByUserName(userName);
                if (adminLog != null) {
                    request.getSession().setAttribute("stationId", adminLog.getStationId());
                    response.sendRedirect("manageStaff.jsp");
                } else {
                    response.sendRedirect("error.jsp");
                }
            }

        } catch (Exception e) {
            response.sendRedirect("error.jsp");
            e.printStackTrace();
        }

    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

}

