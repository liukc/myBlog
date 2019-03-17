package cn.forlkc.service;

import cn.forlkc.bean.User;
import cn.forlkc.bean.UserInformation;
import cn.forlkc.dao.DatabaseDao;
import cn.forlkc.dao.UserInformationDao;

public class UserInformationService {

    public static UserInformation getInformationByid(String id) throws Exception {
        DatabaseDao databaseDao = new DatabaseDao();
        UserInformationDao userInformationDao = new UserInformationDao();

        return userInformationDao.getInformationByid(id, databaseDao);
    }
    public static void setUsername(User user) throws Exception {
        DatabaseDao databaseDao = new DatabaseDao();
        UserInformationDao userInformationDao = new UserInformationDao();
        userInformationDao.setUserName(user.getUserid(),databaseDao);
    }
}
