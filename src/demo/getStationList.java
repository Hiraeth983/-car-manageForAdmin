package demo;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.alibaba.fastjson.JSON;
import implement.*;
import model.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/getStationList")
public class getStationList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        StationDaoImpl station = new StationDaoImpl();
        try {

            ArrayList<Station> stationList = station.getStationList();
            if (!stationList.isEmpty()) {
                response.getWriter().print(JSONArray.fromObject(stationList));
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
