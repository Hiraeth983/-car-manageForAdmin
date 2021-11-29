package demo;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import implement.*;

@WebServlet("/deleteStation")
public class deleteStation extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        StationDaoImpl station = new StationDaoImpl();
        try {
            PrintWriter out = response.getWriter();
            String id = request.getParameter("id");
            boolean flag = station.deleteStation(id);
            if (flag) {
                out.print("<script language='javascript'>alert('删除成功！');window.location.href='queryStation';</script>");
            } else {
                out.print("<script language='javascript'>alert('删除失败！');window.location.href='queryStation';</script>");
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
