package com.bookmyflight.login;

public class LoginController implements LoginControllerCallBack,LoginModelControllerCallBack {
	private LoginViewCallBack loginView;
	private LoginModelCallBack loginModel;
	LoginController(LoginViewCallBack loginView){
		this.loginView= loginView; 
		loginModel = new LoginModel(this);
	}
	@Override
	public void checkUserExist(String userid,String password) {
		loginModel.checkUserExistInDB(userid,password);
	}
	@Override
	public void adminLoginSuccessfull() {
		loginView.adminLoginSuccessfull();
	}
	@Override
	public void userLoginSuccessfull() {
		loginView.userLoginSuccessfull();
	}
	@Override
	public void loginFailed(String userid) {
		loginView.loginFailed(userid);
	}
	@Override
	public void passwordMismatch(String userid) {
		loginView.loginAgain(userid);
	}
}
