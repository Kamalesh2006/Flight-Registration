package com.bookmyflight.booktickets;

public class BookTicketsModel implements BookTicketsModelCallBack{
	private BookTicketsModelControllerCallBack bookTicketsModelControllerCallBack;
	public BookTicketsModel(BookTicketsController bookTicketsController) {
		this.bookTicketsModelControllerCallBack = bookTicketsController;
	}

}
