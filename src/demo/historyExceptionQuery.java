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
import java.util.Date;

@WebServlet("/historyException-query")
public class historyExceptionQuery extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String flag = request.getParameter("flag");
        String detection_id = request.getParameter("detection_id");
        int limit = Integer.parseInt(request.getParameter("limit"));
        int page = Integer.parseInt(request.getParameter("page"));
        ArrayList<ExceptionResult> erList = null;
        DetectionDaoImpl ddi = new DetectionDaoImpl();

        // 获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd");// a为am/pm的标记
        Date date = new Date();// 获取当前时间

        try {
            if(flag == null){
                String id = request.getParameter("id");
                erList = (id == null || id.equals("")) ? ddi.historyExceptionInfo(detection_id) : ddi.historyExceptionInfo(detection_id, id);
            }else if(flag.equals("true")){
                /* 获取全部筛选条件 */
                String test_line = request.getParameter("test_line");
                String error_type = request.getParameter("error_type");
                String staff = request.getParameter("staff");
                String solve_progress = request.getParameter("solve_progress");
                String beginTime = request.getParameter("beginTime");
                String endTime = request.getParameter("endTime");
                String solveTime = request.getParameter("solveTime");
                /* 处理筛选条件 */
                test_line = test_line.equals("all") ? "%" : test_line;
                error_type = error_type.equals("all") ? "%" : error_type;
                staff = staff.equals("all") ? "%" : staff;
                solve_progress = solve_progress.equals("all") ? "%" : solve_progress;
                beginTime = beginTime.equals("") ? "1970-01-01" : beginTime;
                endTime = endTime.equals("") ? sdf.format(date) : endTime;
                solveTime = solveTime.equals("") ? "%" : solveTime;

                erList = ddi.infoSelected(detection_id,test_line,error_type,staff,solve_progress,beginTime,endTime,solveTime);
            }


            if (!erList.isEmpty()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code", 0);
                jsonObject.put("msg", "");
                jsonObject.put("count", erList.size());
                JSONArray result = null;
                result = JSONArray.fromObject(erList.subList(limit * ((page - 1) < 0 ? 0 : (page - 1)), ((limit * page) > erList.size() ? erList.size() : (limit * page))));
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
