package demo;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import implement.*;
import model.*;

@WebServlet("/allStationJump-query")
public class allStationJumpQuery extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        StationDaoImpl station = new StationDaoImpl();
        try {

            ArrayList<Site> siteList = station.allStationQuery();
            if (!siteList.isEmpty()) {
                request.getSession().setAttribute("siteList",siteList);
                response.sendRedirect("home.jsp");
            } else {
                response.sendRedirect("loginError.jsp");
            }

        } catch (Exception e) {
            response.sendRedirect("loginError.jsp");
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
}
