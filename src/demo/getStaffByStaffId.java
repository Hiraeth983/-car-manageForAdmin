package demo;

import com.alibaba.fastjson.JSON;
import implement.StaffDaoImpl;
import model.Staff;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getStaffByStaffId")
public class getStaffByStaffId extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String staffId = request.getParameter("staffId");
        String stationId = request.getParameter("stationId");
        StaffDaoImpl sdi = new StaffDaoImpl();
        try {
            Staff staff = null;
            staff = sdi.getStaffByStaffId(staffId,stationId);
            if (staff != null) {
                response.getWriter().print(JSONArray.fromObject(staff));
            } else {
                response.getWriter().print(JSON.toJSONString("暂无数据"));
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

