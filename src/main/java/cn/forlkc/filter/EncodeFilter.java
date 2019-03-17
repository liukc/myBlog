package cn.forlkc.filter;

import javax.servlet.DispatcherType;
import java.io.IOException;

@javax.servlet.annotation.WebFilter(filterName = "EncodeFilter",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD,
        DispatcherType.INCLUDE,DispatcherType.ERROR},urlPatterns = {"/*"})
public class EncodeFilter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        chain.doFilter(req, resp);
    }

    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {

    }

}
