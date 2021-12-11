package demo;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import implement.*;
import model.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/getRecordByCarId")
public class getRecordByCarId extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String carId = request.getParameter("carId");
        RecordDaoImpl rdi = new RecordDaoImpl();
        try {

            ArrayList<Record> recordList = rdi.getRecordByCarId(carId);
            if (!recordList.isEmpty()) {
                response.getWriter().print(JSONArray.fromObject(recordList));
            } else {
                response.getWriter().print("暂无数据");
            }

        } catch (Exception e) {
            response.sendRedirect("error.jsp");
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}

