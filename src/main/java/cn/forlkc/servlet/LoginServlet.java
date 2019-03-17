package cn.forlkc.servlet;

import cn.forlkc.bean.User;
import cn.forlkc.bean.UserInformation;
import cn.forlkc.service.LoginService;
import cn.forlkc.service.UserInformationService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    /*
    return: 0:账号停用；-1：账号不存在；
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginService loginService = new LoginService();
        User user = new User();
        user.setUserid(request.getParameter("userid"));
        user.setPassword(request.getParameter("password"));


        JSONObject json = new JSONObject();

       // HttpSession session = request.getSession();
        int result = -2;
        try {
            result = loginService.loginCheck(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(result == 1){
            user.setPassword(null);
            try {

                UserInformation userInformation = UserInformationService.getInformationByid(user.getUserid());
                json.put("status",200);
                json.put("desc","登陆成功");
                json.put("userName",userInformation.getName());

                //Cookie cookie = new Cookie("userid",user.getUserid());
                //session.setAttribute("userid",user.getUserid());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(result == 0){
            json.put("status","400");
            json.put("desc","账号尚未激活或者已被停用");
        }else if (result == -1){
            json.put("status","400");
            json.put("desc","账号不存在");
        }else {
            json.put("status","400");
            json.put("desc","密码错误");
        }

        response.getWriter().write(json.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
