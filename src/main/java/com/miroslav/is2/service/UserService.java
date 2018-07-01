package com.miroslav.is2.service;

import com.miroslav.is2.model.User;

public interface UserService {

	User findUserByEmail(String email);

    User saveUser(User user);

    User setAsAdmin(User user);
	
}
