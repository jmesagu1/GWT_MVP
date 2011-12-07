package acme.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class SearchMaterialPlace extends Place 
{
	private LoanPlace loanPlace;
	public static class Tokenizer implements PlaceTokenizer<SearchMaterialPlace> {

		@Override
		public SearchMaterialPlace getPlace(String token) {
			SearchMaterialPlace place = new SearchMaterialPlace();
			return place;
		}

		@Override
		public String getToken(SearchMaterialPlace place) {
			
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
