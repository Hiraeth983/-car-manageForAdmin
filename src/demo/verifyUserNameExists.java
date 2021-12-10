package demo;


import implement.AdminLogDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/verifyUserNameExists")
public class verifyUserNameExists extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        //0、获取method判断执行操作
        String method = request.getParameter("method");
        if ("checkUserName".equals(method)) {
            //验证用户名是否已存在
            try {
                checkUserName(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    //根据用户名称查询，检查用户名称的唯一性（用户注册）
    public void checkUserName(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        //返回json数据，格式为{"valid",true}	表示合法，验证通过。{"valid":false} 表示不合法，验证不通过
        String jsonResult = "";
        String userName = request.getParameter("userName");
        //去数据进行唯一性确认
        if (userName != null) {
            AdminLogDaoImpl adi = new AdminLogDaoImpl();
            //服务层service调用数据库访问层dao中的searchUserName方法。
            boolean b = adi.searchUserName(userName);
            if (b) {
                //如果名称存在
                jsonResult = "{\"valid\":false}";
            } else {
                //如果该名称不存在
                jsonResult = "{\"valid\":true}";
            }
        } else {
            jsonResult = "{\"valid\":false}";
        }
        //response把jsonResult打到前台
        response.getWriter().write(jsonResult);
    }
}

