package acme.client.view;

import java.util.List;
import acme.shared.TO.CustomerTO;
import com.google.gwt.user.client.ui.IsWidget;

public interface SearchCustomerView extends IsWidget 
{
	void setPresenter(Presenter presenter);
	void setCustomers(List<CustomerTO> customerTOs);
	
	public interface Presenter {
		
		 void aceptSelectCustomer(CustomerTO customerTO);
	}
}
