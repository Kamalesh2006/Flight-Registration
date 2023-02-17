package com.bookmyflight.login;

public interface LoginViewCallBack {

	void adminLoginSuccessfull();

	void userLoginSuccessfull();

	void loginFailed(String userid);

	void loginAgain(String userid);

}
