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

@WebServlet("/getAdminLogByStationId")
public class getAdminLogByStationId extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String stationId = request.getParameter("stationId");
        AdminLogDaoImpl adi = new AdminLogDaoImpl();
        try {
            ArrayList<AdminLog> adminLogByStationId = adi.getAdminLogByStationId(stationId);
            if (adminLogByStationId != null) {
                response.getWriter().print(JSONArray.fromObject(adminLogByStationId));
            } else {
                response.getWriter().print("暂无数据");
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

