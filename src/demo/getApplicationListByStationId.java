package demo;

import com.alibaba.fastjson.JSON;
import implement.ApplicationDaoImpl;
import model.Application;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/getApplicationListByStationId")
public class getApplicationListByStationId extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String stationId = request.getParameter("stationId");
        stationId = "".equals(stationId) ? "1" : stationId;
        ApplicationDaoImpl applicationDao = new ApplicationDaoImpl();
        try {

            ArrayList<Application> applicationList = applicationDao.getApplicationListByStationId(stationId);
            if (!applicationList.isEmpty()) {
                response.getWriter().print(JSONArray.fromObject(applicationList));
            } else {
                response.getWriter().print(JSON.toJSONString("暂无数据"));
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

