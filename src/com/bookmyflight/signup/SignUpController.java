package com.bookmyflight.signup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpController implements SignUpControllerCallBack,SignUpModelControllerCallBack{
	private SignUpViewCallBack signUpView;
	private SignUpModelCallBack signUpModel;
	public SignUpController(SignUpView signUpView) {
		this.signUpView = signUpView;
		signUpModel = new SignUpModel(this);
	}
	@Override
	public void addUser(String name, String email, String password,String rePassword) {
		Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9]*@[a-zA-Z0-9]+[.][com]");
		Matcher m = p.matcher(email);
		if(m.find()) {
			if(password.equals(rePassword))
				signUpModel.addUser(name,email,password);
			else
				signUpView.userAdditionFailed("Enter the password Correctly");			
		}else {
			signUpView.userAdditionFailed("Enter the valid email id");
		}
	}
	@Override
	public void userAddedSuccessfully(String email) {
		signUpView.userAddedSuccessfully(email);
	}

}
