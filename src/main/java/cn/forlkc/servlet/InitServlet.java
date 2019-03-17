package cn.forlkc.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;


import cn.forlkc.tools.WebProperties;
import cn.forlkc.dao.DatabaseDao;

import java.io.IOException;


public class InitServlet extends HttpServlet {
    public void init(ServletConfig conf) throws ServletException {
        super.init(conf);
        //初始化数据库参数
        DatabaseDao.drv = this.getServletContext().getInitParameter("drv");
        DatabaseDao.url = this.getServletContext().getInitParameter("url");
        DatabaseDao.usr = this.getServletContext().getInitParameter("usr");
        DatabaseDao.pwd = this.getServletContext().getInitParameter("pwd");

        ServletContext servletContext=conf.getServletContext();
        tools.FileTool.root=servletContext.getRealPath("\\");

        //读取属性文件
        String fileDir=servletContext.getRealPath("\\WEB-INF\\web.properties");
        Parameters params = new Parameters();
        FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                        .configure(params.properties().setFileName(fileDir));
        try
        {

            WebProperties.config = builder.getConfiguration();
            WebProperties.config.addProperty("projectRoot",
                    servletContext.getRealPath(WebProperties.config.getString("projectName")));



        }catch(ConfigurationException cex){
            cex.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
