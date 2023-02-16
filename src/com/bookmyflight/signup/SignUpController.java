package com.bookmyflight.signup;

public class SignUpController implements SignUpControllerCallBack,SignUpModelControllerCallBack{
	private SignUpViewCallBack signUpView;
	private SignUpModelCallBack signUpModel;
	public SignUpController(SignUpView signUpView) {
		this.signUpView = signUpView;
		signUpModel = new SignUpModel(this);
	}
	@Override
	public void addUser(String name, String email, String password) {
		//password encryption
		signUpModel.addUser(name,email,password);
	}
	@Override
	public void userAddedSuccessfully(String email) {
		signUpView.userAddedSuccessfully(email);
	}

}
