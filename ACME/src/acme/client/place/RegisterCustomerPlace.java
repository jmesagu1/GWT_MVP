package acme.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class RegisterCustomerPlace extends Place 
{
	public static class Tokenizer implements PlaceTokenizer<RegisterCustomerPlace> {
		@Override
		public String getToken(RegisterCustomerPlace place) {
			return "";
		}

		@Override
		public RegisterCustomerPlace getPlace(String token) {
			RegisterCustomerPlace place = new RegisterCustomerPlace();
			return place;
		}
	}
}
