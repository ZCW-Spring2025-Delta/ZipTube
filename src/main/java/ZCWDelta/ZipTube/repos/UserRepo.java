package ZCWDelta.ZipTube.repos;

import ZCWDelta.ZipTube.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);  // 🔐 used in authentication
    boolean existsByUsername(String username);       // for registration

}
