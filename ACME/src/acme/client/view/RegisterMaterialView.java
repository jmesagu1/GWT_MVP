package acme.client.view;

import java.util.List;
import java.util.Set;

import acme.shared.TO.AuthorTO;
import acme.shared.TO.ClassificationTO;
import acme.shared.TO.CollectionTO;
import acme.shared.TO.KindMaterialTO;
import acme.shared.TO.MaterialTO;

import com.google.gwt.user.client.ui.IsWidget;


public interface RegisterMaterialView  extends IsWidget{
	
	
	void setPresenter (Presenter presenter);
	void loadCollection (List <CollectionTO> collectionTOs);
	void loadClassification(List <ClassificationTO> classificationTOs);
	void loadKindMaterial(List <KindMaterialTO> kindMaterialTOs);
	void displayAuthors(Set <AuthorTO> authors);
	void clearInputs();
	
	public interface Presenter
	{
		void saveMaterial(MaterialTO materialTO) throws Exception;
		void selectAuthor();
	}

}
