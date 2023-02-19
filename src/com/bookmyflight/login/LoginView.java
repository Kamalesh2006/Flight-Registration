package com.bookmyflight.login;

import java.util.Scanner;

import com.bookmyflight.admin.AdminView;
import com.bookmyflight.managetickets.ManageTicketView;
import com.bookmyflight.signup.SignUpView;

public class LoginView implements LoginViewCallBack{
	private LoginControllerCallBack loginController;
	private Scanner scanner = new Scanner(System.in);
	public LoginView() {
		loginController = new LoginController(this);
	}
	public void userInput() {
		System.out.println("Enter the User ID (Email ID):");
		String userid=scanner.next();
		System.out.println("Enter the password:");
		String password = scanner.next();
		loginController.checkUserExist(userid,password);
	}
	@Override
	public void adminLoginSuccessfull() {
		//admin specific calls (add flights delete flights)
		System.out.println("Admin login successfull");
		AdminView admin = new AdminView();
		admin.adminAccess(this);;
	}
	@Override
	public void userLoginSuccessfull() {
		// user can book and manage tickets
		System.out.println("User login successfull");
		ManageTicketView manageTicket = new ManageTicketView();
		manageTicket.bookTickets();
	}
	@Override
	public void loginFailed(String userid) {
		// user login failed
		System.out.println(userid+" doesn't exist. User login failed");
		System.out.println("Please sign up first");
		SignUpView signUp = new SignUpView(this);
		signUp.signUpPage();
	}
	@Override
	public void loginAgain(String userid) {
		System.out.println("Password is wrong");
		userInput();
	}
	@Override
	public void wrongInput(String error) {
		System.err.println(error);
		userInput();
	}
}
