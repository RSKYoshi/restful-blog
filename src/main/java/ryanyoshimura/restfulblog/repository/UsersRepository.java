package ryanyoshimura.restfulblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ryanyoshimura.restfulblog.data.User;

public interface UsersRepository extends JpaRepository<User, Long> {

}
