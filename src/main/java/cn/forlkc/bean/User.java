package cn.forlkc.bean;

/***
 * userid : 用户账号（唯一性）
 * password：用户密码
 * email：用户邮箱，用于验证
 * code：用户随机码，用于激活账号
 * type：用户类型，普通用户管理员
 * enable：账号是否停用（stop or use）
 */



public class User {
    private String userid;
    private String password;
    private String email;
    private String code;
    private String type;
    private String enable;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }
}
