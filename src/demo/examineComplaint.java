package demo;

import com.alibaba.fastjson.JSON;
import implement.ComplaintDaoImpl;
import model.Complaint;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/examineComplaint")
public class examineComplaint extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String orderId = request.getParameter("orderId");
        String result = request.getParameter("result");
        String stationId = request.getParameter("stationId");
        stationId = "".equals(stationId) ? "1" : stationId;
        ComplaintDaoImpl complaintDao = new ComplaintDaoImpl();
        try {
            Complaint complaint = new Complaint();
            complaint.setOrderId(orderId);
            complaint.setResult(result);
            Boolean flag = complaintDao.examineComplaint(complaint);
            if (flag) {
                ArrayList<Complaint> complaintList = complaintDao.getComplaintListByStationId(stationId);
                if (!complaintList.isEmpty()){
                    response.getWriter().print(JSONArray.fromObject(complaintList));
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

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}

