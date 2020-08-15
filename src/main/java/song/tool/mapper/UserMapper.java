package song.tool.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import song.tool.pojo.Category;
import song.tool.pojo.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user ")
    List<User> findAll();

    User queryUserByNameAndPassword(@Param("userCode")String userCode,@Param("password")String password);
}
