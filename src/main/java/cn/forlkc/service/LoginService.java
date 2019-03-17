package cn.forlkc.service;

import cn.forlkc.bean.User;
import cn.forlkc.dao.DatabaseDao;
import cn.forlkc.dao.LoginDao;

public class LoginService {
    /*
    return: 0:账号停用；-1：账号不存在；
     */
    public int loginCheck(User user) throws Exception {
        DatabaseDao databaseDao = new DatabaseDao();
        LoginDao loginDao = new LoginDao();
        int result = loginDao.checkUser(user, databaseDao);
        return result;
    }
}
