package song.tool.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

//全局异常操作  把异常栈信息输出
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public void defaultErrorHandler(HttpServletRequest request, Exception e, HttpServletResponse response) throws Exception {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        e.printStackTrace(pw);
        pw.flush();
        sw.flush();
        System.out.println(request.getParameterMap());
        System.out.println(request.getCharacterEncoding());
        System.err.println("捕获异常：" + request.getRequestURL() + "\n" + sw.toString());
//        response.setHeader("contentType", "text/html; charset=utf-8");

        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        response.getOutputStream().write(("捕获异常：          " + request.getRequestURL() + "        \n" + sw.toString()).getBytes());
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }
}