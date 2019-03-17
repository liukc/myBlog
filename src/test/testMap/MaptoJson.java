package testMap;

import cn.forlkc.bean.Blog;
import cn.forlkc.bean.User;
import net.sf.json.JSONArray;
import org.junit.Test;

import javax.ejb.Local;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaptoJson {
    @Test
    public void testMap(){
        Map map = new HashMap();
        Map map1 = new HashMap();
        for(int i = 0; i<2; i++){
            map.clear();
            for(int j = 0; j<2; j++){
                map.put("a" + j,j);
            }
            map1.put("b"+i,map);
        }
        System.out.println(map1);
    }
    @Test
    public void testTostring(){
        User user = new User();
        user.setCode("123");
        user.setUserid("1");
        user.setPassword("13521");
        user.setEmail("231");
        user.setEnable("12352");
        user.setType("as");

        System.out.println(user.toString());
    }


    @Test
    public void tostr(){
        Blog blog = new Blog();
        blog.setType("45");
        DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE;
        blog.setFormatTime(LocalDateTime.now().format(fmt));
        List<Blog> list = new ArrayList<>();
        list.add(blog);
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println(list);
        System.out.println(jsonArray.toString());
        System.out.println(blog);
    }
}
