package song.tool.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import song.tool.dao.CategoryDAO;
import song.tool.mapper.CategoryMapper;
import song.tool.pojo.Category;
import song.tool.pojo.User;
import song.tool.service.UserService;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("/login")
    public Object login(User user) {
        User user1 = userService.queryUserByNameAndPassword(user.getUserCode(),user.getPassword());
        return user1;
    }

}
