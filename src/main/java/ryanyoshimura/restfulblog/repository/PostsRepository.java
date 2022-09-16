package ryanyoshimura.restfulblog.repository;

import ryanyoshimura.restfulblog.data.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Post, Long> {

}

