package acme.client.mvp;

import acme.client.place.LoanPlace;
import acme.client.place.MainPlace;
import acme.client.place.RegisterAuthorPlace;
import acme.client.place.RegisterCustomerPlace;
import acme.client.place.RegisterMaterialPlace;
import acme.client.place.SearchCustomerPlace;
import acme.client.place.SearchMaterialPlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;


@WithTokenizers( {RegisterCustomerPlace.Tokenizer.class, RegisterAuthorPlace.Tokenizer.class, MainPlace.Tokenizer.class,
	RegisterMaterialPlace.Tokenizer.class, SearchMaterialPlace.Tokenizer.class, LoanPlace.Tokenizer.class,
	SearchCustomerPlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper 
{
	
}
