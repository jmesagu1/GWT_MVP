package acme.shared.TO;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import acme.server.entity.Collection;

public class MaterialTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idMaterial;
	private CollectionTO collection;
	private KindMaterialTO kindMaterial;
	private ClassificationTO classification;
	private String name;
	private Long units;
	private String edition;
	private Date publishDate;
	private Boolean available;
	private String code;
	private Set<AuthorTO> authors = new HashSet<AuthorTO>(0);
	private Set<LoanTO> loans = new HashSet<LoanTO>(0);
	public Long getIdMaterial() {
		return idMaterial;
	}
	public void setIdMaterial(Long idMaterial) {
		this.idMaterial = idMaterial;
	}
	public CollectionTO getCollection() {
		return collection;
	}
	public void setCollection(CollectionTO collection) {
		this.collection = collection;
	}
	public KindMaterialTO getKindMaterial() {
		return kindMaterial;
	}
	public void setKindMaterial(KindMaterialTO kindMaterial) {
		this.kindMaterial = kindMaterial;
	}
	public ClassificationTO getClassification() {
		return classification;
	}
	public void setClassification(ClassificationTO classification) {
		this.classification = classification;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getUnits() {
		return units;
	}
	public void setUnits(Long units) {
		this.units = units;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Set<AuthorTO> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<AuthorTO> authors) {
		this.authors = authors;
	}
	public Set<LoanTO> getLoans() {
		return loans;
	}
	public void setLoans(Set<LoanTO> loans) {
		this.loans = loans;
	}	
	
}
