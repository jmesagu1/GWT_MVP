package acme.server.manager;

import java.util.List;

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
	
	public static List <CustomerTO> getAllCustomers ()
	{
		return CustomerService.getInstance().getAllCustomers();
	}
}
