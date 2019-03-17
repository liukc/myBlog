package cn.forlkc.dao;

import cn.forlkc.bean.User;
import cn.forlkc.tools.Encript;

import java.sql.SQLException;
/*
return: 0:账号停用；-1：账号不存在；
 */
public class LoginDao {
    public int checkUser(User user, DatabaseDao databaseDao) throws SQLException {
        String sql = "select * from user where userid = '" + user.getUserid() + "'";
        databaseDao.query(sql);
        while (databaseDao.next()) {
            String enable = databaseDao.getString("enable");
            if (("use").equals(enable)) {
                if (!Encript.authenticatePassword(databaseDao.getString("password"), user.getPassword()))
                    break;
                return 1;
            } else {
                return 0;//账号停用
            }
        }
        return -1;//账号不存在
    }
}

