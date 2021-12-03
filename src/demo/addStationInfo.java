package demo;

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

@WebServlet("/addStationInfo")
public class addStationInfo extends HttpServlet {
    private static final long serialVersionUID = 1L;

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
        StationDaoImpl sdi = new StationDaoImpl();
        try {
            Station station = new Station();
            station.setLongitude(Float.parseFloat(longitude));
            station.setLatitude(Float.parseFloat(latitude));
            station.setAddress(address);
            station.setStationName(stationName);
            station.setPhone(phone);
            station.setMaxNum(Integer.parseInt(maxNum));
            Boolean flag = sdi.insertStation(station);
            if (flag) {
                ArrayList<Station> list = sdi.allStationQuery();
                response.getWriter().print(JSONArray.fromObject(list));
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

