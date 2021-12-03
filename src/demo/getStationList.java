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

@WebServlet("/getStationList")
public class getStationList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        StationDaoImpl station = new StationDaoImpl();
        try {

            ArrayList<Station> stationList = station.allStationQuery();
            if (!stationList.isEmpty()) {
                //JSONObject jsonObject = new JSONObject();
                //jsonObject.put("code", 0);
                //jsonObject.put("msg", "");
                //jsonObject.put("count", stationList.size());
                //JSONArray result = null;
                //result = JSONArray.fromObject(stationList);
                //jsonObject.put("data", result);

                response.getWriter().print(JSONArray.fromObject(stationList));
            } else {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code", 1);
                jsonObject.put("msg", "暂无数据");
                jsonObject.put("count", 0);
                jsonObject.put("data", "");

                response.getWriter().print(jsonObject);
            }

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
