package acme.client.place;

import java.util.ArrayList;
import java.util.List;

import acme.shared.TO.CustomerTO;
import acme.shared.TO.MaterialTO;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class LoanPlace extends Place 
{
	private List <MaterialTO> materialTOs = new ArrayList<MaterialTO>();
	private CustomerTO customerTO;
	
	public List <MaterialTO> getMaterialTOs() {
		return materialTOs;
	}

	public void setMaterialTOs(List <MaterialTO> materialTOs) {
		this.materialTOs = materialTOs;
	}
	
	public CustomerTO getCustomerTO() {
		return customerTO;
	}

	public void setCustomerTO(CustomerTO customerTO) {
		this.customerTO = customerTO;
	}

	public static class Tokenizer implements PlaceTokenizer<LoanPlace> 
	{		
		@Override
		public LoanPlace getPlace(String token) {
			
			LoanPlace place = new LoanPlace();
			return place;
		}

		@Override
		public String getToken(LoanPlace place) {			
			return "";
		}	
		
	}
}
