package acme.client.view.impl;

import java.util.ArrayList;
import java.util.List;
import acme.client.view.LoanView;
import acme.shared.TO.CustomerTO;
import acme.shared.TO.MaterialTO;
import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;

public class LoanViewImpl extends Composite implements LoanView {

	private static LoanViewImplUiBinder uiBinder = GWT
			.create(LoanViewImplUiBinder.class);
	@UiField Button butSearchMaterial;
	@UiField(provided=true) CellTable<MaterialTO> dataMaterial = new CellTable<MaterialTO>();
	@UiField(provided=true) CellTable<CustomerTO> dataCustomer = new CellTable<CustomerTO>();
	@UiField Button butSearchCustomer;
	@UiField Button butRegisterLoan;
	

	private Presenter presenter;
	
	public LoanViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		initDataCustomer();
		initDataMaterial();
	}

	public LoanViewImpl(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		
	}
	
	interface LoanViewImplUiBinder extends UiBinder<Widget, LoanViewImpl> {
	}
	
	public void initDataMaterial()
	{
		dataMaterial.addColumn(new TextColumn<MaterialTO>()
				{

					@Override
					public String getValue(MaterialTO object) {						
						return object.getCode();
					}
					
				}, "Codigo");
		
		dataMaterial.addColumn(new TextColumn<MaterialTO>()
				{

					@Override
					public String getValue(MaterialTO object) {						
						return object.getName();
					}
					
				}, "Nombre Libro");
		
		dataMaterial.addColumn(new TextColumn<MaterialTO>()
				{

					@Override
					public String getValue(MaterialTO object) {						
						return object.getEdition();
					}
					
				}, "Edicion");		
		
		 ActionCell<MaterialTO> cell = new ActionCell<MaterialTO>("Quitar",
				new ActionCell.Delegate<MaterialTO>() 
				{
			      @Override
			      public void execute(MaterialTO contact) 
			      {
			    	  presenter.removeMaterial(contact);
			      }
				});
		
		Column<MaterialTO, MaterialTO> column = new Column<MaterialTO, MaterialTO>(cell) 
				{
		      	@Override
		      	public MaterialTO getValue(MaterialTO object) {
		      		return object;
		      	}
			};
		
		
		dataMaterial.addColumn(column, "Action");
		
	}
	
	public void initDataCustomer ()
	{
		dataCustomer.addColumn(new TextColumn<CustomerTO>() 
				{
		
					@Override
					public String getValue(CustomerTO object) {
						
						return object.getIdCustomer().toString();
					}
				}, 
		"Codigo");
	    
	    dataCustomer.addColumn(new TextColumn<CustomerTO>() 
				{
		
					@Override
					public String getValue(CustomerTO object) {
						
						return object.getDni().toString();
					}
				}, 
		"Documento");
	    
	    
	    dataCustomer.addColumn(new TextColumn<CustomerTO>() 
				{
		
					@Override
					public String getValue(CustomerTO object) {
						
						return object.getFirstName();
					}
				}, 
		"Nombre");
	    
	    dataCustomer.addColumn(new TextColumn<CustomerTO>() 
				{
		
					@Override
					public String getValue(CustomerTO object) {
						
						return object.getLastName();
					}
				}, 
		"Apellido");
	    
	    
	    ActionCell<CustomerTO> cell = new ActionCell<CustomerTO>("Quitar",
				new ActionCell.Delegate<CustomerTO>() 
				{
			      @Override
			      public void execute(CustomerTO contact) 
			      {
			    	  presenter.removeCustomer();
			      }
				});
		
		Column<CustomerTO, CustomerTO> column = new Column<CustomerTO, CustomerTO>(cell) 
				{
		      	@Override
		      	public CustomerTO getValue(CustomerTO object) {
		      		return object;
		      	}
			};		
		
			dataCustomer.addColumn(column, "Action");
	}
	
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}	
	@UiHandler("butSearchMaterial")
	void onButSearchMaterialClick(ClickEvent event) {
		presenter.searchMaterial();
	}
	@UiHandler("butSearchCustomer")
	void onButSearchCustomerClick(ClickEvent event) {
		presenter.searchCustomer();
	}

	@Override
	public void loadMaterials(List<MaterialTO> materialTOs) {
		dataMaterial.setRowData(materialTOs);
		dataMaterial.redraw();
	}

	@Override
	public void loadCustomer(CustomerTO customerTO) {
		ArrayList<CustomerTO> list = new ArrayList<CustomerTO>();
		list.add(customerTO);
		dataCustomer.setRowData(list);
		dataCustomer.redraw();
	}
	@UiHandler("butRegisterLoan")
	void onButRegisterLoanClick(ClickEvent event) {
		
		Window.alert("Developing function");
	}
}
