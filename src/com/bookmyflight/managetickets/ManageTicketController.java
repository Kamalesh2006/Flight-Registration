package com.bookmyflight.managetickets;

public class ManageTicketController implements ManageTicketControllerCallBack,ManageTicketModelControllerCallBack{
	private ManageTicketViewCallBack manageTicketView;
	private ManageTicketModelCallBack manageTicketModel;
	public ManageTicketController(ManageTicketViewCallBack manageTicketView) {
		this.manageTicketView =manageTicketView;
		manageTicketModel = new ManageTicketModel(this);
	}
	@Override
	public void decideOptions(int optionChosen) {
		manageTicketModel.decideOptionsInDB(optionChosen);
		
	}
	@Override
	public void chosenBookTickets() {
		manageTicketView.showAvailableFlights();
	}
	@Override
	public void chosenCancelTickets() {
		manageTicketView.cancelTickets();
	}
	@Override
	public void chosenFailed() {
		manageTicketView.chosenFailed();
	}

}
