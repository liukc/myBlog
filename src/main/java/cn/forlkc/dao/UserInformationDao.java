package cn.forlkc.dao;

import cn.forlkc.bean.UserInformation;

import java.sql.SQLException;

public class UserInformationDao {

    public UserInformation getInformationByid(String id, DatabaseDao databaseDao) throws SQLException {
        UserInformation userInformation = new UserInformation();
        String sql = "select * from userInformation where userid = '" + id + "'";
        databaseDao.query(sql);
        while (databaseDao.next()){
            userInformation.setHobby(databaseDao.getString("hobby"));
            userInformation.setName(databaseDao.getString("name"));
            userInformation.setSex(databaseDao.getString("sex"));
            userInformation.setSignature(databaseDao.getString("signature"));
            userInformation.setIcon(databaseDao.getString("icon"));
        }
        return userInformation;
    }

    public void setUserName(String id, DatabaseDao databaseDao) throws SQLException {
        String sql="insert into userinformation (userid, name) values ('" + id +"','" + id +"')";
        databaseDao.update(sql);
    }
}
