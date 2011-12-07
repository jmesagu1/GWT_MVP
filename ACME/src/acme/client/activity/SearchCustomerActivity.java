package acme.client.activity;

import java.util.List;

import acme.client.ClientFactory;
import acme.client.place.LoanPlace;
import acme.client.place.SearchCustomerPlace;
import acme.client.services.WrapperService;
import acme.client.services.WrapperServiceAsync;
import acme.client.view.SearchCustomerView;
import acme.client.view.SearchCustomerView.Presenter;
import acme.shared.TO.CustomerTO;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class SearchCustomerActivity extends AbstractActivity implements Presenter{

	private ClientFactory clientFactory;
	private SearchCustomerPlace searchCustomerPlace;
	private WrapperServiceAsync wrapperService = GWT.create(WrapperService.class);
	
	public SearchCustomerActivity ( ClientFactory clientFactory , SearchCustomerPlace searchCustomerPlace)
	{
		this.clientFactory = clientFactory;
		this.searchCustomerPlace = searchCustomerPlace;
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		SearchCustomerView view = clientFactory.getSearchCustomerView();
		view.setPresenter(this);
		loadCustomers();
		panel.setWidget(view);	
	}
	
	public void loadCustomers ()
	{		
		AsyncCallback<List <CustomerTO>> callback = new AsyncCallback<List<CustomerTO>>() {
			
			@Override
			public void onSuccess(List<CustomerTO> result) {
				 clientFactory.getSearchCustomerView().setCustomers(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Error recuperando Usuarios: " + caught.getMessage());
			}
		};
		
		wrapperService.getCustomerTOs(callback);
	}

	@Override
	public void aceptSelectCustomer(CustomerTO customerTO) {
		LoanPlace place = searchCustomerPlace.getLoanPlace();
		place.setCustomerTO(customerTO);
		clientFactory.getPlaceController().goTo(place);
	}

}
