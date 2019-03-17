package cn.forlkc.servlet;

import cn.forlkc.service.RegisterService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ActiveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        RegisterService registerService = new RegisterService();
        int result = registerService.codeExist(code);
        JSONObject jsonObject = new JSONObject();
        if(result == 1){
            jsonObject.put("status","200");
            jsonObject.put("desc","激活成功");
        }else {
            jsonObject.put("status","400");
            jsonObject.put("desc","激活失败");
        }
        response.sendRedirect("/blog/html/login.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
