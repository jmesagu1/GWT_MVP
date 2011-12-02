package acme.shared.TO;

import java.io.Serializable;

public class ClassificationTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idClassification;
	private String name;
	public Long getIdClassification() {
		return idClassification;
	}
	public void setIdClassification(Long idClassification) {
		this.idClassification = idClassification;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
