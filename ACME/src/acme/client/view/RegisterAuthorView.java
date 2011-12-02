package acme.client.view;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import acme.shared.TO.AuthorTO;

public interface RegisterAuthorView extends IsWidget
{
	void setPresenter (Presenter presenter);
	void disableSelection();
	void enableSelection();
	void loadAuthors (List<AuthorTO> authorTOs);
	void clearTxtboxes();
	
	public interface Presenter
	{
		void save(AuthorTO authorTO);	
		//void acpetSelect();
	}
}
