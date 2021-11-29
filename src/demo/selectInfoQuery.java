package demo;

import implement.LineDaoImpl;
import implement.StaffDaoImpl;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;


@WebServlet("/selectInfo-query")
public class selectInfoQuery extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        String detection_id = request.getParameter("detection_id");
        LineDaoImpl ldi = new LineDaoImpl();
        StaffDaoImpl sdi = new StaffDaoImpl();

        try {
            ArrayList<String> lineList = ldi.allLineInfo(detection_id);
            ArrayList<String> staffList = sdi.allStaffInfo(detection_id);

            if(lineList == null){
                request.getSession().setAttribute("lineList",new ArrayList<String>().add("暂无数据"));
            }else{
                request.getSession().setAttribute("lineList",lineList);
            }
            if(staffList == null){
                request.getSession().setAttribute("staffList",new ArrayList<String>().add("暂无数据"));
            }else{
                request.getSession().setAttribute("staffList",staffList);
            }

            response.sendRedirect("multidimensionalselect.jsp");


        } catch (Exception e) {
            response.sendRedirect("loginError.jsp");
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
