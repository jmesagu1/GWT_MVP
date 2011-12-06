package acme.client.activity;

import acme.client.ClientFactory;
import acme.client.place.LoanPlace;
import acme.client.place.RegisterAuthorPlace;
import acme.client.place.SearchMaterialPlace;
import acme.client.services.WrapperService;
import acme.client.services.WrapperServiceAsync;
import acme.client.view.LoanView;
import acme.client.view.LoanView.Presenter;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class LoanActivity extends AbstractActivity implements Presenter 
{

	private WrapperServiceAsync wrapperService = GWT.create(WrapperService.class);
	private ClientFactory clientFactory;
	private LoanPlace  loanPlace;
	
	public LoanActivity( LoanPlace  loanPlace, ClientFactory clientFactory)
	{
		this.loanPlace = loanPlace;
		this.clientFactory = clientFactory;
		 
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		LoanView view = clientFactory.getLoanView();
		view.setPresenter(this);
		panel.setWidget(view);
	}

	@Override
	public void searchMaterial() {
		SearchMaterialPlace place = new SearchMaterialPlace();
		clientFactory.getPlaceController().goTo(place);
	}

}
