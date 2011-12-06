package acme.client.activity;
import java.util.List;

import acme.client.ClientFactory;
import acme.client.place.LoanPlace;
import acme.client.place.SearchMaterialPlace;
import acme.client.services.WrapperService;
import acme.client.services.WrapperServiceAsync;
import acme.client.view.SearchMaterialView;
import acme.client.view.SearchMaterialView.Presenter;
import acme.shared.TO.MaterialTO;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class SearchMaterialActivity extends AbstractActivity implements Presenter
{
	private SearchMaterialPlace searchMaterialPlace;
	private ClientFactory clientFactory;
	private WrapperServiceAsync wrapperService = GWT.create(WrapperService.class);

	public SearchMaterialActivity (ClientFactory clientFactory, SearchMaterialPlace searchMaterialPlace )
	{
		this.clientFactory = clientFactory;
		this.searchMaterialPlace = searchMaterialPlace;
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		SearchMaterialView view = clientFactory.getSearchMaterialView();
		panel.setWidget(view);
		view.setPresenter(this);
		getMaterials(0, 15);
	}

	@Override
	public void getMaterials(int from, int to) {
		AsyncCallback<List<MaterialTO>> callback = new  AsyncCallback<List<MaterialTO>>() {
			
			@Override
			public void onSuccess(List<MaterialTO> result) {
				
				clientFactory.getSearchMaterialView().setMaterials(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}
		};		
			
		wrapperService.getMaterials(from, to, callback);		
	}

	@Override
	public void aceptSelectMaterial(List<MaterialTO> materialTOs) {
		LoanPlace place = new LoanPlace();
		place.setMaterialTOs(materialTOs);
		clientFactory.getPlaceController().goTo(place);
	}

}
