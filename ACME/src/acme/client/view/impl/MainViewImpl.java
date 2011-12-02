package acme.client.view.impl;

import acme.client.view.MainView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MainViewImpl extends Composite implements MainView {

	private static MainViewImplUiBinder uiBinder = GWT
			.create(MainViewImplUiBinder.class);
	@UiField Button butRegisterCustomer;
	@UiField Button butAdminMaterial;
	
	private Presenter presenter;

	interface MainViewImplUiBinder extends UiBinder<Widget, MainViewImpl> {
	}

	public MainViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public MainViewImpl(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
		
	}	
	@UiHandler("butRegisterCustomer")
	void onButRegisterCustomerClick(ClickEvent event) {
		
		presenter.customerAdmin();
	}
	@UiHandler("butMasters")
	void onButMastersClick(ClickEvent event) {
		presenter.masters();
	}
	@UiHandler("butAdminMaterial")
	void onButAdminMaterialClick(ClickEvent event) {
		presenter.materialAdmin();
	}
}
