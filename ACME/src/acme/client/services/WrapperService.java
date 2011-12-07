package acme.client.services;

import java.util.List;

import acme.shared.TO.AuthorTO;
import acme.shared.TO.ClassificationTO;
import acme.shared.TO.CollectionTO;
import acme.shared.TO.CustomerTO;
import acme.shared.TO.KindMaterialTO;
import acme.shared.TO.MaterialTO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("WrapperService")
public interface WrapperService extends RemoteService 
{
	public String registerCustomer(CustomerTO to);
	public String registerAuthor (AuthorTO to);
	public List <CollectionTO> getCollections();
	public List <ClassificationTO> getClassifications();
	public List<KindMaterialTO> getKindMaterials();	
	public List <AuthorTO> getAuthorTOs();
	public String saveMaterial (MaterialTO materialTO);
	public List<MaterialTO> getMaterials (int from, int to);			
	public List <CustomerTO> getCustomerTOs();
	
}
