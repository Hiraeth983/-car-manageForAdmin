package demo;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import implement.*;
import model.*;

@WebServlet("/stationData-query")
public class stationDataQuery extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // 获取当前时间
            SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
            sdf.applyPattern("yyyy-MM-dd");
            Date date = new Date();// 获取当前时间

            String detection_id = request.getParameter("detection_id");
            DetectionDaoImpl edi = new DetectionDaoImpl();
            int allDetectionCount = edi.allDetectionCount(detection_id);
            int normalDetectionCount = edi.normalDetectionCount(detection_id);
            int abnormalDetectionCount = edi.abnormalDetectionCount(detection_id);
            ArrayList<DetectionLineException> dleList = edi.detectionLineCount(detection_id);

            // 判断当日无检测异常车辆
            if (dleList == null) {
                DetectionLineException dle = new DetectionLineException("暂无数据",0);
                ArrayList<DetectionLineException> tempList = new ArrayList<DetectionLineException>();
                tempList.add(dle);
                request.getSession().setAttribute("dleList", tempList);
            } else {
                request.getSession().setAttribute("dleList", dleList);
            }

            request.getSession().setAttribute("allDetectionCount", allDetectionCount);
            request.getSession().setAttribute("normalDetectionCount", normalDetectionCount);
            request.getSession().setAttribute("abnormalDetectionCount", abnormalDetectionCount);
            request.getServletContext().setAttribute("detection_id",detection_id);
            request.getSession().setAttribute("date",sdf.format(date));
            response.sendRedirect("index.jsp");

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
