package acme.shared.TO;

import java.io.Serializable;

public class CollectionTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private long idCollection;
	//private TicketPrice ticketPrice;
	private String name;
	private String letters;
	private Boolean reserve;
	public long getIdCollection() {
		return idCollection;
	}
	public void setIdCollection(long idCollection) {
		this.idCollection = idCollection;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLetters() {
		return letters;
	}
	public void setLetters(String letters) {
		this.letters = letters;
	}
	public Boolean getReserve() {
		return reserve;
	}
	public void setReserve(Boolean reserve) {
		this.reserve = reserve;
	}
	
	
	
}
