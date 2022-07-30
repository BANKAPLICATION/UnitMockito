package UnitTestingMockito.UnitTestingMockito.repositories;

import UnitTestingMockito.UnitTestingMockito.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
