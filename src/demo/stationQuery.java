package demo;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import implement.*;
import model.*;

@WebServlet("/queryStation")
public class stationQuery extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        StationDaoImpl station = new StationDaoImpl();
        try {

            ArrayList<Site> stationList = station.allStationQuery();
            if (!stationList.isEmpty()) {
                request.getSession().setAttribute("stationList",stationList);
                response.sendRedirect("checkStation.jsp");
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
        StationDaoImpl station = new StationDaoImpl();
        String detection_id = request.getParameter("id");
        try {
            ArrayList<Site> stationList = station.allStationQuery(detection_id);
            if(!stationList.isEmpty()){
                request.getSession().setAttribute("stationList",stationList);
                response.sendRedirect("checkStation.jsp");
            } else {
                response.sendRedirect("loginError.jsp");
            }
        } catch (Exception e) {
            response.sendRedirect("loginError.jsp");
            e.printStackTrace();
        }
    }
}
