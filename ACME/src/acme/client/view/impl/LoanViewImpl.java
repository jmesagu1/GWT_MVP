package acme.client.view.impl;

import acme.client.view.LoanView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class LoanViewImpl extends Composite implements LoanView {

	private static LoanViewImplUiBinder uiBinder = GWT
			.create(LoanViewImplUiBinder.class);
	@UiField Button butSearchMaterial;

	private Presenter presenter;
	
	interface LoanViewImplUiBinder extends UiBinder<Widget, LoanViewImpl> {
	}

	public LoanViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
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
}
