package song.tool.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import song.tool.pojo.Category;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Select("select * from category_ ")
    List<Category> findAll();

    List<Category> findAllByXML();
}
