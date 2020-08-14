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

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryDAO categoryDAO;

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("/listCategory")
    public Object listCategory(Model m) {
        List<Category> cs = categoryDAO.findAll();
        return cs;
    }

    @RequestMapping("/listCategoryByMapper")
    public Object listCategoryByMapper(Model m) {
        List<Category> cs = categoryMapper.findAll();
        return cs;
    }

    @RequestMapping("/listCategoryByMapperXML")
    public Object listCategoryByMapperXML(Model m) {
        PageHelper.startPage(2, 4);
        List<Category> cs = categoryMapper.findAllByXML();
        PageInfo<Category> pageInfo = new PageInfo(cs);
        pageInfo.getList();
        return pageInfo.getList();
    }

    @RequestMapping("/redisTest")
    public Object redisTest(Model m) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("1", "aaaaa");
        return null;
    }
}
