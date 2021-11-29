package demo;

import dao.PhotoDao;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/uploadFile")
public class uploadFile extends HttpServlet {
    public uploadFile() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        try {
            //转接给相对应的函数去处理相关数据。
            addDVDInfo(request, response);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void addDVDInfo(HttpServletRequest request, HttpServletResponse response) throws
            IOException, SQLException, ServletException {
        List<String> list = new ArrayList<String>();
        String filename = PhotoDao.getPhotoNewName();
        ServletContext servletContext = null;
        servletContext = request.getSession().getServletContext();
        //第一步:获取页面上上传的图片资源
        List<FileItem> items = PhotoDao.getRequsetFileItems(request, servletContext);

        boolean isLoadToSQL = false;
        for (FileItem item : items) {
            if (!item.isFormField()) {
                //判断后缀名是否是mp4
                if (PhotoDao.isGif(item)) {
                    String path = "E:\\demo\\video";
                    PhotoDao.saveFile(path, item, filename);
                } else {
                    System.out.println("后缀格式有误，保存文件失败");
                }
            } else {
                list.add(item.getString("UTF-8"));
            }
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg", "");
        jsonObject.put("src", "/video/" + filename);
        jsonObject.put("fileName", filename);

        response.getWriter().print(jsonObject);

    }

    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        doGet(request, response);
    }
}