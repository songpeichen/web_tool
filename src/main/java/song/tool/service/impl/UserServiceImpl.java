package song.tool.service.impl;

import org.springframework.stereotype.Service;
import song.tool.mapper.UserMapper;
import song.tool.pojo.User;
import song.tool.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper> implements UserService<UserMapper> {


    @Override
    public User queryUserByNameAndPassword(String userCode, String password) {
        return baseMapper.queryUserByNameAndPassword(userCode, password);
    }
}
