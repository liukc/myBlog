package cn.forlkc.service;

import cn.forlkc.bean.Blog;
import cn.forlkc.dao.ArticleDao;
import cn.forlkc.dao.DatabaseDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ArticleService {
    private static DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE;
    public static JSONArray dialy(String type) throws Exception {
        ArticleDao articleDao = new ArticleDao();
        DatabaseDao databaseDao = new DatabaseDao();

        JSONArray jsonArray = JSONArray.fromObject(articleDao.display(type,databaseDao));

        return jsonArray;

    }
/*
var arr = {
        "title":title,
        "description":description,
        "type":type.from,
        "img":imgUrl,
        "centent":centent
    };

 */
    public static int addBlog(JSONObject json) throws Exception {
        ArticleDao articleDao = new ArticleDao();
        DatabaseDao databaseDao = new DatabaseDao();
        Blog blog = new Blog();
        blog.setTitle(json.get("title").toString());
        blog.setDescription(json.get("description").toString());
        blog.setType(json.get("type").toString());
        blog.setImage(json.getString("img"));
        blog.setContent(json.getString("centent"));
        blog.setDate(LocalDateTime.now());
        //blog.setFormatTime(LocalDateTime.now().format(fmt));
        blog.setAuthor(json.getString("author"));
        if (articleDao.addBlog(blog,databaseDao)>0 ){
            return 1;    //成功
        }
        return -1;
    }

    public static JSONObject showBlog(int id) throws Exception {
        DatabaseDao databaseDao = new DatabaseDao();
        ArticleDao articleDao = new ArticleDao();
        JSONObject jsonObject = JSONObject.fromObject(articleDao.showBlog(id,databaseDao));
        return jsonObject;
    }
}
