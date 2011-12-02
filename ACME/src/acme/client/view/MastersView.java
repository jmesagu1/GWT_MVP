package acme.client.view;

import com.google.gwt.user.client.ui.IsWidget;

public interface MastersView extends IsWidget {
	
	void setPresenter(Presenter presenter);	
	
	public interface Presenter
	{
		void saveClassification();
		void saveCollection();
		void savekindMaterial();
		//void save
	}

}
