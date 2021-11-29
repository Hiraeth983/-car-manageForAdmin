package demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import implement.*;
import model.*;

@WebServlet("/insertStation")
public class insertStation extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        StationDaoImpl station = new StationDaoImpl();
        try {
            PrintWriter out = response.getWriter();
            Site site = new Site();
            site.setId(request.getParameter("id"));
            site.setName(request.getParameter("name"));
            site.setLatitude(Float.parseFloat(request.getParameter("latitude")));
            site.setLongitude(Float.parseFloat(request.getParameter("longitude")));
            site.setDescribe(request.getParameter("describe"));
            boolean flag = station.insertStation(site);
            if (flag) {
                out.print("<script language='javascript'>alert('添加成功！');window.location.href='queryStation';</script>");
            } else {
                out.print("<script language='javascript'>alert('添加失败！');window.location.href='queryStation';</script>");
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
