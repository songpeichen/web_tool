package song.tool.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import song.tool.pojo.Info;
import song.tool.pojo.User;
import song.tool.service.InfoService;
import song.tool.util.PageUtil;
import song.tool.vo.InfoVO;
import song.tool.vo.ResponseVO;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/info")
public class InfoController {
    @Autowired
    InfoService infoService;

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("/addInfo")
    public Object addInfo(Info info, HttpServletRequest request) {
//        RequestUtil.getPostBody(request);
        User user = (User) request.getAttribute("User");
        info.setCreateUserCode(user.getUserCode());
        info.setCreateDate(new Date());
        Info info1 = infoService.addInfo(info);
        return ResponseVO.instance(true,info1);
    }

    @RequestMapping("/queryInfo")
    public Object queryInfo(InfoVO infoVO, HttpServletRequest request) {
//        RequestUtil.getPostBody(request);
        User user = (User) request.getAttribute("User");
        PageInfo pageInfo = infoService.queryInfo(infoVO);
        PageUtil pageUtil =new PageUtil(pageInfo.getList(),pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal());
        return ResponseVO.instance(true,pageUtil);
    }

}
