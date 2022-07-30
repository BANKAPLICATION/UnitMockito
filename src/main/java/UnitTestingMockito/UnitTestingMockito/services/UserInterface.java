package UnitTestingMockito.UnitTestingMockito.services;

import UnitTestingMockito.UnitTestingMockito.models.User;

import java.util.List;

public interface UserInterface {
    void deleteUser(User user);
    User addUser(User user);
    User getUser(Long id);
    List<User> findAll();
}
