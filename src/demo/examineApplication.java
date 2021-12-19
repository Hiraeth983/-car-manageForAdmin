package demo;

import com.alibaba.fastjson.JSON;
import implement.ApplicationDaoImpl;
import implement.StationDaoImpl;
import model.Application;
import model.Station;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/examineApplication")
public class examineApplication extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String orderId = request.getParameter("orderId");
        String state = request.getParameter("state");
        String stationId = request.getParameter("stationId");
        stationId = "".equals(stationId) ? "1" : stationId;
        ApplicationDaoImpl applicationDao = new ApplicationDaoImpl();
        try {
            Application app = new Application();
            app.setOrderId(orderId);
            app.setState(state);
            Boolean flag = applicationDao.examineApplication(app);
            if (flag) {
                ArrayList<Application> applicationList = applicationDao.getApplicationListByStationId(stationId);
                if (!applicationList.isEmpty()){
                    response.getWriter().print(JSONArray.fromObject(applicationList));
                }else{
                    response.getWriter().print(JSON.toJSONString("暂无数据"));
                }
            } else {
                response.sendRedirect("error.jsp");
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

