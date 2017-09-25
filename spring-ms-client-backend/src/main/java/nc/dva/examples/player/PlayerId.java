package nc.dva.examples.player;

import java.io.Serializable;

public class PlayerId implements Serializable {

	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 3646020764710451978L;
	private String firstName;
	private String lastName;

	/**
	 * @return the firstName
	 */
	public String getFirstname() {
		return firstName;
	}

	/**
	 * @param firstname
	 *            the firstName to set
	 */
	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}

	/**
	 * @return the lastName
	 */
	public String getLastname() {
		return lastName;
	}

	/**
	 * @param lastname
	 *            the lastName to set
	 */
	public void setLastname(String lastname) {
		this.lastName = lastname;
	}

	/**
	 * 
	 */
	public PlayerId() {
		super();
	}

	/**
	 * @param firstname
	 * @param lastname
	 */
	public PlayerId(String firstname, String lastname) {
		super();
		this.firstName = firstname;
		this.lastName = lastname;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerId other = (PlayerId) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PlayerId [\n\tfirstname=");
		builder.append(firstName);
		builder.append("\n\t, lastname=");
		builder.append(lastName);
		builder.append("\n]");
		return builder.toString();
	}

}
