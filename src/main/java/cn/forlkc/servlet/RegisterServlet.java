package cn.forlkc.servlet;

import cn.forlkc.bean.User;
import cn.forlkc.service.RegisterService;
import cn.forlkc.tools.Encript;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        JSONObject jsonObject = new JSONObject();
        RegisterService registerService = new RegisterService();
        user.setUserid(request.getParameter("userid"));
        //user.setPassword(request.getParameter("password"));
        //md5加密
        user.setPassword(Encript.md5(request.getParameter("password")));
        user.setEmail(request.getParameter("email"));
        int result =  registerService.register(user);
        if(result == 1){
            jsonObject.put("status","200");
            jsonObject.put("desc","注册成功");
        }else {
            jsonObject.put("status","400");
            jsonObject.put("desc","账号已存在");
        }
        response.getWriter().write(jsonObject.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
