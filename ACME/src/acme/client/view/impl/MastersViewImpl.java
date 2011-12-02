package acme.client.view.impl;


import com.google.gwt.core.client.GWT;


import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MastersViewImpl extends Composite  {

	private static MastersViewImplUiBinder uiBinder = GWT
			.create(MastersViewImplUiBinder.class);

	interface MastersViewImplUiBinder extends UiBinder<Widget, MastersViewImpl> {
	}

	public MastersViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	
	public MastersViewImpl(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}


	@Override
	public Widget asWidget() {
		// TODO Auto-generated method stub
		return null;
	}

}
