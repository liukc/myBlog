package cn.forlkc.service;

import cn.forlkc.bean.User;
import cn.forlkc.dao.DatabaseDao;
import cn.forlkc.dao.RegisterDao;
import cn.forlkc.tools.CodeUtil;

import java.sql.SQLException;

public class RegisterService {
    public Integer register(User user){//注册用户

        try {
            DatabaseDao databaseDao=new DatabaseDao();
            RegisterDao registerDao = new RegisterDao();
            if(registerDao.hasUser(user, databaseDao)){
                return 0;//失败，用户已存在
            }else {//没有同名用户，可以注册
                user.setCode(CodeUtil.generateUniqueCode());
                //调用userinformation建立默认信息

                if (registerDao.register(user, databaseDao)>0 ){
                    UserInformationService.setUsername(user);
                    new Thread(new tools.MailUtil(user.getEmail(), user.getCode())).start();
                    return 1;    //成功
                }
                else
                    return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;//数据库操作失败
        } catch (Exception e) {
            e.printStackTrace();
            return -2;//其他异常
        }
    }
    public int codeExist(String code){
        RegisterDao registerDao = new RegisterDao();
        try{
            DatabaseDao databaseDao=new DatabaseDao();

            if(registerDao.hasCode(code,databaseDao)){
                return  1;
            }
        }catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

}
