package com.bookmyflight.login;

import com.bookmyflight.dto.User;
import com.bookmyflight.repository.FlightDB;

public class LoginModel implements LoginModelCallBack{
	private LoginModelControllerCallBack loginController;
	private FlightDB userDbInstance = FlightDB.getInstance();
	public LoginModel(LoginModelControllerCallBack loginController) {
		this.loginController = loginController;
	}
	@Override
	public void checkUserExistInDB(String userid,String password) {
		if(userid.equals("admin") && password.equals("admin")) {
			loginController.adminLoginSuccessfull();
		}
		
		User user = userDbInstance.getUser(userid);
		
		if(user==null) {
			loginController.loginFailed(userid);
		}
		else if(user.getPassword().equals(password)) {
			loginController.userLoginSuccessfull();
		}
		else {
			loginController.passwordMismatch(userid);
		}
	}

}
