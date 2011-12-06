package acme.client.place;

import java.util.HashSet;
import java.util.Set;

import acme.shared.TO.AuthorTO;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class RegisterMaterialPlace extends Place
{
	private Set <AuthorTO> authors = new HashSet<AuthorTO>();
	
	public static class Tokenizer implements PlaceTokenizer<RegisterMaterialPlace> {	
		
		@Override
		public RegisterMaterialPlace getPlace(String token) {
			// TODO Auto-generated method stub
			return new RegisterMaterialPlace();
		}

		@Override
		public String getToken(RegisterMaterialPlace place) {
			String authors = "";
			for (AuthorTO t: place.authors)
			{				
				authors += t.getIdAuthor() + ",";
			}
			return authors;
		}
		
	}

	public Set <AuthorTO> getAuthors() {
		return authors;
	}

	public void setAuthors(Set <AuthorTO> authors) {
		this.authors = authors;
	}
}
