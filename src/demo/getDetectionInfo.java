package demo;

import implement.RecordDaoImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getDetectionInfo")
public class getDetectionInfo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String stationId = request.getParameter("stationId");
        stationId = "".equals(stationId) ? "1" : stationId;
        RecordDaoImpl rdi = new RecordDaoImpl();
        try {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("dailyTotal", 23);
            jsonObject.put("dailyException", 5);
            jsonObject.put("historyTotal", 572);
            jsonObject.put("historyException", 89);
            jsonObject.put("data", "[{'date':'2021-12-01','apply':15,'assign':10,'complete':5},{'date':'2021-12-02','apply':25,'assign':12,'complete':13},{'date':'2021-12-03','apply':35,'assign':21,'complete':14},{'date':'2021-12-04','apply':12,'assign':8,'complete':4},{'date':'2021-12-05','apply':15,'assign':6,'complete':9},{'date':'2021-12-06','apply':28,'assign':16,'complete':12},{'date':'2021-12-07','apply':12,'assign':23,'complete':7}]");
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
