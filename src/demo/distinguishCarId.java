package demo;

import implement.CarDaoImpl;
import model.Car;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/distinguishCarId")
public class distinguishCarId extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String fileName = request.getParameter("fileName");


        String[] arguments = new String[]{"python", "E:\\demo\\work\\PaddleOCR\\tools\\infer\\predict_system.py", fileName};
        //String[] arguments = new String[]{"python", "E:\\demo\\file.py"};
        try {
            Process process = Runtime.getRuntime().exec(arguments);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            //java代码中的process.waitFor()返回值为0表示我们调用python脚本成功，
            //返回值为1表示调用python脚本失败，这和我们通常意义上见到的0与1定义正好相反
            int re = process.waitFor();
            System.out.println(re);
        } catch (Exception e) {
            e.printStackTrace();
        }


        /* 读入TXT文件 */
        String pathname = "E:\\demo\\carID.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
        File filename = new File(pathname); // 要读取以上路径的input。txt文件
        InputStreamReader reader = new InputStreamReader(
                new FileInputStream(filename)); // 建立一个输入流对象reader
        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
        String line = "";
        line = br.readLine();
        br.close();

        CarDaoImpl cdi = new CarDaoImpl();
        Car car = new Car();
        try {
            car = cdi.queryInfo(line);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("car_id", car.getCar_id());
        jsonObject.put("car_model", car.getCar_modle());
        jsonObject.put("car_age", car.getCar_age());
        jsonObject.put("car_owner", "林布琛");
        jsonObject.put("endorsement_YorN", car.getEndorsement_YorN());
        jsonObject.put("recently_AS", car.getRecently_AS());
        response.getWriter().print(jsonObject);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
