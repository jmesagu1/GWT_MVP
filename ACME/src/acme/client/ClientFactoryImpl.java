package acme.client;

import acme.client.view.GenericAlertView;
import acme.client.view.LoanView;
import acme.client.view.MainView;
import acme.client.view.RegisterAuthorView;
import acme.client.view.RegisterCustomerView;
import acme.client.view.RegisterMaterialView;
import acme.client.view.SearchCustomerView;
import acme.client.view.SearchMaterialView;
import acme.client.view.impl.CustomerRegisterImpl;
import acme.client.view.impl.GenericAlertViewtImpl;
import acme.client.view.impl.LoanViewImpl;
import acme.client.view.impl.MainViewImpl;
import acme.client.view.impl.RegisterAuthorViewImpl;
import acme.client.view.impl.RegisterMaterialViewImpl;
import acme.client.view.impl.SearchCustomerViewImpl;
import acme.client.view.impl.SearchMaterialViewImpl;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

public class ClientFactoryImpl implements ClientFactory 
{
	
	private EventBus eventBus = new SimpleEventBus();
	private PlaceController controller = new PlaceController(eventBus);
	private RegisterCustomerView registerCustomerView;
	private RegisterAuthorView registerAuthorView;
	private MainView mainView;
	private GenericAlertView genericAlertView;
	private RegisterMaterialView registerMaterialView;
	private SearchMaterialView searchMaterialView;
	private LoanView loanView;
	private SearchCustomerView searchCustomerView;

	@Override
	public EventBus getEventBus() {
		
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {		
		return controller;
	}

	@Override
	public RegisterCustomerView getRegisterCustomerView() 
	{
		if (registerCustomerView == null)
		{
			registerCustomerView = new CustomerRegisterImpl();
		}
		return registerCustomerView;
	}

	@Override
	public RegisterAuthorView getRegisterAuthorView() {
		if (registerAuthorView == null)
		{
			registerAuthorView = new RegisterAuthorViewImpl();
		}
		return registerAuthorView;
	}

	@Override
	public MainView getMainView() {
		
		if (mainView == null)
		{
			mainView = new MainViewImpl();
		}
		return mainView;
	}

	@Override
	public GenericAlertView getGenericAlertView() {
		if (genericAlertView == null)
		{
			genericAlertView = new GenericAlertViewtImpl();
		}
		return genericAlertView;
	}

	@Override
	public RegisterMaterialView getRegisterMaterialView() {
		if (registerMaterialView == null)
		{
			registerMaterialView = new RegisterMaterialViewImpl();
		}
		return registerMaterialView;
	}

	@Override
	public SearchMaterialView getSearchMaterialView() {
		
		if (searchMaterialView == null)
		{
			searchMaterialView = new SearchMaterialViewImpl();
		}
		return searchMaterialView;
	}

	@Override
	public LoanView getLoanView() {
		if (loanView == null)
		{
			loanView = new LoanViewImpl();
		}
		return loanView;
	}

	@Override
	public SearchCustomerView getSearchCustomerView() {
		if (searchCustomerView == null)
		{
			searchCustomerView = new SearchCustomerViewImpl();
		}
		return searchCustomerView;
	}

}
