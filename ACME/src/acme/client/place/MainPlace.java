package acme.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class MainPlace extends Place  
{
	public static class Tokenizer implements PlaceTokenizer<MainPlace> {

		@Override
		public MainPlace getPlace(String token) {
			// TODO Auto-generated method stub			
			return new MainPlace();
		}

		@Override
		public String getToken(MainPlace place) {
			// TODO Auto-generated method stub
			return "";
		}
		
	}
}
