package acme.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class LoanPlace extends Place 
{
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
