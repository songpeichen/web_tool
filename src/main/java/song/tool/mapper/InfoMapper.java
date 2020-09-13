package song.tool.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import song.tool.pojo.Info;
import song.tool.pojo.User;
import song.tool.vo.InfoVO;

import java.util.List;

@Mapper
public interface InfoMapper {
    Long addInfo(@Param("info")Info info);

    List<Info> queryInfoByVo(@Param("infoVO") InfoVO infoVO);

    Integer unUseInfo(@Param("id")Long id);
}
