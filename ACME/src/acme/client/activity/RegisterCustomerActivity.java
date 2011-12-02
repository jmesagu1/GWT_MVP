package acme.client.activity;

import acme.client.ClientFactory;
import acme.client.place.MainPlace;
import acme.client.place.RegisterCustomerPlace;
import acme.client.services.WrapperService;
import acme.client.services.WrapperServiceAsync;
import acme.client.view.GenericAlertView;
import acme.client.view.RegisterCustomerView;
import acme.client.view.RegisterCustomerView.Presenter;
import acme.client.view.impl.GenericAlertViewtImpl;
import acme.shared.TO.CustomerTO;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class RegisterCustomerActivity extends AbstractActivity implements Presenter{

	private RegisterCustomerPlace registerCustomerPlace;
	private ClientFactory clientFactory;
	private WrapperServiceAsync wrapperService = GWT.create(WrapperService.class);
	
	public RegisterCustomerActivity (RegisterCustomerPlace registerCustomerPlace, ClientFactory clientFactory)
	{
		this.registerCustomerPlace = registerCustomerPlace;
		this.clientFactory = clientFactory;
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		RegisterCustomerView view = clientFactory.getRegisterCustomerView();
		view.setPresenter(this);
		panel.setWidget(view);		
	}

	@Override
	public void save(final CustomerTO customerTO) {
		
		 AsyncCallback <String> callback = new AsyncCallback <String>() {

			@Override
			public void onFailure(Throwable caught) {
				
				clientFactory.getRegisterCustomerView().customerNoSaved("No fue posible guardar el cliente: " + caught.getMessage());
			}

			@Override
			public void onSuccess(String result) {				
				
				clientFactory.getRegisterCustomerView().customerSaved(result);
				//GenericAlertView generic = clientFactory.getGenericAlertView();
				//generic.setMessaje(result);
				//generic.show();
			}
		     
		    };
		    
		    wrapperService.registerCustomer(customerTO, callback);
	}

	@Override
	public void registerCompleted() {
		MainPlace place =  new MainPlace();
		clientFactory.getPlaceController().goTo(place);
	}

}
