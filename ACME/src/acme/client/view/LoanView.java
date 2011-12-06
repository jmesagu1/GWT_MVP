package acme.client.view;

import java.util.List;

import acme.shared.TO.CustomerTO;
import acme.shared.TO.MaterialTO;

import com.google.gwt.user.client.ui.IsWidget;

public interface LoanView extends IsWidget {
	
	void setPresenter(Presenter presenter);
	void loadMaterials(List<MaterialTO> materialTOs);
	void loadCustomer (CustomerTO customerTO);	
	
	public interface Presenter
	{
		void searchMaterial ();
		void removeMaterial(MaterialTO material);		
	}

}
