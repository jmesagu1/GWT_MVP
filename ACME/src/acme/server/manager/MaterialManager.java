package acme.server.manager;

import java.util.List;

import acme.server.service.MaterialService;
import acme.shared.TO.MaterialTO;

public class MaterialManager 
{
	public static MaterialManager getInstance ()
	{
		return new MaterialManager();
	}
	
	public String saveMaterial (MaterialTO materialTO)
	{
		return MaterialService.getInstance().saveMaterial(materialTO);
	}
	
	public List<MaterialTO> getMaterials (int from, int to)
	{
		return MaterialService.getInstance().getAllMaterials(from, to);
	}
}
