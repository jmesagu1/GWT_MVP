package acme.server.manager;

import acme.server.service.CustomerService;
import acme.shared.TO.CustomerTO;

public class CustomerManager {
	
	public CustomerTO saveCustomer(CustomerTO customerTO)	
	{
		return CustomerService.getInstance().saveCustomer(customerTO);
	}
	
	public static CustomerManager getInstance (){
		return new CustomerManager();
	}
}
