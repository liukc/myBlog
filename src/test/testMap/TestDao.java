package testMap;

import cn.forlkc.dao.ArticleDao;
import cn.forlkc.dao.DatabaseDao;
import cn.forlkc.tools.Statistics;
import net.sf.json.JSONArray;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

public class TestDao {
    private static DatabaseDao databaseDao;
    @BeforeClass
    public static void init() throws Exception {
        databaseDao = new DatabaseDao();
    }

    @Test
    public void testPageDisplay() throws SQLException {
        ArticleDao articleDao = new ArticleDao();

        JSONArray jsonArray = JSONArray.fromObject( articleDao.pagedisplay("diary", "6", databaseDao));

        System.out.println(jsonArray);
    }

    @Test
    public void testStatistics() throws Exception {
        System.out.println(Statistics.countBlog("all"));
    }
}
