package ryanyoshimura.restfulblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ryanyoshimura.restfulblog.data.Category;

public interface CategoriesRepository extends JpaRepository<Category, Long> {

    Category findByName(String categoryName);
}
