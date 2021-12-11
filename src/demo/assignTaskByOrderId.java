package demo;

import implement.RecordDaoImpl;
import model.Record;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/assignTaskByOrderId")
public class assignTaskByOrderId extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String orderId = request.getParameter("orderId");
        String checkTime = request.getParameter("checkTime");
        String staffId = request.getParameter("staffId");
        String staffName = request.getParameter("staffName");
        RecordDaoImpl rdi = new RecordDaoImpl();
        try {
            Record record = new Record();
            record.setOrderId(orderId);
            record.setCheckTime(checkTime);
            record.setStaffId(staffId);
            record.setStaffName(staffName);
            record.setProcess("已分配");
            Boolean flag = rdi.assignTaskByOrderId(record);
            if (flag) {
                ArrayList<Record> list = rdi.getRecordList();
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

