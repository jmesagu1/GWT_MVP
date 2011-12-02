package acme.client.view.impl;

import java.util.List;

import acme.client.view.RegisterMaterialView;
import acme.shared.TO.ClassificationTO;
import acme.shared.TO.CollectionTO;
import acme.shared.TO.KindMaterialTO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.LongBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class RegisterMaterialViewImpl extends Composite implements RegisterMaterialView {

	private static RegisterMaterialViewImplUiBinder uiBinder = GWT
			.create(RegisterMaterialViewImplUiBinder.class);
	@UiField LongBox txtUnits;
	@UiField TextBox txtName;
	@UiField DateBox txtPublishDate;
	@UiField TextBox txtEdition;
	@UiField ListBox cmbCollection;
	@UiField ListBox cmbClassification;
	@UiField ListBox cmbKindMaterial;
	@UiField Button butSelectAuthor;

	private Presenter presenter;
	
	interface RegisterMaterialViewImplUiBinder extends
			UiBinder<Widget, RegisterMaterialViewImpl> {
	}	
	
	public RegisterMaterialViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));	
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
}
