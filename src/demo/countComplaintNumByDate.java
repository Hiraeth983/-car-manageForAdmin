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

@WebServlet("/countComplaintNumByDate")
public class countComplaintNumByDate extends HttpServlet {
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
            jsonObject.put("data", "[{'date':'2021-12-01','count':5},{'date':'2021-12-02','count':3},{'date':'2021-12-03','count':6},{'date':'2021-12-04','count':2},{'date':'2021-12-05','count':4},{'date':'2021-12-06','count':7},{'date':'2021-12-07','count':9}]");
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


