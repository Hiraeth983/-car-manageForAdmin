package demo;

import implement.AdminLogDaoImpl;
import model.AdminLog;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/insertAdminLog")
public class insertAdminLog extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String stationId = request.getParameter("stationId");
        AdminLogDaoImpl adi = new AdminLogDaoImpl();
        try {
            AdminLog adminLog = new AdminLog();
            adminLog.setUserName(userName);
            adminLog.setPassword(password);
            adminLog.setStationId(stationId);
            Boolean flag = adi.insertAdminLog(adminLog);
            if (flag) {
                ArrayList<AdminLog> adminLogList = adi.getAdminLogList();
                response.getWriter().print(JSONArray.fromObject(adminLogList));
            } else {
                response.sendRedirect("error.jsp");
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

