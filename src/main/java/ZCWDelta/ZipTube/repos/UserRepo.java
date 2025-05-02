package ZCWDelta.ZipTube.repos;

import ZCWDelta.ZipTube.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
