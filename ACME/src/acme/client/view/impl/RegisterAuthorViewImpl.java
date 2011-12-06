package acme.client.view.impl;

import java.util.List;
import java.util.Set;

import acme.client.view.RegisterAuthorView;
import acme.shared.TO.AuthorTO;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.ProvidesKey;

public class RegisterAuthorViewImpl extends Composite implements RegisterAuthorView {

	private static RegisterAuthorViewImplUiBinder uiBinder = GWT
			.create(RegisterAuthorViewImplUiBinder.class);
	@UiField TextBox txtName;
	@UiField TextBox txtSurname;
	@UiField Button butSave;
	@UiField(provided=true) CellTable<AuthorTO> dataAuthors = new CellTable<AuthorTO>();
	@UiField Button butSelected;
	@UiField SimplePager pager;
	private boolean selectionMode;
	private Presenter presenter;
	private Column<AuthorTO, Boolean> checkColumn;
	private  MultiSelectionModel<AuthorTO> selectionModel;	


	interface RegisterAuthorViewImplUiBinder extends
			UiBinder<Widget, RegisterAuthorViewImpl> {
	}

	public RegisterAuthorViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		selectionMode = false;		
		initCellTable();
		butSelected.setVisible(false);
	}

	@Override
	public void setPresenter(Presenter presenter) {		
		this.presenter = presenter;		
	}

	@UiHandler("butSave")
	void onButSaveClick(ClickEvent event) {
		
		AuthorTO authorTO = new AuthorTO();
		authorTO.setFirstName(txtName.getText());
		authorTO.setLastName(txtSurname.getText());
		presenter.save(authorTO);
	}

	@Override
	public void disableSelection() {	
		selectionMode = false;
		butSelected.setVisible(false);
	}
	
	public void initCellTable()
	{
		
		dataAuthors.addColumn(
				new TextColumn<AuthorTO>() 
				{

					@Override
					public String getValue(AuthorTO object) {
						
						return object.getFirstName() + " " + object.getLastName();
					}
				}, 
		"Nombre del Autor");		
		
		
		checkColumn = new Column<AuthorTO, Boolean>(
			        new CheckboxCell(true, false)) {
			      @Override
			      public Boolean getValue(AuthorTO object) {		        
			        return selectionModel.isSelected(object);
			      }
			    };
			    
			    ProvidesKey<AuthorTO> providesKey = new ProvidesKey<AuthorTO>()
			    {
					
					@Override
					public Object getKey(AuthorTO item) {
						
						return (item == null) ? null : item.getIdAuthor();

					}
				};
				selectionModel = new MultiSelectionModel<AuthorTO>(providesKey);			    
			    dataAuthors.setSelectionModel(selectionModel, DefaultSelectionEventManager.<AuthorTO>createCheckboxManager());
			    
			    SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
			    pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);	    
			    pager.setDisplay(dataAuthors);
			   
	}

	public void configureSelectMode ()
	{
		if (dataAuthors.getColumnIndex(checkColumn) == -1)
		{			
			if (selectionMode)
			{
				dataAuthors.addColumn(checkColumn,SafeHtmlUtils.fromSafeConstant("<br/>"));
			}			
		}		
		else
		{
			if(!selectionMode)
			{
				dataAuthors.removeColumn(checkColumn);
			}
		}			
			
	}
	
	@Override
	public void loadAuthors(List<AuthorTO> authorTOs) {	
		configureSelectMode();
		dataAuthors.setRowData(authorTOs);	
		dataAuthors.redraw();
	}

	@Override
	public void enableSelection() {
		selectionMode = true;	
		butSelected.setVisible(true);
	}

	@Override
	public void clearTxtboxes() {
		txtName.setText("");
		txtSurname.setText("");
	}
	@UiHandler("butSelected")
	void onBurSelectedClick(ClickEvent event) {
		Set <AuthorTO> authors = selectionModel.getSelectedSet();
		if (authors.size() > 0)
		{
			presenter.aceptSelect(authors);
		}
		else if (selectionMode)
		{
			Window.alert("Por favor selecciona al menos un autor");
		}
	}
}
