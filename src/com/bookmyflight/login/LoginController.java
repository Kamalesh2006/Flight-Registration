package com.bookmyflight.login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginController implements LoginControllerCallBack,LoginModelControllerCallBack {
	private LoginViewCallBack loginView;
	private LoginModelCallBack loginModel;
	LoginController(LoginViewCallBack loginView){
		this.loginView= loginView; 
		loginModel = new LoginModel(this);
	}
	@Override
	public void checkUserExist(String userid,String password) {
		Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9]*@[a-zA-Z0-9]+[.][com]");
		Matcher m = p.matcher(userid);
		if(m.find()) {
			loginModel.checkUserExistInDB(userid,password);			
		}else {
			loginView.wrongInput("Pls enter valid email id");
		}
		
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
