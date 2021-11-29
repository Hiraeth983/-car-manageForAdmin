package demo;

import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

@WebServlet("/generateReport")
public class generateReport extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        // 获取检测id
        String detection_id = request.getParameter("detection_id");
        String id = request.getParameter("id");
        String car_id = request.getParameter("car_id");
        String detection_date = request.getParameter("detection_date");
        String test_result = request.getParameter("test_result");
        String error_type = request.getParameter("error_type");
        String error_describe = request.getParameter("error_describe");
        String staff_id = request.getParameter("staff_id");
        String template =
                FileUtils.readFileToString(new File("D:\\IntelliJ IDEA 2021.1\\car\\template"), "UTF-8");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("car_id", car_id);
        jsonObject.put("detection_date", detection_date);
        jsonObject.put("drive_name", "刘明辉");
        jsonObject.put("test_result", test_result);
        jsonObject.put("error_type", error_type);
        jsonObject.put("error_describe", error_describe);
        jsonObject.put("staff_id", staff_id);

        String result = jsonObject.toString();
        //template = template.replaceFirst("myResult", "{\"id\": \"2109080001\",\"car_id\": \"浙A125D75\",\"detection_date\": \"2021/09/08\",\"driver_name\": \"李明\",\"test_result\": \"异常\",\"error_type\": \"发动机故障\",\"error_describe\": \"发动机缺失\",\"staff_id\": \"林布琛\"}");
        template = template.replaceFirst("myResult", result);

        PrintStream printStream = null;
        printStream = new PrintStream(new FileOutputStream("D:\\IntelliJ IDEA 2021.1\\car\\report.html"), false, "UTF-8");//路径默认在项目根目录下
        printStream.println(template);

        // 跳转到原界面
        response.sendRedirect("historyException-query?limit=10&page=1&id=&flag=null&detection_id=" + detection_id);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}