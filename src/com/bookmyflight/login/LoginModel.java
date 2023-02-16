package com.bookmyflight.login;

import com.bookmyflight.repository.UserDB;

public class LoginModel implements LoginModelCallBack{
	private LoginModelControllerCallBack loginController;
	private UserDB userDbInstance = UserDB.getInstance();
	public LoginModel(LoginModelControllerCallBack loginController) {
		this.loginController = loginController;
	}
	@Override
	public void checkUserExistInDB(String userid,String password) {
		if(userid.equals("admin") && password.equals("admin")) {
			loginController.adminLoginSuccessfull();
		}
		else if(userDbInstance.userIdExistInDB(userid)) {
			loginController.userLoginSuccessfull();
		}
		else {
			loginController.loginFailed(userid);
		}
	}

}
