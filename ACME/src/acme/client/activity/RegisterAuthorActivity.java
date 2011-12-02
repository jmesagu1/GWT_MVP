package acme.client.activity;

import java.util.List;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import acme.client.ClientFactory;
import acme.client.place.RegisterAuthorPlace;
import acme.client.services.WrapperService;
import acme.client.services.WrapperServiceAsync;
import acme.client.view.GenericAlertView;
import acme.client.view.RegisterAuthorView;
import acme.client.view.RegisterAuthorView.Presenter;
import acme.shared.TO.AuthorTO;

public class RegisterAuthorActivity extends AbstractActivity implements Presenter 
{

	public static final String MASTER_PLACE = "master";
	public static final String MATERIAL_PLACE = "material";
	
	private WrapperServiceAsync wrapperService = GWT.create(WrapperService.class);
	private ClientFactory clientFactory;
	private RegisterAuthorPlace  registerAuthorPlace;	
	
	public RegisterAuthorActivity (RegisterAuthorPlace registerAuthorPlace, ClientFactory clientFactory)
	{
		this.clientFactory = clientFactory;
		this.registerAuthorPlace = registerAuthorPlace;
	}
	
	@Override
	public void save(AuthorTO authorTO) 
	{
		AsyncCallback <String> callback = new AsyncCallback <String>() {

				@Override
				public void onFailure(Throwable caught) {
					Window.alert(caught.getMessage());
				}
	
				@Override
				public void onSuccess(String result) {			
					clientFactory.getRegisterAuthorView().clearTxtboxes();
					GenericAlertView generic = clientFactory.getGenericAlertView();
					generic.setMessaje(result);
					generic.show();
					loadAuthors ();
				}
		     
		    };
		    
		    wrapperService.registerAuthor(authorTO,callback);
	}	
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		
		RegisterAuthorView view = clientFactory.getRegisterAuthorView();
		view.setPresenter(this);
		if (registerAuthorPlace.getFromPlace().equals(MASTER_PLACE))
		{
			view.disableSelection();
		}
		else if (registerAuthorPlace.getFromPlace().equals(MATERIAL_PLACE))
		{
			view.enableSelection();
		}
		loadAuthors ();
		panel.setWidget(view);	
	}
	
	public void loadAuthors ()
	{
		AsyncCallback <List<AuthorTO>> callback = new AsyncCallback <List<AuthorTO>>() 
		{

			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}

			@Override
			public void onSuccess(List<AuthorTO> result) {
				clientFactory.getRegisterAuthorView().loadAuthors(result);				
			}		
		};
		wrapperService.getAuthorTOs(callback);
	}

}
