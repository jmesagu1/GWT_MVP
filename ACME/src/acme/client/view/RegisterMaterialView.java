package acme.client.view;

import java.util.List;

import acme.shared.TO.ClassificationTO;
import acme.shared.TO.CollectionTO;
import acme.shared.TO.KindMaterialTO;

import com.google.gwt.user.client.ui.IsWidget;


public interface RegisterMaterialView  extends IsWidget{
	
	
	void setPresenter (Presenter presenter);
	void loadCollection (List <CollectionTO> collectionTOs);
	void loadClassification(List <ClassificationTO> classificationTOs);
	void loadKindMaterial(List <KindMaterialTO> kindMaterialTOs);
	
	public interface Presenter
	{
		void saveMaterial();
		void selectAuthor();
	}

}
