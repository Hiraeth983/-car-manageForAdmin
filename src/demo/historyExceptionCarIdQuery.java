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
import java.util.ArrayList;

@WebServlet("/historyExceptionCarId-query")
public class historyExceptionCarIdQuery extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String car_id = request.getParameter("car_id");
        String id = request.getParameter("id");
        int limit = Integer.parseInt(request.getParameter("limit"));
        int page = Integer.parseInt(request.getParameter("page"));
        ArrayList<ExceptionResult> drList = null;
        DetectionDaoImpl ddi = new DetectionDaoImpl();
        try {
            drList = (id == null || id.equals("")) ? ddi.historyExceptionCarIdInfo(car_id) : ddi.historyExceptionCarIdInfo(car_id, id);

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
