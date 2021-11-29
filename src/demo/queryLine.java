package demo;

import implement.LineDaoImpl;
import model.Line;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/queryLine")
public class queryLine extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String detection_id = request.getParameter("detection_id");
        LineDaoImpl line = new LineDaoImpl();
        try {

            ArrayList<Line> lineList = line.queryLine(detection_id);
            if (!lineList.isEmpty()) {
                request.getSession().setAttribute("lineList", lineList);
                response.sendRedirect("checkDetetion.jsp");
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
        String detection_id = request.getParameter("detection_id");
        LineDaoImpl line = new LineDaoImpl();
        String test_line = request.getParameter("test_line");
        try {
            ArrayList<Line> lineList = line.queryLine(detection_id, test_line);
            if (!lineList.isEmpty()) {
                request.getSession().setAttribute("lineList", lineList);
                response.sendRedirect("checkDetetion.jsp");
            } else {
                response.sendRedirect("loginError.jsp");
            }
        } catch (Exception e) {
            response.sendRedirect("loginError.jsp");
            e.printStackTrace();
        }
    }
}
