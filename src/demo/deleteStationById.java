package demo;

import com.alibaba.fastjson.JSON;
import implement.StationDaoImpl;
import model.Station;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/deleteStationById")
public class deleteStationById extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String stationId = request.getParameter("stationId");
        StationDaoImpl sdi = new StationDaoImpl();
        try {
            Boolean flag = sdi.deleteStationById(stationId);
            if (flag) {
                ArrayList<Station> list = sdi.getStationList();

                if (!list.isEmpty()){
                    response.getWriter().print(JSONArray.fromObject(list));
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

