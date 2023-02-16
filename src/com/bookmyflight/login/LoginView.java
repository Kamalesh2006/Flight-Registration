package com.bookmyflight.login;

import java.util.Scanner;

public class LoginView implements LoginViewCallBack{
	private LoginControllerCallBack loginController;
	private Scanner scanner = new Scanner(System.in);
	public LoginView() {
		loginController = new LoginController(this);
	}
	public void checkUser() {
		System.out.println("Enter the User ID");
		String userid=scanner.next();
		System.out.println("Enter the password:");
		String password = scanner.next();
		loginController.checkUserExist(userid,password);
	}
	@Override
	public void adminLoginSuccessfull() {
		//admin specific calls (add flights delete flights)
		System.out.println("Admin login successfull");
	}
	@Override
	public void userLoginSuccessfull() {
		// user can book and manage tickets
		System.out.println("User login successfull");
	}
	@Override
	public void loginFailed(String userid) {
		// user login failed
		System.out.println("User login failed");
	}
}
