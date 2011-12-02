package acme.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class RegisterAuthorPlace extends Place 
{
	private String fromPlace;	
	
	public static class Tokenizer implements PlaceTokenizer<RegisterAuthorPlace> {
		@Override
		public String getToken(RegisterAuthorPlace place) {
			return place.getFromPlace();
		}

		@Override
		public RegisterAuthorPlace getPlace(String token) {
			RegisterAuthorPlace place = new RegisterAuthorPlace();
			place.setFromPlace(token);
			return place;
		}
	}

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}	
}
