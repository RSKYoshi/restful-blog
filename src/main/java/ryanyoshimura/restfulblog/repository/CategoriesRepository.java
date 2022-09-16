package ryanyoshimura.restfulblog.repository;

import ryanyoshimura.restfulblog.data.Category;
import ryanyoshimura.restfulblog.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}

