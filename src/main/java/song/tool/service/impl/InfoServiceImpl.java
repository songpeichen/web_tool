package song.tool.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import song.tool.mapper.InfoMapper;
import song.tool.pojo.Category;
import song.tool.pojo.Info;
import song.tool.service.InfoService;
import song.tool.util.PageUtil;
import song.tool.vo.InfoVO;

import java.util.List;

@Service
public class InfoServiceImpl extends BaseServiceImpl<InfoMapper> implements InfoService<InfoMapper> {


    @Override
    public Info addInfo(Info info) {
        Long a = baseMapper.addInfo(info);
        return info;
    }

    @Override
    public PageInfo queryInfo(InfoVO infoVO) {
        PageHelper.startPage(infoVO.getPageNum(), infoVO.getPageSize());
        List<Info> list =baseMapper.queryInfoByVo(infoVO);
        PageInfo<Info> pageInfo = new PageInfo(list);
        pageInfo.getList();
        return pageInfo;
    }
}
