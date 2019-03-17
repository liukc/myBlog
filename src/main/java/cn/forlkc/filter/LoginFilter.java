package cn.forlkc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD,DispatcherType.INCLUDE
},urlPatterns = {"/blog/html/addBlog.html"})
public class LoginFilter implements Filter {
    private FilterConfig config = null;
    private String webRoot = null;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse)resp;
        HttpSession session = request.getSession();
        Cookie[]cookies = ((HttpServletRequest) req).getCookies();
        if(cookies != null) {
            for(Cookie c : cookies){
                if (c.getName().equals("userName")){
                    chain.doFilter(req, resp);
                }
            }
        }else {
            response.sendRedirect("/blog/html/login.html");
        }
    }

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
        ServletContext context = config.getServletContext();
    }

}
