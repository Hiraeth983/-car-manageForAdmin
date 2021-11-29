package demo;

import implement.LineDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteLine")
public class deleteLine extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        LineDaoImpl station = new LineDaoImpl();
        try {
            PrintWriter out = response.getWriter();
            String detection_id = request.getParameter("detection_id");
            String test_line = request.getParameter("test_line");
            boolean flag = station.deleteLine(detection_id,test_line);
            if (flag) {
                out.print("<script language='javascript'>alert('删除成功！');window.location.href='queryLine?detection_id=" + detection_id + "';</script>");
            } else {
                out.print("<script language='javascript'>alert('删除失败！');window.location.href='queryLine?detection_id=" + detection_id + "';</script>");
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
