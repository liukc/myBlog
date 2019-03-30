package cn.forlkc.tools;


import cn.forlkc.dao.DatabaseDao;

//统计类
public class Statistics {
    private static DatabaseDao databaseDao;
    private static String sql;

    public static int countBlog(String type) throws Exception {
        databaseDao = new DatabaseDao();
        if ("all".equals(type))
            sql = "select count(blogid) as count from blog";
        else
            sql = "select count(blogid) as count from blog where type = '" + type + "'";
        int count = databaseDao.getCount(sql);
        return count;
    }

}
