package song.tool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import song.tool.pojo.User;
import song.tool.service.UserService;
import song.tool.vo.ResponseVO;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("/login")
    public Object login(User user) {
        User user1 = userService.queryUserByNameAndPassword(user.getUserCode(),user.getPassword());
        String token = UUID.randomUUID().toString();
        user1.setToken(token+"_"+user1.getUserCode());
        redisTemplate.opsForValue().set(token+"_"+user1.getUserCode(),user1,30, TimeUnit.MINUTES);
        return ResponseVO.instance(true,user1);
    }

}
