package acme.server.manager;

import java.util.List;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;

import acme.server.service.MasterService;
import acme.shared.TO.ClassificationTO;
import acme.shared.TO.CollectionTO;
import acme.shared.TO.KindMaterialTO;

public class MasterManager 
{
	public static MasterManager getInstance ()
	{
		return new MasterManager();
	}
	
	public List<CollectionTO> getCollections ()
	{
		return MasterService.getInstance().getCollections();
	}
	
	public List <KindMaterialTO> getKindMaterials()
	{
		return MasterService.getInstance().getKindMaterials();
	}
	
	public List <ClassificationTO> getClassification ()
	{
		return MasterService.getInstance().getClassification();
	}

}
