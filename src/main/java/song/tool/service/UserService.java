package song.tool.service;

import song.tool.pojo.User;

public interface UserService<T> {
    User queryUserByNameAndPassword(String userCode,String password);
}
