package acme.server.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class SessionFactoryUtil {
	
	private static final SessionFactory sessionFactory;
	static {
		
		try 
		{
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();				
		}
		catch (Exception e) 
		{
			System.err.println("Initial SessionFactory creation failed." + e);
			throw new ExceptionInInitializerError(e);
		}	 
	}
	
	public static SessionFactory getSessionFactory()
	{		
		return sessionFactory;
	}

}
