package com.example.ecomm;

import com.example.ecomm.entity.User;
import com.example.ecomm.repository.UserRepository;
import com.example.ecomm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ECommApplicationTests {

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;

	@Test
	public void getUsersTest(){
		when(userRepository.findAll()).thenReturn(
				Stream.of(new User("Dharani",
						"Dharani0802", "dharani.rajasekaran@atos.net",
						"i8123483324", 1, "")).collect(Collectors.toList()));
		assertEquals(1, userService.getUsers().size());
	}

}
