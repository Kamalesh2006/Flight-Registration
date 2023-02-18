package com.bookmyflight.admin;

import com.bookmyflight.dto.Flight;

public interface AdminModelControllerCallBack {

	void flightAddedSuccess(Flight flight);

	void flightRemovedSuccessfully(Flight f);

}
