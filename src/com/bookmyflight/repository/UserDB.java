package com.bookmyflight.repository;

import java.util.ArrayList;
import java.util.List;

import com.bookmyflight.dto.User;

public class UserDB {
	private List<User> userDB=new ArrayList<>();
	private static UserDB userInstance;
	private UserDB() {
		
	}
	public static UserDB getInstance() {
		if(userInstance == null) {
			userInstance = new UserDB();
		}
		return userInstance;
	}
	public void addUserToDB(String name, String email, String password) {
		User user = new User(email);
		user.setName(name);
		user.setPassword(password);
		userDB.add(user);
	}
	public boolean userIdExistInDB(String userID) {
		for(int i =0;i<userDB.size();i++) {
			if(userDB.get(i).getEmail().equals(userID)) {
				return true;
			}
		}
		return false;
	}
}
