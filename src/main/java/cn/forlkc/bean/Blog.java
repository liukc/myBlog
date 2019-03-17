package cn.forlkc.bean;
/**
 * blogid:博客id
 * title ： 标题
 * description：博客简介
 * type：博客类型
 * content：内容
 * date：发表日期
 * image：配图
 * author：作者
 */

import java.time.LocalDateTime;

public class Blog {
    private int blogid;
    private String title;
    private String description;
    private String type;
    private String content;
    private LocalDateTime date;
    private String image;
    private String author;

    public String getFormatTime() {
        return formatTime;
    }

    public void setFormatTime(String formatTime) {
        this.formatTime = formatTime;
    }

    private String formatTime;


    public int getBlogid() {
        return blogid;
    }

    public void setBlogid(int blogid) {
        this.blogid = blogid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String toString(){
        return "BlogBean [blogid="+blogid+", title="+title+", description="+description+", type="
                +type+", content="+content+", time="+formatTime+", image="+image+", author="+author+"]";
    }
}
