package com.bookmyflight.signup;

import java.util.Scanner;

import com.bookmyflight.login.LoginView;

public class SignUpView implements SignUpViewCallBack{
	private SignUpControllerCallBack signUpController;
	private Scanner scanner = new Scanner(System.in);
	public SignUpView() {
		signUpController = new SignUpController(this);
	}
	public void signUpPage() {
		System.out.println("Welcome to sign up page");
		System.out.println("Enter the name of the User");
		String name = scanner.next();
		System.out.println("Enter your email id");
		String email = scanner.next();
		System.out.println("Enter you password");
		String password = scanner.next();
		signUpController.addUser(name,email,password);
	}
	@Override
	public void userAddedSuccessfully(String email) {
		System.out.println(email+" added successfully to the database");
		new LoginView().userInput();
	}
}
