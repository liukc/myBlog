package cn.forlkc.servlet;

import cn.forlkc.service.ArticleService;
import cn.forlkc.tools.Statistics;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String page = request.getParameter("toPage");
        int count = 0;

        JSONArray jsonArray = null;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status",200);
        jsonObject.put("desc","成功");

        try {
            jsonArray = ArticleService.pagination(type, page);
            count = Statistics.countBlog(type)/6;

        } catch (Exception e) {
            jsonObject.put("status",400);
            jsonObject.put("desc","数据查询失败");
            e.printStackTrace();
        }finally {
            jsonObject.put("allPage",count);
            jsonArray.add(jsonObject);

            response.getWriter().write(jsonArray.toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
