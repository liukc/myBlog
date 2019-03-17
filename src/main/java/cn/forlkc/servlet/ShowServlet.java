package cn.forlkc.servlet;

import cn.forlkc.service.ArticleService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        JSONObject jsonObject = new JSONObject();
        int status = 200;
        String desc = "操作成功";
        //jsonObject.put("status",200);
        try {
            jsonObject = ArticleService.showBlog(id);
        } catch (Exception e) {
            status = 400;
            desc = "操作失败";
            e.printStackTrace();
        }finally {
            jsonObject.put("status",status);
            jsonObject.put("desc",desc);

            response.getWriter().write(jsonObject.toString());
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
