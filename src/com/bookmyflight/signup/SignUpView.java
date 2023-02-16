package com.bookmyflight.signup;

import java.util.Scanner;

import com.bookmyflight.login.LoginView;

public class SignUpView implements SignUpViewCallBack{
	private SignUpControllerCallBack signUpController;
	private LoginView login;
	private Scanner scanner = new Scanner(System.in);
	public SignUpView() {
		this.login = new LoginView();
		signUpController = new SignUpController(this);
	}
	public SignUpView(LoginView loginView) {
		this.login = loginView;
		signUpController = new SignUpController(this);
	}
	public void signUpPage() {
		System.out.println("Welcome to sign up page");
		System.out.println("Enter the name of the User");
		String name = scanner.next();
		System.out.println("Enter your email id");
		String email = scanner.next();
		System.out.println("Enter your password");
		String password = scanner.next();
		System.out.println("ReEnter your password");
		String rePassword = scanner.next();
		signUpController.addUser(name,email,password,rePassword);
	}
	@Override
	public void userAddedSuccessfully(String email) {
		System.out.println(email+" added successfully to the database");
		this.login.userInput();
	}
	@Override
	public void userAdditionFailed(String error) {
		System.out.println(error);
		signUpPage();
	}
}
