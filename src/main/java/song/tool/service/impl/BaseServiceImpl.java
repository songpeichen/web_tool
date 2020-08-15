package song.tool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import song.tool.service.BaseService;

public class BaseServiceImpl<T> implements BaseService {
    @Autowired
    T baseMapper;
}
