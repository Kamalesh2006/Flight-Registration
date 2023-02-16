package com.bookmyflight.managetickets;

public class ManageTicketModel implements ManageTicketModelCallBack{
	private ManageTicketModelControllerCallBack manageTicketModelController;
	public ManageTicketModel(ManageTicketModelControllerCallBack manageTicketController) {
		this.manageTicketModelController = manageTicketController;
	}
	@Override
	public void decideOptionsInDB(int optionChosen) {
		if(optionChosen==1) {
			manageTicketModelController.chosenBookTickets();
		}
		else if(optionChosen==2) {
			manageTicketModelController.chosenCancelTickets();
		}
		else {
			manageTicketModelController.chosenFailed();
		}
		
	}

}
