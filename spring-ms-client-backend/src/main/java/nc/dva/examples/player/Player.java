package nc.dva.examples.player;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "player")
@IdClass(PlayerId.class)
public class Player {

	@Id
	@Column(name = "lastname")
	private String lastName;

	@Id
	@Column(name = "firstname")
	private String firstName;

	@Column(name = "country")
	private String country;

	@Column(name = "gender")
	private String gender;

	/**
	 * 
	 */
	public Player() {
		super();
	}

	/**
	 * @param lastName
	 * @param firstName
	 * @param country
	 */
	public Player(String lastName, String firstName, String country, String gender) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.country = country;
		this.gender = gender;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player [");
		if (lastName != null) {
			builder.append("\n\tlastName=");
			builder.append(lastName);
			builder.append(", ");
		}
		if (firstName != null) {
			builder.append("\n\tfirstName=");
			builder.append(firstName);
			builder.append(", ");
		}
		if (country != null) {
			builder.append("\n\tcountry=");
			builder.append(country);
			builder.append(", ");
		}
		if (gender != null) {
			builder.append("\n\tgender=");
			builder.append(gender);
		}
		builder.append("\n]");
		return builder.toString();
	}

}
