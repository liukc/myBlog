package cn.forlkc.bean;

/**
 * userInformation: 用户信息id
 * name：用户昵称
 * hobby ： 爱好
 * sex ： 用户性别
 * signature ： 签名
 * userid : 外码，作为和user表连接的桥梁
 * icon : 头像
 */
public class UserInformation {
    private String userInformationid;
    private String name;
    private String hobby;
    private String sex;
    private String signature;
    private String userid;
    private String icon;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getUserInformationid() {
        return userInformationid;
    }

    public void setUserInformationid(String userInformationid) {
        this.userInformationid = userInformationid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
