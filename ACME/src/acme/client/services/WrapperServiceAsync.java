package acme.client.services;

import java.util.List;

import acme.shared.TO.AuthorTO;
import acme.shared.TO.ClassificationTO;
import acme.shared.TO.CollectionTO;
import acme.shared.TO.CustomerTO;
import acme.shared.TO.KindMaterialTO;
import acme.shared.TO.MaterialTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface WrapperServiceAsync {

	void registerCustomer(CustomerTO to, AsyncCallback<String> callback);

	void registerAuthor(AuthorTO to, AsyncCallback<String> callback);

	void getCollections(AsyncCallback<List<CollectionTO>> callback);

	void getClassifications(AsyncCallback<List<ClassificationTO>> callback);

	void getKindMaterials(AsyncCallback<List<KindMaterialTO>> callback);

	void getAuthorTOs(AsyncCallback<List<AuthorTO>> callback);

	void saveMaterial(MaterialTO materialTO, AsyncCallback<String> callback);

	void getMaterials(int from, int to, AsyncCallback<List<MaterialTO>> callback);

}
