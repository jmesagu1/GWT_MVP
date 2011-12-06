package acme.server.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import acme.server.entity.Classification;
import acme.server.entity.Collection;
import acme.server.entity.KindMaterial;
import acme.shared.TO.ClassificationTO;
import acme.shared.TO.CollectionTO;
import acme.shared.TO.KindMaterialTO;

public class MasterService {
	
	public static MasterService getInstance ()
	{
		return new MasterService();
	}
	
	public List <KindMaterialTO> getKindMaterials()
	{
		List <KindMaterialTO> tos = new ArrayList<KindMaterialTO>();
		
		try
		{		
			Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			List <KindMaterial> list =  session.createQuery("from KindMaterial").list();	
			for (KindMaterial c :list)
			{				
				KindMaterialTO to = new KindMaterialTO();
				to.setIdKindMaterial(c.getIdKindMaterial());
				to.setLetters(c.getLetters());
				to.setName(c.getName());
				tos.add(to);
				
			}
		}
		catch (Exception e) 
		{
			System.out.println("An error getKindMaterials: "  + e.getMessage());
		}
		
		
		return tos;
	}
	
	public List <ClassificationTO> getClassification ()
	{
		List <ClassificationTO> tos = new ArrayList<ClassificationTO>();
		
		try
		{		
			Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			List <Classification> list =  session.createQuery("from Classification").list();
			for (Classification c :list)
			{				
				ClassificationTO to = new ClassificationTO();
				to.setIdClassification(c.getIdClassification());
				to.setName(c.getName());
				tos.add(to);
			}
		}
		catch (Exception e) 
		{
			System.out.println("An error classification: "  + e.getMessage());
		}
		
		return tos;
	}
	
	public List<CollectionTO> getCollections ()
	{
		List<CollectionTO> tos = new ArrayList<CollectionTO>();
		try
		{
		
			Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			List <Collection> list =  session.createQuery("from Collection").list();	
			for (Collection c :list)
			{
				CollectionTO cTo = new CollectionTO();
				cTo.setIdCollection(c.getIdCollection());
				cTo.setLetters(c.getLetters());
				cTo.setName(c.getName());			
				tos.add(cTo);
			}
		}
		catch (Exception e) 
		{
			System.out.println("An error query: "  + e.getMessage());
		}
		return tos;
	}

}
