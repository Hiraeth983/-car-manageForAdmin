package demo;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import implement.*;
import model.*;

@WebServlet("/detectionInfo-query")
public class detectionInfoQuery extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        DetectionDaoImpl detection = new DetectionDaoImpl();
        String detection_id = request.getParameter("detection_id");
        try {
            int allDetectionCount = detection.allDetectionCount(detection_id);
            int abnormalDetectionCount = detection.abnormalDetectionCount(detection_id);
            int historyAllDetectionCount = detection.historyAllDetectionCount(detection_id);
            int historyAbnormalDetectionCount = detection.historyAbnormalDetectionCount(detection_id);
            ArrayList<DateStatusInfo> dsiList = detection.processStatusInfo(detection_id);

            request.getSession().setAttribute("dsiList",dsiList);
            request.getSession().setAttribute("allDetectionCount",allDetectionCount);
            request.getSession().setAttribute("abnormalDetectionCount",abnormalDetectionCount);
            request.getSession().setAttribute("historyAllDetectionCount",historyAllDetectionCount);
            request.getSession().setAttribute("historyAbnormalDetectionCount",historyAbnormalDetectionCount);
            response.sendRedirect("detectionInfo.jsp");
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
