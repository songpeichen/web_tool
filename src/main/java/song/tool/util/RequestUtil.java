package song.tool.util;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
@Slf4j
public class RequestUtil {

    private static final String STR_BODY = "body";


    /** 获取POST请求体参数数据*/
    public static String getPostBody(HttpServletRequest request) {
        StringBuffer stringBuffer = new StringBuffer() ;
        InputStreamReader streamReader = null;
        BufferedReader bufferedReader = null;
        InputStream inputStream = null;
        try {
            inputStream = request.getInputStream();
            streamReader = new InputStreamReader(inputStream,"UTF-8");
            bufferedReader = new BufferedReader(streamReader);
            String str = "" ;
            while((str=bufferedReader.readLine())!=null){
                stringBuffer.append(str) ;
            }
        } catch (IOException e) {
            log.error("获取输入流数据异常",e);
        }finally {
            try {
                if (inputStream != null){
                    inputStream.close();
                }
                if (streamReader != null){
                    streamReader.close();
                }
                if (bufferedReader != null){
                    bufferedReader.close();
                }
            }catch (IOException ex)
            {
                log.error("关闭输入流数据异常",ex);
            }
        }
        String result =stringBuffer.toString();
        return result;
    }


    /**
     * 取request中的已经被防止XSS，SQL注入过滤过的key value数据封装到map 返回
     */

    /**
     * 获取request中的body json 数据转化为map
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> getRequestBodyMap(ServletRequest request) {
        Map<String ,String> dataMap = new HashMap<>(16);
        // 判断是否已经将 inputStream 流中的 body 数据读出放入 attribute
        if (request.getAttribute(STR_BODY) != null) {
            // 已经读出则返回attribute中的body
            return (Map<String,String>)request.getAttribute(STR_BODY);
        } else {
            try {
                Map<String,String > maps = JSON.parseObject(request.getInputStream(),Map.class);
                dataMap.putAll(maps);
                request.setAttribute(STR_BODY,dataMap);
            }catch (IOException e) {
                e.printStackTrace();
            }
            return dataMap;
        }
    }

    /**
     * 获取request中的body json
     */
    @SuppressWarnings("unchecked")
    public static String getRequestBodyJson(ServletRequest request) {
        Map<String ,String> dataMap = new HashMap<>(16);
        String json = "";
        // 判断是否已经将 inputStream 流中的 body 数据读出放入 attribute
        if (request.getAttribute(STR_BODY) != null) {
            // 已经读出则返回attribute中的body
            return JSON.toJSONString(request.getAttribute(STR_BODY));
        } else {
            try {
                Map<String,String > maps = JSON.parseObject(request.getInputStream(),Map.class);
                json = JSON.toJSONString(maps);
                request.setAttribute(STR_BODY,json);
            }catch (IOException e) {
                e.printStackTrace();
            }
            return json;
        }
    }

}
