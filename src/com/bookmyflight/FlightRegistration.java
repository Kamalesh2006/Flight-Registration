package com.bookmyflight;
import java.util.Scanner;

import com.bookmyflight.login.LoginView;
import com.bookmyflight.signup.SignUpView;

public class FlightRegistration {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Book My Flight");
		System.out.println("Press 1 to login");
		System.out.println("Press 2 to signup");
		int option = scanner.nextInt();
		switch(option) {
		case 1:
			new LoginView().userInput();
			break;
		case 2:
			new SignUpView().signUpPage();
			break;
		}
	}

}
