package nc.dva.examples.geo.codes.postaux;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "code_postal")
public class CodePostalCommune {
	
	@Column(name = "code_postal", insertable = false, updatable = false)
	private String codePostal;
	
	@Id
	@Column(name = "code_insee", insertable = false, updatable = false)
	private String codeCommune;
	
	@Column(name = "nom_commune", insertable = false, updatable = false)
	private String nomCommune;
	
	@Column(name = "libelle_acheminement", insertable = false, updatable = false)
	private String libelleAcheminement;

	/**
	 * Default constructor
	 */
	public CodePostalCommune() {
	}

	/**
	 * @param codePostal
	 * @param libelleAcheminement
	 * @param codeInsee
	 * @param nomCommune
	 */
	public CodePostalCommune(String codePostal, String libelleAcheminement, String codeCommune, String nomCommune) {
		this.codePostal = codePostal;
		this.libelleAcheminement = libelleAcheminement;
		this.codeCommune = codeCommune;
		this.nomCommune = nomCommune;
	}

	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return the libelleAcheminement
	 */
	public String getLibelleAcheminement() {
		return libelleAcheminement;
	}

	/**
	 * @param libelleAcheminement the libelleAcheminement to set
	 */
	public void setLibelleAcheminement(String libelleAcheminement) {
		this.libelleAcheminement = libelleAcheminement;
	}

	/**
	 * @return the codeInsee
	 */
	public String getCodeCommune() {
		return codeCommune;
	}

	/**
	 * @param codeInsee the codeInsee to set
	 */
	public void setCodeCommune(String codeCommune) {
		this.codeCommune = codeCommune;
	}

	/**
	 * @return the nomCommune
	 */
	public String getNomCommune() {
		return nomCommune;
	}

	/**
	 * @param nomCommune the nomCommune to set
	 */
	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeCommune == null) ? 0 : codeCommune.hashCode());
		return result;
	}

	/* (non-Javadoc)
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
		CodePostalCommune other = (CodePostalCommune) obj;
		if (codeCommune == null) {
			if (other.codeCommune != null)
				return false;
		} else if (!codeCommune.equals(other.codeCommune))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CodePostalCommune [");
		if (codePostal != null) {
			builder.append("\n\tcodePostal=");
			builder.append(codePostal);
			builder.append(", ");
		}
		if (libelleAcheminement != null) {
			builder.append("\n\tlibelleAcheminement=");
			builder.append(libelleAcheminement);
			builder.append(", ");
		}
		if (codeCommune != null) {
			builder.append("\n\tcodeInsee=");
			builder.append(codeCommune);
			builder.append(", ");
		}
		if (nomCommune != null) {
			builder.append("\n\tnomCommune=");
			builder.append(nomCommune);
		}
		builder.append("\n]");
		return builder.toString();
	}
	
	

}
