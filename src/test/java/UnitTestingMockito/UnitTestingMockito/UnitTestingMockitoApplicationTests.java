package UnitTestingMockito.UnitTestingMockito;

import UnitTestingMockito.UnitTestingMockito.models.User;
import UnitTestingMockito.UnitTestingMockito.repositories.UserRepository;
import UnitTestingMockito.UnitTestingMockito.services.UserInterface;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UnitTestingMockitoApplicationTests {

	@Autowired
	private UserInterface userInterface;

	@MockBean
	private UserRepository userRepository;

	@Test
	public void getUsersTest() {

		when(userRepository.findAll()).thenReturn(Stream.
				of(new User(2L, "test", 21)).collect(Collectors.toList()));
		Assertions.assertEquals(1, userInterface.findAll().size());

	}

	@Test
	public void saveUserTest() {
		User user = new User(3L, "test", 21);
		when(userRepository.save(user)).thenReturn(user);
		Assertions.assertEquals(user, userInterface.addUser(user));
	}

	@Test
	public void deleteUser() {
		User user = new User(1L, "test", 32);
		userInterface.deleteUser(user);
		verify(userRepository, times(1)).delete(user);
	}
	
}
