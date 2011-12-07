package acme.client.activity;

import java.util.List;

import sun.net.www.content.text.plain;
import acme.client.ClientFactory;
import acme.client.place.LoanPlace;
import acme.client.place.SearchCustomerPlace;
import acme.client.place.SearchMaterialPlace;
import acme.client.services.WrapperService;
import acme.client.services.WrapperServiceAsync;
import acme.client.view.LoanView;
import acme.client.view.LoanView.Presenter;
import acme.client.view.SearchCustomerView;
import acme.shared.TO.CustomerTO;
import acme.shared.TO.MaterialTO;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class LoanActivity extends AbstractActivity implements Presenter 
{

	private WrapperServiceAsync wrapperService = GWT.create(WrapperService.class);
	private ClientFactory clientFactory;
	private LoanPlace  loanPlace;
	private List<MaterialTO> materialTOs;
	private CustomerTO customerTO;
	
	public LoanActivity( LoanPlace  loanPlace, ClientFactory clientFactory)
	{
		this.loanPlace = loanPlace;
		this.clientFactory = clientFactory;
		materialTOs = loanPlace.getMaterialTOs();
		customerTO = loanPlace.getCustomerTO();
		 
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		LoanView view = clientFactory.getLoanView();
		view.loadMaterials(materialTOs);		
		view.loadCustomer(customerTO);
		view.setPresenter(this);
		panel.setWidget(view);
	}

	@Override
	public void searchMaterial() {
		SearchMaterialPlace place = new SearchMaterialPlace();
		place.setLoanPlace(loanPlace);
		clientFactory.getPlaceController().goTo(place);
	}

	@Override
	public void removeMaterial(MaterialTO materialTO) {
		materialTOs.remove(materialTO);		
		LoanView view = clientFactory.getLoanView();
		view.loadMaterials(materialTOs);
	}

	@Override
	public void searchCustomer() {
		SearchCustomerPlace place = new SearchCustomerPlace();
		place.setLoanPlace(loanPlace);
		clientFactory.getPlaceController().goTo(place);
	}

	@Override
	public void removeCustomer() {
		customerTO = null;
		loanPlace.setCustomerTO(customerTO);
		clientFactory.getLoanView().loadCustomer(customerTO);
	}

}
