package song.tool.config.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import song.tool.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AdminLoginInterceptor implements HandlerInterceptor {
    @Autowired
    RedisTemplate redisTemplate;

    //    在请求处理之前调用,只有返回true才会执行请求
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String servletPath = null;
        try {
            //获取请求路径
            servletPath = httpServletRequest.getServletPath();
            if ("/login".equals(servletPath)) {
                return true;
            }
            //校验登录信息
            String token = httpServletRequest.getHeader("token");
            if(token==null){
                token=httpServletRequest.getParameter("token");
            }
            if(token==null){
                return false;
            }
            User user = (User) redisTemplate.opsForValue().get(token);
            if (user != null) {
                httpServletRequest.setAttribute("User", user);
                redisTemplate.expire(token, 30, TimeUnit.MINUTES);
                return true;
            } else {
                httpServletResponse.getOutputStream().write("timeOutReLogin".getBytes());
                return false;
            }
        } catch (IOException e) {
            System.err.println(servletPath);
            e.printStackTrace();
            e.printStackTrace(httpServletResponse.getWriter());
        }
        return false;
    }

    //    试图渲染之后执行
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    //    在请求处理之后,视图渲染之前执行
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}