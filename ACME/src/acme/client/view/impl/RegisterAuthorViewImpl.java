package acme.client.view.impl;

import java.util.List;

import acme.client.view.RegisterAuthorView;
import acme.shared.TO.AuthorTO;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
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
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionModel;

public class RegisterAuthorViewImpl extends Composite implements RegisterAuthorView {

	private static RegisterAuthorViewImplUiBinder uiBinder = GWT
			.create(RegisterAuthorViewImplUiBinder.class);
	@UiField TextBox txtName;
	@UiField TextBox txtSurname;
	@UiField Button butSave;
	@UiField(provided=true) CellTable<AuthorTO> dataAuthors = new CellTable<AuthorTO>();
	@UiField Button butSelected;
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
			        new CheckboxCell()) {
			      @Override
			      public Boolean getValue(AuthorTO object) {		        
			        return false;
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
			    dataAuthors.setSelectionModel(selectionModel);    
			   
	}

	public void configureSelectMode ()
	{
		if (dataAuthors.getColumnIndex(checkColumn) == -1)
		{			
			if (selectionMode)
			{
				dataAuthors.addColumn(checkColumn);
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
		Window.alert("Seleccionados: " + selectionModel.getSelectedSet().size());
		Window.alert("Uno de ellos: " + ((AuthorTO)selectionModel.getSelectedSet().toArray()[0]).getIdAuthor());
		
	}
}
