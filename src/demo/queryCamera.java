package demo;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import implement.*;
import model.*;

@WebServlet("/queryCamera")
public class queryCamera extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        CameraDaoImpl camera = new CameraDaoImpl();
        try {

            ArrayList<Camera> cameraList = camera.queryCamera();
            if (!cameraList.isEmpty()) {
                request.getSession().setAttribute("cameraList",cameraList);
                response.sendRedirect("camera.jsp");
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
        CameraDaoImpl camera = new CameraDaoImpl();
        String camera_id = request.getParameter("camera_id");
        try {
            ArrayList<Camera> cameraList = camera.queryCamera(camera_id);
            if(!cameraList.isEmpty()){
                request.getSession().setAttribute("cameraList",cameraList);
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
