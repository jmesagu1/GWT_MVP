package acme.client.view;

import java.util.List;

import acme.shared.TO.MaterialTO;

import com.google.gwt.user.client.ui.IsWidget;

public interface SearchMaterialView  extends IsWidget{
	
	void setPresenter(Presenter presenter);
	void setMaterials(List<MaterialTO> materialTOs);
	
	public interface Presenter {
		
		 void getMaterials(int from, int to);
	}

}
