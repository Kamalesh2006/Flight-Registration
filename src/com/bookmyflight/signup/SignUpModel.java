package com.bookmyflight.signup;

import com.bookmyflight.repository.FlightDB;

public class SignUpModel implements SignUpModelCallBack{
	private SignUpModelControllerCallBack signUpModelController;
	private FlightDB userdbInstance = FlightDB.getInstance();
	public SignUpModel(SignUpController signUpController) {
		this.signUpModelController=signUpController;
	}
	@Override
	public void addUser(String name, String email, String password) {
		userdbInstance.addUserToDB(name,email,password);
		signUpModelController.userAddedSuccessfully(email);
	}

	
}
