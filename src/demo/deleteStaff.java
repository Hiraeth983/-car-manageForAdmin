package demo;

import implement.StaffDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteStaff")
public class deleteStaff extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        StaffDaoImpl station = new StaffDaoImpl();
        try {
            PrintWriter out = response.getWriter();
            String detection_id = request.getParameter("detection_id");
            String staff_id = request.getParameter("staff_id");
            boolean flag = station.deleteStaff(detection_id, staff_id);
            if (flag) {
                out.print("<script language='javascript'>alert('删除成功！');window.location.href='queryStaff?detection_id=" + detection_id + "';</script>");
            } else {
                out.print("<script language='javascript'>alert('删除失败！');window.location.href='queryStaff?detection_id=" + detection_id + "';</script>");
            }

        } catch (Exception e) {
            response.sendRedirect("loginError.jsp");
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
