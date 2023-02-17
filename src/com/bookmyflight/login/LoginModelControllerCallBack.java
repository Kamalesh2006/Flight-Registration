package com.bookmyflight.login;

public interface LoginModelControllerCallBack {

	void adminLoginSuccessfull();

	void userLoginSuccessfull();

	void loginFailed(String userid);

	void passwordMismatch(String userid);

}
