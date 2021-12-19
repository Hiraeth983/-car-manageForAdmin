package demo;

import com.alibaba.fastjson.JSON;
import implement.StaffDaoImpl;
import model.Staff;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/insertStaff")
public class insertStaff extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        String avgScore = request.getParameter("avgScore");
        String orderSum = request.getParameter("orderSum");
        String stationId = request.getParameter("stationId");
        String isAble = request.getParameter("isAble");
        StaffDaoImpl sdi = new StaffDaoImpl();
        try {
            Staff staff = new Staff();
            staff.setPassword(password);
            staff.setFullName(fullName);
            staff.setAvgScore(Double.parseDouble(avgScore));
            staff.setOrderSum(Integer.parseInt(orderSum));
            staff.setStationId(stationId);
            staff.setIsAble(Integer.parseInt(isAble));
            Boolean flag = sdi.insertStaff(staff);
            if (flag) {
                ArrayList<Staff> list = sdi.getStaffListByStationId(stationId);
                if (!list.isEmpty()){
                    response.getWriter().print(JSONArray.fromObject(list));
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

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}

