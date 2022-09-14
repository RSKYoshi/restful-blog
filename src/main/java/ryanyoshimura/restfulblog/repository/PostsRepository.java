package ryanyoshimura.restfulblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ryanyoshimura.restfulblog.data.Post;

public interface PostsRepository extends JpaRepository<Post, Long> {

}
