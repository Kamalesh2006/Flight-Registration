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
		switch(optionChosen) {
		case 1:
			manageTicketView.callBackToBookTicket();
			break;
		case 2:
			manageTicketView.cancelTickets();
		case 3: 
			manageTicketView.showAvailableFlights();
		case 4:
			manageTicketView.exit();
		}
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
