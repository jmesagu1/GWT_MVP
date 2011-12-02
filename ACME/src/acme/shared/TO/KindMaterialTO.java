package acme.shared.TO;

import java.io.Serializable;

public class KindMaterialTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long idKindMaterial;
	private String name;
	private String letters;
	public long getIdKindMaterial() {
		return idKindMaterial;
	}
	public void setIdKindMaterial(long idKindMaterial) {
		this.idKindMaterial = idKindMaterial;
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
	
	
}
