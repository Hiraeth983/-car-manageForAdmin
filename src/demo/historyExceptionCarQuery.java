package demo;

import implement.DetectionDaoImpl;
import model.ExceptionResult;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@WebServlet("/historyExceptionCar-query")
public class historyExceptionCarQuery extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static java.sql.Date strToDate(String strDate) {
        String str = strDate;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = null;
        try {
            d = format.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.sql.Date date = new java.sql.Date(d.getTime());
        return date;
    }
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String detection_id = request.getParameter("detection_id");
        String id = request.getParameter("id");
        String type1=request.getParameter("type1");
        String time = request.getParameter("time");
        int limit = Integer.parseInt(request.getParameter("limit"));
        int page = Integer.parseInt(request.getParameter("page"));
        java.sql.Date newtime = strToDate("1997-07-21");
        if (time!=null&&!time.equals("")){
            newtime = strToDate(time);
        }
        ArrayList<ExceptionResult> drList = null;
        DetectionDaoImpl ddi = new DetectionDaoImpl();
        try {
            if (id == null || id.equals("")){
                drList = ddi.historyExceptionInfo(detection_id);
            }
            else if ("testid".equals(type1)){
                drList = ddi.historyExceptionInfo(detection_id,id);
            }
            else if ("carid".equals(type1)){
                drList = ddi.historyExceptionInfoByPlate(detection_id,id);
            }
            else {
                drList = ddi.historyExceptionInfoByTime(detection_id,newtime);
            }
            if (!drList.isEmpty()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code", 0);
                jsonObject.put("msg", "");
                jsonObject.put("count", drList.size());
                JSONArray result = null;
                result = JSONArray.fromObject(drList.subList(limit * ((page - 1) < 0 ? 0 : (page - 1)), ((limit * page) > drList.size() ? drList.size() : (limit * page))));
                jsonObject.put("data", result);

                response.getWriter().print(jsonObject);
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
