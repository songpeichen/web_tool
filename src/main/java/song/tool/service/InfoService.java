package song.tool.service;

import com.github.pagehelper.PageInfo;
import song.tool.pojo.Info;
import song.tool.pojo.User;
import song.tool.util.PageUtil;
import song.tool.vo.InfoVO;

public interface InfoService<T> {
    Info addInfo(Info info);

    PageInfo queryInfo(InfoVO infoVO);

    Integer unUseInfo(InfoVO infoVO);
}
