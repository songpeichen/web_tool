package song.tool.config.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    }
    @Bean
    AdminLoginInterceptor adminLoginInterceptor(){
        return new AdminLoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        由于拦截器配置早于bean实例化  new出的拦截器里依赖的的bean都无为null 调用adminLoginInterceptor方法先初始化bean
        registry.addInterceptor(adminLoginInterceptor()).addPathPatterns("/**");
    }

}
