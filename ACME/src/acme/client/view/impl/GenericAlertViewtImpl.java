package acme.client.view.impl;

import acme.client.view.GenericAlertView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class GenericAlertViewtImpl extends PopupPanel implements GenericAlertView {

	private static final Binder binder = GWT.create(Binder.class);
	@UiField Label labMessaje;
	@UiField Button butAcept;
	@UiField Button butPrint;

	interface Binder extends UiBinder<Widget, GenericAlertViewtImpl> {
	}

	public GenericAlertViewtImpl() {
		setWidget(binder.createAndBindUi(this));
	}
	
	public void show()
	{
		setGlassEnabled(true);
		center();
		super.show();		
	}
	
	public void setMessaje (String messaje)
	{
		labMessaje.setText(messaje);
	}

	@UiHandler("butAcept")
	void onButAceptClick(ClickEvent event) {
		labMessaje.setText("");
		hide();		
	}
	@UiHandler("butPrint")
	void onButPrintClick(ClickEvent event) {		
	}
}
