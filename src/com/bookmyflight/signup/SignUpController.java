package com.bookmyflight.signup;

public class SignUpController implements SignUpControllerCallBack,SignUpModelControllerCallBack{
	private SignUpViewCallBack signUpView;
	private SignUpModelCallBack signUpModel;
	public SignUpController(SignUpView signUpView) {
		this.signUpView = signUpView;
		signUpModel = new SignUpModel(this);
	}
	@Override
	public void addUser(String name, String email, String password,String rePassword) {
		if(password.equals(rePassword))
			signUpModel.addUser(name,email,password);
		else
			signUpView.userAdditionFailed("Enter the password Correctly");
	}
	@Override
	public void userAddedSuccessfully(String email) {
		signUpView.userAddedSuccessfully(email);
	}

}
