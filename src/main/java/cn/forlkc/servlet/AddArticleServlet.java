package cn.forlkc.servlet;

import cn.forlkc.service.ArticleService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class AddArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String blog = request.getParameter("blog");
        String author = new String();
        Cookie[]cookies = ((HttpServletRequest) request).getCookies();
        for(Cookie c : cookies){
            if (c.getName().equals("userName")){
                author = c.getValue();
            }
        }
        int status = 200;
        JSONObject json = JSONObject.fromObject(blog);
        json.put("author",author);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status",status);
        jsonObject.put("desc","操作成功");
        try {
            ArticleService.addBlog(json);
            //json.clear();
        } catch (Exception e) {
            status = 401;
            jsonObject.put("status","401");
            jsonObject.put("desc","数据库操作异常");
            e.printStackTrace();
        }

        response.getWriter().write(jsonObject.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
