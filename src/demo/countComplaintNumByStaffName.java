package demo;

import implement.ComplaintDaoImpl;
import implement.RecordDaoImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/countComplaintNumByStaffName")
public class countComplaintNumByStaffName extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String stationId = request.getParameter("stationId");
        stationId = "".equals(stationId) ? "1" : stationId;
        ComplaintDaoImpl complaintDao = new ComplaintDaoImpl();
        try {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("data", "[{name:'张拓',value:10},{name:'李龙',value:15},{name:'吴俊汐',value:9}]");
            response.getWriter().print(jsonObject);

            //JSONArray result = null;
            //result = JSONArray.fromObject(list);
            //jsonObject.put("data", result);
            //ArrayList<Record> recordList = rdi.getRecordList();
            //if (!recordList.isEmpty()) {
            //    response.getWriter().print(JSONArray.fromObject(recordList));
            //} else {
            //    response.getWriter().print(JSON.toJSONString("暂无数据"));
            //}

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

