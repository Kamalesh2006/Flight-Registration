package com.bookmyflight.booktickets;

public class BookTicketsController implements BookTicketsControllerCallBack,BookTicketsModelControllerCallBack{
	private BookTicketsViewCallBack bookTicketsView;
	private BookTicketsModelCallBack bookTicketsModel;
	public BookTicketsController(BookTicketsView bookTicketsView) {
		this.bookTicketsView=bookTicketsView;
		bookTicketsModel=new BookTicketsModel(this);
	}

}
