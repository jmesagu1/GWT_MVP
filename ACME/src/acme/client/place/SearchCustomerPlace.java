package acme.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class SearchCustomerPlace extends Place {
	
	private LoanPlace loanPlace;
	
	public static class Tokenizer implements PlaceTokenizer<SearchCustomerPlace>
	{		

		@Override
		public SearchCustomerPlace getPlace(String token) {
			SearchCustomerPlace place = new SearchCustomerPlace();
			return place;
		}

		@Override
		public String getToken(SearchCustomerPlace place) {			
			return "";
		}
		
	}

	public LoanPlace getLoanPlace() {
		return loanPlace;
	}

	public void setLoanPlace(LoanPlace loanPlace) {
		this.loanPlace = loanPlace;
	}

}
