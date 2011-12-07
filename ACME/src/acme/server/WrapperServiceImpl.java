package acme.server;

import java.util.List;

import acme.client.services.WrapperService;
import acme.server.manager.AuthorManager;
import acme.server.manager.CustomerManager;
import acme.server.manager.MasterManager;
import acme.server.manager.MaterialManager;
import acme.shared.TO.AuthorTO;
import acme.shared.TO.ClassificationTO;
import acme.shared.TO.CollectionTO;
import acme.shared.TO.CustomerTO;
import acme.shared.TO.KindMaterialTO;
import acme.shared.TO.MaterialTO;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class WrapperServiceImpl extends RemoteServiceServlet implements WrapperService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String registerCustomer(CustomerTO customerTO) 
	{
		String result = "";
		try
		{
			customerTO = CustomerManager.getInstance().saveCustomer(customerTO);
			result = "Cliente guardado con éxito\n" + customerTO.getFirstName() + " " + 
			customerTO.getLastName() + " " + "con código: " + customerTO.getIdCustomer();
		}
		catch (Exception e)
		{
			result= "Error registrando Cliente: " + e.getMessage();
		}
		return result;
		
	}

	@Override
	public String registerAuthor(AuthorTO to) {
		return AuthorManager.getInstance().saveAuthor(to);
	}

	@Override
	public List<CollectionTO> getCollections() {
		return MasterManager.getInstance().getCollections();
	}

	@Override
	public List<ClassificationTO> getClassifications() {		
		return MasterManager.getInstance().getClassification();
	}

	@Override
	public List<KindMaterialTO> getKindMaterials() {
		
		return MasterManager.getInstance().getKindMaterials();
	}

	@Override
	public List<AuthorTO> getAuthorTOs() {
		return AuthorManager.getInstance().getAuthorTOs();
	}

	@Override
	public String saveMaterial(MaterialTO materialTO) {		
		
		return MaterialManager.getInstance().saveMaterial(materialTO);
	}

	@Override
	public List<MaterialTO> getMaterials(int from, int to) {
		return MaterialManager.getInstance().getMaterials(from, to);
	}

	@Override
	public List<CustomerTO> getCustomerTOs() {
		
		return CustomerManager.getAllCustomers();
	}

}
