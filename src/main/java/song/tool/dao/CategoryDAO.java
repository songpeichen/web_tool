package song.tool.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import song.tool.pojo.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer> {
}
