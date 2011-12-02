package acme.client.view;

import com.google.gwt.user.client.ui.IsWidget;

public interface MainView extends IsWidget {
	
	public void setPresenter (Presenter presenter);
	
	public interface Presenter {
		
		public void customerAdmin();
		public void masters();
		public void materialAdmin();
	}

}
