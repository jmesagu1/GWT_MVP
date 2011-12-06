package acme.server.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import acme.server.entity.Author;
import acme.server.entity.Classification;
import acme.server.entity.Collection;
import acme.server.entity.KindMaterial;
import acme.server.entity.Material;
import acme.shared.TO.AuthorTO;
import acme.shared.TO.MaterialTO;

public class MaterialService 
{
	public static MaterialService getInstance ()
	{
		return new MaterialService();		
	}
	
	public List<MaterialTO> getAllMaterials (int from, int to)
	{
		List<MaterialTO> list = new ArrayList<MaterialTO>();
		Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		List <Material> materials = session.createQuery("from Material").list();
		for(Material m : materials)
		{
			MaterialTO materialTO = new MaterialTO();
			materialTO.setEdition(m.getEdition());
			materialTO.setIdMaterial(m.getIdMaterial());
			materialTO.setName(m.getName());
			materialTO.setPublishDate(m.getPublishDate());
			materialTO.setUnits(m.getUnits());
			list.add(materialTO);
		}
		return list;
		
	}
	
	public String saveMaterial (MaterialTO materialTO)
	{
		String result = "";
		Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
		try 
		{			
			session.getTransaction().begin();
			Material material = getMaterialAsEntity(materialTO);
			session.save(material);				
			
			Iterator<AuthorTO> iter = materialTO.getAuthors().iterator();
			
			String ids = "(";
			while(iter.hasNext())
			{
				ids += "a.idAuthor = " + iter.next().getIdAuthor();
				if (iter.hasNext())
				{
					ids += " or ";
				}
				else 
				{
					ids += ")";
				}
			}
			Query query = session.createQuery("from Author as a where " + ids);			
			List<Author> auts = query.list();
			for (Author t : auts)
			{
				t.getMaterials().add(material);
			}
			
			session.getTransaction().commit();			
			result = "Nuevo material almacenado con éxito";
			
		}
		catch (Exception e) 
		{
			//session.getTransaction().rollback();
			result =  "Error Service: SaveMaterial - " + e.getMessage();
			
		}
		return result;
	}
	
	public Material getMaterialAsEntity (MaterialTO materialTO)
	{
		Material material = new Material();
		Set <Author> authors = new HashSet<Author>();
		for (AuthorTO to : materialTO.getAuthors())
		{
			authors.add(AuthorService.getAuthorAsEntity(to));
		}
		
		Classification classification = new Classification();
		classification.setIdClassification(materialTO.getClassification().getIdClassification());
		
		KindMaterial kindMaterial = new KindMaterial();
		kindMaterial.setIdKindMaterial(materialTO.getKindMaterial().getIdKindMaterial());
		
		Collection collection = new Collection();
		collection.setIdCollection(materialTO.getCollection().getIdCollection());
		
		material.setAuthors(authors);
		material.setClassification(classification);
		material.setCollection(collection);
		material.setEdition(materialTO.getEdition());
		material.setKindMaterial(kindMaterial);
		material.setName(materialTO.getName());
		material.setPublishDate(materialTO.getPublishDate());
		material.setUnits(materialTO.getUnits());	
		material.setAvailable(true);
		
		return material;
	}
	
	
	
}
