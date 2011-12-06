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
	

	private Presenter presenter;
	
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
		
	}

	public LoanViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		initDataCustomer();
		initDataMaterial();
	}

	public LoanViewImpl(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		
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
}
