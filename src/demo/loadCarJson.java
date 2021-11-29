package demo;

import implement.ChartDaoImpl;
import model.CarChart;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/loadCarJson")
public class loadCarJson extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ChartDaoImpl cdi = new ChartDaoImpl();
        String date = request.getParameter("date");
        int num = Integer.parseInt(request.getParameter("num"));

        try {
            ArrayList<CarChart> carChartList = cdi.loadCarList(date, num);
            if (!carChartList.isEmpty()) {
                List<String> car_id = new ArrayList<>();
                List<Integer> error_count = new ArrayList<>();
                for (CarChart carChart : carChartList) {
                    car_id.add(carChart.getCar_id());
                    error_count.add(carChart.getError_count());
                }
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("car_id",car_id);
                jsonObject.put("error_count",error_count);
                //String result = JSON.toJSONString(carChartList);
                response.getWriter().print(jsonObject);
            } else {
                response.getWriter().print("[{error_type:'无',count:0}]");
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

