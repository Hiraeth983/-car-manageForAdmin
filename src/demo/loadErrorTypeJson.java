package demo;

import com.alibaba.fastjson.JSON;
import implement.ChartDaoImpl;
import model.ErrorTypeChart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/loadErrorTypeJson")
public class loadErrorTypeJson extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ChartDaoImpl cdi = new ChartDaoImpl();
        String date = request.getParameter("date");
        int num = Integer.parseInt(request.getParameter("num"));

        try {
            ArrayList<ErrorTypeChart> errorTypeChartList = cdi.loadErrorTypeList(date, num);
            if (!errorTypeChartList.isEmpty()) {
                String result = JSON.toJSONString(errorTypeChartList);
                response.getWriter().print(result);
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

