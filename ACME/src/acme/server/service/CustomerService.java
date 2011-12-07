package acme.server.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import acme.server.entity.ContactCustomer;
import acme.server.entity.Customer;
import acme.shared.TO.ContactCustomerTO;
import acme.shared.TO.CustomerTO;

public class CustomerService 
{	
	
	public CustomerTO saveCustomer (CustomerTO customerTO)
	{
		Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		Customer customer = getCustomerAsEntity(customerTO);
		session.persist(customer);	
		session.persist(customer.getContactCustomer());	
		session.getTransaction().commit();	
		customerTO.setIdCustomer(customer.getIdCustomer());
		return customerTO;
	}
	
	public List <CustomerTO> getAllCustomers()
	{
		List<CustomerTO> customerTOs = new ArrayList<CustomerTO>();
		Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		List<Customer> list = session.createQuery("from Customer").list();
		for (Customer c : list)
		{
			CustomerTO customerTO = new CustomerTO();
			customerTO.setAddress(c.getAddress());
			customerTO.setBirthday(c.getBirthday());
			customerTO.setDni(c.getDni());
			customerTO.setFirstName(c.getFirstName());
			customerTO.setIdCustomer(c.getIdCustomer());
			customerTO.setLastName(c.getLastName());
			customerTOs.add(customerTO);
		}
		return customerTOs;
	}
	
	public Customer getCustomerAsEntity (CustomerTO customerTO)
	{
		Customer customer = new Customer();
		customer.setAddress(customerTO.getAddress());
		customer.setBirthday(customerTO.getBirthday());
		customer.setDni(customerTO.getDni());
		customer.setFirstName(customerTO.getFirstName());
		customer.setLastName(customerTO.getLastName());
		customer.setMail(customerTO.getMail());
		customer.setPhone(customerTO.getPhone());
		customer.setRegisterDate(customerTO.getRegisterDate());
		customer.setContactCustomer(getContactCustomerAsEntity(customerTO.getContactCustomer()));
		customer.getContactCustomer().setCustomer(customer);
		return customer;
	}
	
	public ContactCustomer getContactCustomerAsEntity (ContactCustomerTO contactCustomerTO)
	{
		ContactCustomer contactCustomer = new ContactCustomer();
		contactCustomer.setFirstName(contactCustomerTO.getFirstName());
		contactCustomer.setLastName(contactCustomerTO.getLastName());
		contactCustomer.setPhone(contactCustomerTO.getPhone());
		return contactCustomer;
	}
	
	public static CustomerService getInstance ()
	{
		return new CustomerService();
	}
}
