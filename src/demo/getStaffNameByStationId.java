package demo;

import implement.StaffDaoImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/getStaffNameByStationId")
public class getStaffNameByStationId extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String stationId = request.getParameter("stationId");
        StaffDaoImpl sdi = new StaffDaoImpl();
        try {
            ArrayList<String> staffNameList = sdi.getStaffNameByStationId(stationId);
            if (staffNameList != null) {
                response.getWriter().print(JSONArray.fromObject(staffNameList));
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

