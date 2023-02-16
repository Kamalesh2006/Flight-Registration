package com.bookmyflight.managetickets;

public class ManageTicketModel implements ManageTicketModelCallBack{
	private ManageTicketModelControllerCallBack manageTicketModelController;
	public ManageTicketModel(ManageTicketModelControllerCallBack manageTicketController) {
		this.manageTicketModelController = manageTicketController;
	}
	

}
