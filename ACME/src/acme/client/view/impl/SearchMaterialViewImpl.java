package acme.client.view.impl;

import java.util.List;

import acme.client.view.SearchMaterialView;
import acme.shared.TO.AuthorTO;
import acme.shared.TO.MaterialTO;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.ProvidesKey;

public class SearchMaterialViewImpl extends Composite implements SearchMaterialView {

	private static SearchMaterialViewImplUiBinder uiBinder = GWT
			.create(SearchMaterialViewImplUiBinder.class);
	@UiField(provided=true) CellTable<MaterialTO> dataMaterial = new CellTable<MaterialTO>();
	@UiField SimplePager pager;
	
	private Presenter presenter;
	
	private Column<MaterialTO, Boolean> checkColumn;
	private  MultiSelectionModel<MaterialTO> selectionModel;	

	interface SearchMaterialViewImplUiBinder extends
			UiBinder<Widget, SearchMaterialViewImpl> {
	}
	
	public void initDataTable()
	{
		SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
	    pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);	    
	    pager.setDisplay(dataMaterial);
	    
	    checkColumn = new Column<MaterialTO, Boolean>(
		        new CheckboxCell(true, false)) {
		      @Override
		      public Boolean getValue(MaterialTO object) {		        
		        return selectionModel.isSelected(object);
		      }
		    };
		    
		    dataMaterial.addColumn(checkColumn);
	    
		dataMaterial.addColumn(new TextColumn<MaterialTO>() 
				{
		
					@Override
					public String getValue(MaterialTO object) {
						
						return object.getCode();
					}
				}, 
		"Código");
		
		dataMaterial.addColumn(new TextColumn<MaterialTO>() 
				{
		
					@Override
					public String getValue(MaterialTO object) {
						
						return object.getName();
					}
				}, 
		"Nombre Libro");
		
		dataMaterial.addColumn(new TextColumn<MaterialTO>() 
				{
		
					@Override
					public String getValue(MaterialTO object) {
						
						return object.getEdition();
					}
				}, 
		"Edición");	
		
		    
		    ProvidesKey<MaterialTO> providesKey = new ProvidesKey<MaterialTO>()
				    {
						
						@Override
						public Object getKey(MaterialTO item) {
							
							return (item == null) ? null : item.getIdMaterial();

						}
					};
					selectionModel = new MultiSelectionModel<MaterialTO>(providesKey);			    
					dataMaterial.setSelectionModel(selectionModel, DefaultSelectionEventManager.<MaterialTO>createCheckboxManager());		
	}

	public SearchMaterialViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		initDataTable();
	}	

	public SearchMaterialViewImpl(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void setMaterials(List<MaterialTO> materialTOs) {
		dataMaterial.setRowData(materialTOs);
		dataMaterial.redraw();
	}	
}
