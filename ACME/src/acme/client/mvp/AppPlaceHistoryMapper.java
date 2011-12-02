package acme.client.mvp;

import acme.client.place.MainPlace;
import acme.client.place.RegisterAuthorPlace;
import acme.client.place.RegisterCustomerPlace;
import acme.client.place.RegisterMaterialPlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;


@WithTokenizers( {RegisterCustomerPlace.Tokenizer.class, RegisterAuthorPlace.Tokenizer.class, MainPlace.Tokenizer.class,
	RegisterMaterialPlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper 
{
	
}
