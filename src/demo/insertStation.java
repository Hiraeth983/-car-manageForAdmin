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

@WebServlet("/insertStation")
public class insertStation extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String longitude = request.getParameter("longitude");
        String latitude = request.getParameter("latitude");
        String address = request.getParameter("address");
        String stationName = request.getParameter("stationName");
        String phone = request.getParameter("phone");
        String maxNum = request.getParameter("maxNum");
        String currentNum = request.getParameter("currentNum");
        StationDaoImpl sdi = new StationDaoImpl();
        try {
            Station station = new Station();
            station.setLongitude(Float.parseFloat(longitude));
            station.setLatitude(Float.parseFloat(latitude));
            station.setAddress(address);
            station.setStationName(stationName);
            station.setPhone(phone);
            station.setMaxNum(Integer.parseInt(maxNum));
            station.setCurrentNum(Integer.parseInt(currentNum));
            Boolean flag = sdi.insertStation(station);
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

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}

