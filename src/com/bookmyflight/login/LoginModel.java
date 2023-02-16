package com.bookmyflight.login;

public class LoginModel implements LoginModelCallBack{
	private LoginModelControllerCallBack loginController;
	public LoginModel(LoginModelControllerCallBack loginController) {
		this.loginController = loginController;
	}
	@Override
	public void checkUserExistInDB(String userid,String password) {
		if(userid.equals("admin") && password.equals("admin")) {
			loginController.adminLoginSuccessfull();
		}
		else if(userid.equals("user") && password.equals("password")) {
			loginController.userLoginSuccessfull();
		}
		else {
			loginController.loginFailed(userid);
		}
	}

}
