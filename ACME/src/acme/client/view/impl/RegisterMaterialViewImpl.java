package acme.client.view.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import acme.client.view.RegisterMaterialView;
import acme.shared.TO.AuthorTO;
import acme.shared.TO.ClassificationTO;
import acme.shared.TO.CollectionTO;
import acme.shared.TO.KindMaterialTO;
import acme.shared.TO.MaterialTO;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.LongBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;

public class RegisterMaterialViewImpl extends Composite implements RegisterMaterialView {

	private static RegisterMaterialViewImplUiBinder uiBinder = GWT
			.create(RegisterMaterialViewImplUiBinder.class);
	@UiField LongBox txtUnits;
	@UiField TextBox txtName;
	@UiField DateField txtPublishDate;
	@UiField TextBox txtEdition;
	@UiField ListBox cmbCollection;
	@UiField ListBox cmbClassification;
	@UiField ListBox cmbKindMaterial;
	@UiField Button butSelectAuthor;
	@UiField(provided=true) CellTable<AuthorTO> dataAuthors = new CellTable<AuthorTO>();
	@UiField Button butRegisterMaterial;

	private Presenter presenter;	
	
	public void initDataTable ()
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
	}
	
	interface RegisterMaterialViewImplUiBinder extends
			UiBinder<Widget, RegisterMaterialViewImpl> {		
	}	
	
	public RegisterMaterialViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		initDataTable ();
	}	

	public RegisterMaterialViewImpl(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));		
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}	

	@Override
	public void loadCollection(List<CollectionTO> collectionTOs) {
		cmbCollection.clear();
		for (CollectionTO c : collectionTOs)
		{
			cmbCollection.addItem(c.getLetters() + ": " + c.getName(), String.valueOf(c.getIdCollection()));			
		}
	}

	@Override
	public void loadClassification(List<ClassificationTO> classificationTOs) {
		cmbClassification.clear();
		for (ClassificationTO c : classificationTOs)
		{
			cmbClassification.addItem(c.getName(), String.valueOf(c.getIdClassification()));			
		}
	}

	@Override
	public void loadKindMaterial(List<KindMaterialTO> kindMaterialTOs) {
		cmbKindMaterial.clear();
		for (KindMaterialTO c : kindMaterialTOs)
		{
			cmbKindMaterial.addItem(c.getLetters() + ": " + c.getName(), String.valueOf(c.getIdKindMaterial()));			
		}
	}	

	@UiHandler("butSelectAuthor")
	void onButSelectAuthorClick(ClickEvent event) {
		presenter.selectAuthor();
	}

	@Override
	public void displayAuthors(Set<AuthorTO> authors) {
		List <AuthorTO> list = new ArrayList<AuthorTO>();
		for (AuthorTO to : authors)
		{
			list.add(to);
		}
		dataAuthors.setRowData(list);	
		dataAuthors.redraw();
	}
	@UiHandler("butRegisterMaterial")
	void onButRegisterMaterialClick(ClickEvent event) {	
		
		MaterialTO materialTO = new MaterialTO();
		ClassificationTO classificationTO = new ClassificationTO();
		classificationTO.setIdClassification(Long.parseLong(cmbClassification.getValue(cmbClassification.getSelectedIndex())));		
		
		CollectionTO collectionTO = new CollectionTO();
		collectionTO.setIdCollection(Long.parseLong(cmbCollection.getValue(cmbCollection.getSelectedIndex())));		
		
		KindMaterialTO kindMaterialTO = new KindMaterialTO();
		kindMaterialTO.setIdKindMaterial(Long.parseLong(cmbKindMaterial.getValue(cmbKindMaterial.getSelectedIndex())));
		
		materialTO.setClassification(classificationTO);	
		materialTO.setCollection(collectionTO);
		materialTO.setKindMaterial(kindMaterialTO);		
		materialTO.setEdition(txtEdition.getText());
		materialTO.setName(txtName.getText());
		materialTO.setUnits(txtUnits.getValue());
		materialTO.setPublishDate(txtPublishDate.getValue());
		butRegisterMaterial.setEnabled(false);
		try
		{
			presenter.saveMaterial(materialTO);
		} 
		catch (Exception e) 
		{
			Window.alert(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void clearInputs() {
		dataAuthors.setRowData(null);
		dataAuthors.redraw();
		txtEdition.setText("");
		txtName.setText("");
		txtPublishDate.setValue(null);
		txtUnits.setText("");
		butRegisterMaterial.setEnabled(true);
	}
}
