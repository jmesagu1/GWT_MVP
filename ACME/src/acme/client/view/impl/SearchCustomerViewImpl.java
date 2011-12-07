package acme.client.view.impl;

import java.util.List;

import acme.client.view.SearchCustomerView;
import acme.shared.TO.CustomerTO;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.event.dom.client.ClickEvent;

public class SearchCustomerViewImpl extends Composite implements SearchCustomerView {

	private static SearchCustomerViewImplUiBinder uiBinder = GWT
			.create(SearchCustomerViewImplUiBinder.class);
	@UiField(provided=true) CellTable<CustomerTO> dataCustomers = new CellTable<CustomerTO>();
	@UiField SimplePager pager;
	@UiField Button butAcept;
	
	private Presenter presenter;
	
	private Column<CustomerTO, Boolean> checkColumn;
	private  SingleSelectionModel<CustomerTO> selectionModel;

	interface SearchCustomerViewImplUiBinder extends
			UiBinder<Widget, SearchCustomerViewImpl> {
	}

	public void initDataCustomer ()
	{
		SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
	    pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);	    
	    pager.setDisplay(dataCustomers);
	    
	    ProvidesKey<CustomerTO> providesKey = new ProvidesKey<CustomerTO>()
			    {
					
					@Override
					public Object getKey(CustomerTO item) {
						
						return (item == null) ? null : item.getIdCustomer();

					}
				};
				selectionModel = new SingleSelectionModel<CustomerTO>(providesKey);			    
				dataCustomers.setSelectionModel(selectionModel, DefaultSelectionEventManager.<CustomerTO>createCheckboxManager());
				
	    
	    checkColumn = new Column<CustomerTO, Boolean>(
		        new CheckboxCell(true, false)) {
		      @Override
		      public Boolean getValue(CustomerTO object) {		        
		        return selectionModel.isSelected(object);
		      }
		    };
		    
		    dataCustomers.addColumn(checkColumn);
		    
		    dataCustomers.addColumn(new TextColumn<CustomerTO>() 
					{
			
						@Override
						public String getValue(CustomerTO object) {
							
							return object.getIdCustomer().toString();
						}
					}, 
			"Codigo");
		    
		    dataCustomers.addColumn(new TextColumn<CustomerTO>() 
					{
			
						@Override
						public String getValue(CustomerTO object) {
							
							return object.getDni().toString();
						}
					}, 
			"Documento");
		    
		    
		    dataCustomers.addColumn(new TextColumn<CustomerTO>() 
					{
			
						@Override
						public String getValue(CustomerTO object) {
							
							return object.getFirstName();
						}
					}, 
			"Nombre");
		    
		    dataCustomers.addColumn(new TextColumn<CustomerTO>() 
					{
			
						@Override
						public String getValue(CustomerTO object) {
							
							return object.getLastName();
						}
					}, 
			"Apellido");
	}
	
	public SearchCustomerViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		initDataCustomer();
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void setCustomers(List<CustomerTO> customerTOs) {
		dataCustomers.setRowData(customerTOs);
		dataCustomers.redraw();
	}

	@UiHandler("butAcept")
	void onButAceptClick(ClickEvent event) {			
		
		presenter.aceptSelectCustomer(selectionModel.getSelectedObject());
	}
}
