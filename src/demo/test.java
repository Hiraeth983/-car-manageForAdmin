package demo;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import org.apache.commons.io.FileUtils;

import java.io.*;

public class test {
    public static void main(String[] args) throws IOException {
        JSON result = new JSONArray();
        String template = FileUtils.readFileToString(new File("template"));
        template = template.replaceFirst("myResult", "{\"id\": \"111111111\",\"car_id\": \"浙A125D75\",\"detection_date\": \"2021/09/08\",\"driver_name\": \"李明\",\"test_result\": \"异常\",\"error_type\": \"发动机故障\",\"error_describe\": \"发动机缺失\",\"staff_id\": \"林布琛\"}");

        PrintStream printStream = null;

        printStream = new PrintStream(new FileOutputStream("report.html"));//路径默认在项目根目录下

        printStream.println(template);
    }
}
