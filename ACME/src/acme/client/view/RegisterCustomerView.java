package acme.client.view;

import acme.shared.TO.CustomerTO;

import com.google.gwt.user.client.ui.IsWidget;

public interface RegisterCustomerView extends IsWidget {
	
	public void setPresenter(Presenter presenter);
	public void customerSaved(String messaje);
	public void customerNoSaved(String messaje);
	
	
	public interface Presenter
	{
		public void save(CustomerTO customerTO);
		public void registerCompleted();
	}

}
