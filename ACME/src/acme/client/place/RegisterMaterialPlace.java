package acme.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class RegisterMaterialPlace extends Place
{
	public static class Tokenizer implements PlaceTokenizer<RegisterMaterialPlace> {

		@Override
		public RegisterMaterialPlace getPlace(String token) {
			// TODO Auto-generated method stub
			return new RegisterMaterialPlace();
		}

		@Override
		public String getToken(RegisterMaterialPlace place) {
			// TODO Auto-generated method stub
			return "";
		}
		
	}
}
