package acme.server.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import acme.server.entity.Author;
import acme.shared.TO.AuthorTO;

public class AuthorService {
	
	public static AuthorService getInstance ()
	{
		return new AuthorService();
	}
	
	public List<AuthorTO> getAuthorTOs()
	{		
		List<AuthorTO> tos = new ArrayList<AuthorTO>();
		try 
		{
			Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();			
			List <Author> list =  session.createQuery("from Author").list();			
			for (Author c :list)
			{				
				AuthorTO to = new AuthorTO();
				to.setFirstName(c.getFirstName());
				to.setLastName(c.getLastName());
				to.setIdAuthor(c.getIdAuthor());
				tos.add(to);				
			}
		}
		catch (Exception e) 
		{
			System.out.println("Error AuthorTO: " + e.getMessage());
		}
		return tos;
	}
	
	public String saveAuthor (AuthorTO authorTO)
	{
		String result = "";
		try 
		{
			Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			
			Author author = new Author();
			author.setFirstName(authorTO.getFirstName());
			author.setLastName(authorTO.getLastName());
			
			session.persist(author);
			
			session.getTransaction().commit();
			result = "Autor: " + author.getFirstName() + " " + author.getLastName() +
					" almacenado con éxito: Id " + author.getIdAuthor();
		} 
		catch (Exception e) 
		{
			result = "Error registrado el Autor: "   + e.getMessage();
		}	
		return result;
	}

}
