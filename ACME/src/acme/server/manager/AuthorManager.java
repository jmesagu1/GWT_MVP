package acme.server.manager;

import java.util.List;

import acme.server.service.AuthorService;
import acme.shared.TO.AuthorTO;

public class AuthorManager 
{
	public static AuthorManager getInstance ()
	{
		return new AuthorManager();
	}
	
	public String saveAuthor (AuthorTO authorTO)
	{
		return AuthorService.getInstance().saveAuthor(authorTO);
	}
	
	public List<AuthorTO> getAuthorTOs()
	{
		return AuthorService.getInstance().getAuthorTOs();
	}
}
