package demo;

import implement.StaffDaoImpl;
import model.Staff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/insertStaff")
public class insertStaff extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        StaffDaoImpl station = new StaffDaoImpl();
        try {
            PrintWriter out = response.getWriter();
            Staff staff = new Staff();
            String detection_id = request.getParameter("detection_id");
            staff.setStaff_id(request.getParameter("staff_id"));
            staff.setStaff_name(request.getParameter("staff_name"));
            staff.setDetection_id(request.getParameter("detection_id"));
            staff.setCredit_score(Integer.parseInt(request.getParameter("credit_score")));
            staff.setIllegal_number(Integer.parseInt(request.getParameter("illegal_number")));
            boolean flag = station.insertStaff(staff);
            if (flag) {
                out.print("<script language='javascript'>alert('添加成功！');window.location.href='queryStaff?detection_id=" + detection_id + "';</script>");
            } else {
                out.print("<script language='javascript'>alert('添加失败！');window.location.href='queryStaff?detection_id=" + detection_id + "';</script>");
            }

        } catch (Exception e) {
            response.sendRedirect("loginError.jsp");
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
