package acme.client.activity;

import java.util.List;

import acme.client.ClientFactory;
import acme.client.place.MainPlace;
import acme.client.place.RegisterAuthorPlace;
import acme.client.place.RegisterMaterialPlace;
import acme.client.services.WrapperService;
import acme.client.services.WrapperServiceAsync;
import acme.client.view.RegisterMaterialView;
import acme.client.view.RegisterMaterialView.Presenter;
import acme.shared.TO.ClassificationTO;
import acme.shared.TO.CollectionTO;
import acme.shared.TO.KindMaterialTO;
import acme.shared.TO.MaterialTO;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class RegisterMaterialActivity  extends AbstractActivity implements Presenter 
{

	private WrapperServiceAsync wrapperService = GWT.create(WrapperService.class);
	private ClientFactory clientFactory;
	private RegisterMaterialPlace registerMaterialPlace;	
	
	
	public RegisterMaterialActivity (ClientFactory clientFactory, RegisterMaterialPlace registerMaterialPlace)
	{
		this.clientFactory = clientFactory;
		this.registerMaterialPlace = registerMaterialPlace;
	}
	
	@Override
	public void start(final AcceptsOneWidget panel, EventBus eventBus)
	{		
		RegisterMaterialView view = clientFactory.getRegisterMaterialView();
		loadCollection();
		loadClassification();
		loadKindMaterial();
		view.setPresenter(this);
		if (registerMaterialPlace.getAuthors().size() > 0)
		{
			view.displayAuthors(registerMaterialPlace.getAuthors());
		}
		panel.setWidget(view);	
	}
	
	public void loadKindMaterial ()
	{
		AsyncCallback <List<KindMaterialTO>> callback = new AsyncCallback<List<KindMaterialTO>>() {
			
			@Override
			public void onSuccess(List<KindMaterialTO> result) {
				clientFactory.getRegisterMaterialView().loadKindMaterial(result);
			}			
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Error: loadKindMaterial "  + caught.getMessage());				
			}
		}; 	
		
		wrapperService.getKindMaterials(callback);
	}
	
	public void loadClassification ()
	{
		AsyncCallback <List<ClassificationTO>> callback = new AsyncCallback<List<ClassificationTO>>() {
			
			@Override
			public void onSuccess(List<ClassificationTO> result) {
				clientFactory.getRegisterMaterialView().loadClassification(result);
			}			
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Error: Classification "  + caught.getMessage());				
			}
		}; 	
		
		wrapperService.getClassifications(callback);
	}
	
	public void loadCollection()
	{		
		AsyncCallback <List<CollectionTO>> callback = new AsyncCallback<List<CollectionTO>>() {
			
			@Override
			public void onSuccess(List<CollectionTO> result) {
				clientFactory.getRegisterMaterialView().loadCollection(result);
			}			
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Error: Collections "  + caught.getMessage());				
			}
		}; 	
		
		wrapperService.getCollections(callback);
	}

	@Override
	public void selectAuthor() {
		RegisterAuthorPlace place = new RegisterAuthorPlace();
		place.setFromPlace(RegisterAuthorActivity.MATERIAL_PLACE);
		clientFactory.getPlaceController().goTo(place);
	}

	@Override
	public void saveMaterial(MaterialTO materialTO) throws Exception {
	
		AsyncCallback<String > callback = new AsyncCallback<String>() {
			
			@Override
			public void onSuccess(String result) {
				Window.alert(result);				
				clientFactory.getRegisterMaterialView().clearInputs();
				MainPlace place = new MainPlace();
				clientFactory.getPlaceController().goTo(place);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}
		};
		
		if (registerMaterialPlace.getAuthors().size() > 0)
		{
			materialTO.setAuthors(registerMaterialPlace.getAuthors());
			wrapperService.saveMaterial(materialTO, callback);
		}
		else
		{
			throw new Exception("Debe seleccionar por lo menos un Autor");
		}
	}	
}
