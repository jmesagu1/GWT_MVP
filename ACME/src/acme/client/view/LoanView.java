package acme.client.view;

import com.google.gwt.user.client.ui.IsWidget;

public interface LoanView extends IsWidget {
	
	void setPresenter(Presenter presenter);
	
	public interface Presenter
	{
		void searchMaterial ();
	}

}
