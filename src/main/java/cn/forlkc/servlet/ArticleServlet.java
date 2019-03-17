package cn.forlkc.servlet;

import cn.forlkc.service.ArticleService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int staus = 400;
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = null;

        jsonObject.put("status",staus);
        jsonObject.put("desc","操作成功");
        try {
            jsonArray = ArticleService.dialy(request.getParameter("type"));
        } catch (Exception e) {
            staus = 401;
            jsonObject.put("status",staus);
            jsonObject.put("desc","出现异常");
            e.printStackTrace();

        }finally {
            jsonArray.add(jsonObject);
        }
        System.out.println(jsonArray.toString());
        response.getWriter().write(jsonArray.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
