package demo;

import implement.StaffDaoImpl;
import model.Staff;
import model.StaffChart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/queryStaff")
public class queryStaff extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String detection_id = request.getParameter("detection_id");
        StaffDaoImpl staff = new StaffDaoImpl();
        try {
            ArrayList<Staff> staffList = staff.allStaffQuery(detection_id);
            ArrayList<StaffChart> StaffCharts = staff.staffChart(detection_id);
            if (!(staffList.isEmpty() && StaffCharts.isEmpty())) {
                request.getSession().setAttribute("staffList", staffList);
                request.getSession().setAttribute("staffCharts", StaffCharts);
                response.sendRedirect("checkStaff.jsp");
            } else {
                response.sendRedirect("loginError.jsp");
            }

        } catch (Exception e) {
            response.sendRedirect("loginError.jsp");
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        StaffDaoImpl staff = new StaffDaoImpl();
        String detection_id = request.getParameter("detection_id");
        String staff_id = request.getParameter("staff_id");
        try {
            ArrayList<Staff> staffList = staff.allStaffQuery(detection_id, staff_id);
            if (!staffList.isEmpty()) {
                request.getSession().setAttribute("staffList", staffList);
                response.sendRedirect("checkStaff.jsp");
            } else {
                response.sendRedirect("loginError.jsp");
            }
        } catch (Exception e) {
            response.sendRedirect("loginError.jsp");
            e.printStackTrace();
        }
    }
}
