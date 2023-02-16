package com.bookmyflight.booktickets;

import java.util.Scanner;

public class BookTicketsView implements BookTicketsViewCallBack{
	private Scanner scanner = new Scanner(System.in);
	private BookTicketsControllerCallBack bookTicketsController;
	public BookTicketsView() {
		bookTicketsController = new BookTicketsController(this);
	}
}
