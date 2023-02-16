package com.bookmyflight.signup;

import com.bookmyflight.repository.UserDB;

public class SignUpModel implements SignUpModelCallBack{
	private SignUpModelControllerCallBack signUpModelController;
	private UserDB userdbInstance = UserDB.getInstance();
	public SignUpModel(SignUpController signUpController) {
		this.signUpModelController=signUpController;
	}
	@Override
	public void addUser(String name, String email, String password) {
		userdbInstance.addUserToDB(name,email,password);
		signUpModelController.userAddedSuccessfully(email);
	}

	
}
