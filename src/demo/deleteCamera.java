package demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import implement.*;

@WebServlet("/deleteCamera")
public class deleteCamera extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        CameraDaoImpl station = new CameraDaoImpl();
        try {
            PrintWriter out = response.getWriter();
            String camera_id = request.getParameter("camera_id");
            boolean flag = station.deleteCamera(camera_id);
            if (flag) {
                out.print("<script language='javascript'>alert('删除成功！');window.location.href='queryCamera';</script>");
            } else {
                out.print("<script language='javascript'>alert('删除失败！');window.location.href='queryCamera';</script>");
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
