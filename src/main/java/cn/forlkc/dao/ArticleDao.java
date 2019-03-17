package cn.forlkc.dao;

import cn.forlkc.bean.Blog;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ArticleDao {
    public Blog searchBlog(String keyword){
        Blog blog = new Blog();
        return  blog;
    }

    public Blog showBlog(int id, DatabaseDao databaseDao) throws SQLException {
        DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE;
        String sql = "select * from blog where blogid = '"+id +"'";
        databaseDao.query(sql);
        Blog blog = new Blog();
        while (databaseDao.next()){
            blog.setAuthor(databaseDao.getString("author"));
            blog.setDescription(databaseDao.getString("description"));
            blog.setFormatTime(databaseDao.getLocalDateTime("date").format(fmt));
            blog.setTitle(databaseDao.getString("title"));
            blog.setContent(databaseDao.getString("content"));
        }
        return blog;
    }

    public int addBlog(Blog blog, DatabaseDao databaseDao) throws SQLException {
        String sql="insert into blog(title,description,type,content,date,image,author) values('"+
                blog.getTitle()+"','"+blog.getDescription()+"','"+
                blog.getType()+"','"+blog.getContent()+"','"+
                blog.getDate()+"','"+blog.getImage()+"','"+
                blog.getAuthor()+ "')";
        return databaseDao.update(sql);
    }

    public List<Blog> display(String type, DatabaseDao databaseDao) throws SQLException {
        String sql = new String();
        if(type.equals("all"))
            sql = "select * from blog ORDER BY blogid DESC";
        else
            sql = "select * from blog where type = '"+type+"' ORDER BY blogid DESC";
        databaseDao.query(sql);
        List<Blog> blogs = new ArrayList<>();

        DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE;
        while (databaseDao.next()){
            Blog blog = new Blog();
            blog.setAuthor(databaseDao.getString("author"));
            blog.setBlogid(databaseDao.getInt("blogid"));
            blog.setDate(databaseDao.getLocalDateTime("date"));
            blog.setFormatTime(databaseDao.getLocalDateTime("date").format(fmt));
            blog.setDescription(databaseDao.getString("description"));
            blog.setImage(databaseDao.getString("image"));
            blog.setTitle(databaseDao.getString("title"));
            blog.setType(databaseDao.getString("type"));
            blogs.add(blog);
        }
        /*
        while (databaseDao.next()) {
            blog.setAuthor(databaseDao.getString("author"));
            blog.setBlogid(databaseDao.getInt("blogid"));
            blog.setDate(databaseDao.getLocalDateTime("date"));
            blog.setDescription(databaseDao.getString("description"));
            blog.setImage(databaseDao.getString("image"));
            blog.setTitle(databaseDao.getString("title"));
            blog.setType(databaseDao.getString("type"));
            blogs.add(blog);
        }
        */
        return blogs;
    }
}
