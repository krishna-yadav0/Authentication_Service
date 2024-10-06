package com.example.Authentication.ServiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${user.service.url}")
	private String userServiceUrl;

	public String loginUser(String username, String password) {
		User user = restTemplate.getForObject(userServiceUrl + "/" + username, User.class);
//        String string = restTemplate.postForObject(userServiceUrl + "/register", user, String.class);
//        User user1 = restTemplate.getForObject("http://localhost:8081/api/users/" + username, User.class);

		if (user != null && user.getPassword().equals(password)) {
			return "Login successful!";
		} else {
			return "Invalid username or password!";
		}
	}
}
