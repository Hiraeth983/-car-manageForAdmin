package demo;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import implement.*;
import model.*;

@WebServlet("/errorDescribe")
public class errorDescribe extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String myType = request.getParameter("myType");
        String myDate = request.getParameter("myDate");
        String myCarId = request.getParameter("myCarId");
        try {
            PrintWriter writer = response.getWriter();
            writer.write("经检查，本检测站于 " + myDate + " 发现车牌号为 " + myCarId + " 车辆出现" + myType + "异常，请近期进行修正并进行再次年检。");


        } catch (Exception e) {
            response.sendRedirect("loginError.jsp");
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        CameraDaoImpl camera = new CameraDaoImpl();
        String camera_id = request.getParameter("camera_id");
        try {
            ArrayList<Camera> cameraList = camera.queryCamera(camera_id);
            if (!cameraList.isEmpty()) {
                request.getSession().setAttribute("cameraList", cameraList);
                response.sendRedirect("camera.jsp");
            } else {
                response.sendRedirect("loginError.jsp");
            }
        } catch (Exception e) {
            response.sendRedirect("loginError.jsp");
            e.printStackTrace();
        }
    }
}
