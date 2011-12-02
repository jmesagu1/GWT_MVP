package acme.client.view.impl;

import java.util.Date;

import acme.client.view.RegisterCustomerView;
import acme.shared.TO.ContactCustomerTO;
import acme.shared.TO.CustomerTO;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class CustomerRegisterImpl extends Composite implements RegisterCustomerView {

	private static CustomerRegisterUiBinder uiBinder = GWT
			.create(CustomerRegisterUiBinder.class);
	@UiField TextBox txtName;
	@UiField TextBox txtLastname;
	@UiField TextBox txtDNI;
	@UiField TextBox txtAddress;
	@UiField TextBox txtPhone;
	@UiField TextBox txtMail;
	@UiField Button butSave;
	@UiField DateField birthDate;
	@UiField TextBox txtCFirstName;
	@UiField TextBox txtCLastName;
	@UiField TextBox txtCPhone;
	
	private Presenter presenter;
	

	interface CustomerRegisterUiBinder extends
			UiBinder<Widget, CustomerRegisterImpl> {
	}
	
	public void clearTxts()
	{
		txtAddress.setText("");
		txtCFirstName.setText("");
		txtCLastName.setText("");
		txtCPhone.setText("");
		txtDNI.setText("");
		txtLastname.setText("");
		txtMail.setText("");
		txtName.setText("");
		txtPhone.setText("");
		birthDate.setValue(null);
	}

	public CustomerRegisterImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public CustomerRegisterImpl(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("butSave")
	void onButSaveClick(ClickEvent event) {
		
		if (validateData())
		{
			CustomerTO to  = new CustomerTO();
			to.setFirstName(txtName.getText());
			to.setAddress(txtAddress.getText());
			to.setBirthday(birthDate.getValue());		
			to.setDni(Long.parseLong(txtDNI.getText()));
			to.setLastName(txtLastname.getText());
			to.setRegisterDate(new Date());
			to.setPhone(txtPhone.getText());
			to.setMail(txtMail.getText());
			to.setContactCustomerTO(getContactCustomerTO());
			presenter.save(to);		
		}
	}
	
	public ContactCustomerTO getContactCustomerTO()
	{
		ContactCustomerTO contactCustomerTO = new ContactCustomerTO();
		contactCustomerTO.setFirstName(txtCFirstName.getText());
		contactCustomerTO.setLastName(txtCLastName.getText());
		contactCustomerTO.setPhone(txtCPhone.getText());
		return contactCustomerTO;
	}
	
	
	public boolean validateData()
	{
		boolean validate = false;		
		try 
		{
			try 
			{
				Long.parseLong(txtDNI.getText());
				validate = true;
			}
			catch (Exception e) 
			{
				throw new Exception("El documento digitado es invalido");
			}
		
		}
		catch (Exception e) 
		{			
			Window.alert(e.getMessage());
		}
		return validate;
	}

	@Override
	public void setPresenter(Presenter presenter) {		
		this.presenter  = presenter;
	}	

	@Override
	public void customerSaved(String messaje) {
		Window.alert(messaje);
		clearTxts();
		presenter.registerCompleted();
	}

	@Override
	public void customerNoSaved(String messaje) {
		Window.alert(messaje);
	}	
}
