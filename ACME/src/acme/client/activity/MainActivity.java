package acme.client.activity;

import acme.client.ClientFactory;
import acme.client.place.LoanPlace;
import acme.client.place.MainPlace;
import acme.client.place.RegisterCustomerPlace;
import acme.client.place.RegisterMaterialPlace;
import acme.client.view.MainView;
import acme.client.view.MainView.Presenter;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.sun.org.apache.bcel.internal.generic.InstructionConstants.Clinit;

public class MainActivity extends AbstractActivity implements Presenter
{
	private ClientFactory clientFactory;
	private MainPlace  mainPlace;
	
	public MainActivity (ClientFactory clientFactory, MainPlace  mainPlace)
	{
		this.mainPlace = mainPlace;
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		
		MainView view = clientFactory.getMainView();
		view.setPresenter(this);
		panel.setWidget(view);
		
	}

	@Override
	public void customerAdmin() {
		RegisterCustomerPlace place = new RegisterCustomerPlace();
		clientFactory.getPlaceController().goTo(place);
	}

	@Override
	public void masters() {
		
	}

	@Override
	public void materialAdmin() {
		RegisterMaterialPlace place = new RegisterMaterialPlace();
		clientFactory.getPlaceController().goTo(place);
	}

	@Override
	public void loanMaterial() {
		LoanPlace place = new LoanPlace();
		clientFactory.getPlaceController().goTo(place);
	}
}
