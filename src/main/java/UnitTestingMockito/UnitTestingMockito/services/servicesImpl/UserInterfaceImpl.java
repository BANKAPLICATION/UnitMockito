package UnitTestingMockito.UnitTestingMockito.services.servicesImpl;

import UnitTestingMockito.UnitTestingMockito.models.User;
import UnitTestingMockito.UnitTestingMockito.repositories.UserRepository;
import UnitTestingMockito.UnitTestingMockito.services.UserInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserInterfaceImpl implements UserInterface {
    private final UserRepository userRepository;

    @Override
    public void deleteUser(User user) {
         userRepository.delete(user);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
