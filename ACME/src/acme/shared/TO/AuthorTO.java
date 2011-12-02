package acme.shared.TO;

import java.io.Serializable;

public class AuthorTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idAuthor;
	private String firstName;
	private String lastName;
	public Long getIdAuthor() {
		return idAuthor;
	}
	public void setIdAuthor(Long idAuthor) {
		this.idAuthor = idAuthor;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
