package acme.client;

import acme.client.view.GenericAlertView;
import acme.client.view.MainView;
import acme.client.view.RegisterAuthorView;
import acme.client.view.RegisterCustomerView;
import acme.client.view.RegisterMaterialView;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;

public interface ClientFactory {
	
	 EventBus getEventBus();
	 PlaceController getPlaceController();
	 
	 RegisterCustomerView getRegisterCustomerView();
	 RegisterAuthorView getRegisterAuthorView();
	 MainView getMainView();
	 GenericAlertView getGenericAlertView();
	 RegisterMaterialView getRegisterMaterialView();
	 

}
