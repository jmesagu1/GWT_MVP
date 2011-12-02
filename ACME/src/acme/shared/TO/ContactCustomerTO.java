package acme.shared.TO;

import java.io.Serializable;


public class ContactCustomerTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long idCustomer;
	private String firstName;
	private String lastName;
	private String phone;
	private Boolean validated;
	public long getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(long idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Boolean getValidated() {
		return validated;
	}
	public void setValidated(Boolean validated) {
		this.validated = validated;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
