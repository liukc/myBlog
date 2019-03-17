package cn.forlkc.dao;

import cn.forlkc.bean.User;

import java.sql.SQLException;

public class RegisterDao {
    public boolean hasUser(User user,DatabaseDao databaseDao) throws SQLException {
        String sql = "select * from user where userid = '" + user.getUserid() + "'";
        databaseDao.query(sql);
        while(databaseDao.next()){
            return true;
        }
        return false;
    }

    public Integer register(User user, DatabaseDao databaseDao) throws SQLException {
        String sql="insert into user(userid,password,email,code) values('"+
                user.getUserid()+"','"+user.getPassword()+"','"+
                user.getEmail()+"','"+user.getCode()+"')";
        return databaseDao.update(sql);
    }

    public boolean hasCode(String code, DatabaseDao databaseDao) throws SQLException {
        String sql = "select * from user where code='"+code+"'";
        databaseDao.query(sql);
        while (databaseDao.next()) {
            String enable=databaseDao.getString("enable");
            if("use".equals(enable))
                enable="stop";
            else
                enable="use";
            sql = "update user set enable='"+enable+"' where code = '"+code+"'";
            databaseDao.update(sql);
            return true;
        }
        return false;
    }
}
