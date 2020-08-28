package nc.dva.examples.hystrix;

/**
 * Pays et territoires étrangers
 *
 * <p>
 * Le fichier des pays et territoires étrangers contient le code des pays, le
 * libellé, leur année d'indépendance, leur ancien nom, leur ancien code, leur
 * code pays de rattachement si nécessaire.
 * </p>
 * 
 * @see <a href="https://insee.fr/fr/information/2666684#titre-bloc-31">Insee -
 *      Code officiel géographique au 1 er janvier 2017</a>
 * 
 * @author didier.vanderstoken@gouv.nc
 * 
 */

public class PaysEtTerritoiresEtrangers {

	/**
	 * <p>
	 * <strong>COG - Code du pays ou territoire</strong>
	 * </p>
	 * 
	 * <table summary="Codes de la variable COG">
	 * <tr>
	 * <td>991xx</td>
	 * <td>Europe</td>
	 * </tr>
	 * <tr>
	 * <td>992xx</td>
	 * <td>Asie</td>
	 * </tr>
	 * <tr>
	 * <td>993xx</td>
	 * <td>Afrique</td>
	 * </tr>
	 * <tr>
	 * <td>994xx</td>
	 * <td>Amérique</td>
	 * </tr>
	 * <tr>
	 * <td>995xx</td>
	 * <td>Océanie</td>
	 * </tr>
	 * </table>
	 */
	private String codePays;

	/**
	 * <p>
	 * <strong>ACTUAL - Code actualité du pays</strong>
	 * </p>
	 * 
	 * <table summary="Codes de la variable COG">
	 * <tr>
	 * <td>1</td>
	 * <td>Actuel</td>
	 * </tr>
	 * <tr>
	 * <td>2</td>
	 * <td>périmé (dont le code a disparu du C.O.G.)</td>
	 * </tr>
	 * <tr>
	 * <td>3</td>
	 * <td>territoire n'ayant pas son propre code officiel géographique</td>
	 * </tr>
	 * <tr>
	 * <td>4</td>
	 * <td>territoire ayant son propre code officiel géographique</td>
	 * </tr>
	 * </table>
	 */
	private String codeActualite;

	/**
	 * <p>
	 * <strong>CAPAY - Code officiel géographique de l'ancien pays de
	 * rattachement</strong>
	 * </p>
	 * 
	 * Ancien code officiel géographique du pays ou du pays auquel il était
	 * rattaché.
	 */
	private String codeAncienPaysRattachement;

	/**
	 * <p>
	 * <strong>CRPAY - Code officiel géographique de l'actuel pays de
	 * rattachement</strong>
	 * </p>
	 * 
	 * Code officiel géoraphique du pays de rattachement du territoire ou du
	 * pays périmé
	 * 
	 * Remarque :
	 * 
	 * Si CRPAY n'est pas renseigné pour certains pays périmés cela veut dire
	 * qu'ils ont été rattachés à plusieurs autres pays. Pour retrouver ces
	 * pays, il suffit de rechercher les pays dont le CAPAY correspond au code
	 * officiel géographique du pays périmé.
	 * 
	 * >Exemple :
	 * 
	 * Pour la COREE, le code officiel géographique est 99237, le code actualité
	 * est égal à 2 (c'est-à-dire que ce pays est périmé pour le C.O.G.) mais le
	 * code pays de rattachement n'est pas renseigné. Pour retrouver les pays de
	 * rattachement, il faut chercher les codes anciens pays égaux à 99237 dans
	 * la liste des pays actuels. On les trouve à :
	 * 
	 * - COREE (REPUBLIQUE POPULAIRE DEMOCRATIQUE DE )
	 * 
	 * COG = 99238 ACTUAL = 1
	 * 
	 * - COREE (REPUBLIQUE DE )
	 * 
	 * COG = 99239 ACTUAL = 1
	 */
	private String codeActuelPaysRattachement;

	/**
	 * <p>
	 * <strong>ANI - Année d'indépendance</strong>
	 * </p>
	 * 
	 * Année d'indépendance du pays dans la mesure où celle-ci s'est produite
	 * après 1940.
	 */
	private String anneeIndependance;

	/**
	 * <p>
	 * <strong>LIBCOG - Libellé utilisé dans le C.O.G.</strong>
	 * </p>
	 * 
	 * Nom en majuscules non accentuées utilisé par l'Insee dans le Code
	 * Officiel Géographique.
	 */
	private String libelleCOG;

	/**
	 * <p>
	 * <strong>LIBENR - Libellé du nom entier développé et enrichi paru au J.O.
	 * du 25 janvier 1994</strong>
	 * </p>
	 * 
	 * Nom provenant de la terminologie des noms d'États et de capitales en
	 * majuscules accentuées, issu de l'arrêté du 4 novembre 1993 paru au J.O.
	 * du 25 janvier 1994..
	 * 
	 * Pour les pays et territoires n'y figurant pas, le nom utilisé est celui
	 * du Code Officiel Géographique
	 */
	private String libelleEnrichi;

	/**
	 * <p>
	 * <strong>ANCNOM - Ancien nom du pays</strong>
	 * </p>
	 * 
	 * Ancien nom porté par le pays, en majuscules non accentuées.
	 */
	private String ancienNom;

	/**
	 * <p>
	 * <strong>CODEISO2 - Code ISO 3166 du pays sur 2 caractères</strong>
	 * </p>
	 * 
	 * Code du pays sur 2 caractères conforme à la norme internationale ISO 3166
	 * de représentation des noms de pays.
	 */
	private String codeIso2;

	/**
	 * <p>
	 * <strong>CODEISO3 - Code ISO 3166 du pays sur 3 caractères</strong>
	 * </p>
	 * 
	 * Code du pays sur 3 caractères conforme à la norme internationale ISO 3166
	 * de représentation des noms de pays.
	 */
	private String codeIso3;

	/**
	 * <p>
	 * <strong>CODENUM3 - Code ISO 3166 dupays à 3 chiffres</strong>
	 * </p>
	 * 
	 * Code du pays à 3 chiffres conforme à la norme internationale ISO 3166 de
	 * représentation des noms de pays.
	 */
	private String codeNum3;

	public PaysEtTerritoiresEtrangers() {
		super();
	}

	/**
	 * @param codePays,
	 *            le code du pays ou territoire.
	 * @param codeActualite,
	 *            le code actualité du pays ou territoire.
	 * @param codeAncienPaysRattachement,
	 *            le code de l'ancien pays de rattachement.
	 * @param codeActuelPaysRattachement,
	 *            le code du pays actuel de rattachement.
	 * @param anneeIndependance,
	 *            l'année d'indépendance.
	 * @param libelleCOG,
	 *            le libellé du Code Officiel Géographique.
	 * @param libelleEnrichi,
	 *            le libellé du nom entier développé et enrichi.
	 * @param ancienNom,
	 *            l'ancien nom du pays, en majuscules non accentuées.
	 * @param codeIso2,
	 *            le code ISO 3166 du pays sur 2 caractères.
	 * @param codeIso3,
	 *            le code ISO 3166 du pays sur 3 caractères.
	 * @param codenum3,
	 *            le code ISO 3166 du pays à 3 chiffres.
	 */
	public PaysEtTerritoiresEtrangers(String codePays, String codeActualite, String codeAncienPaysRattachement,
			String codeActuelPaysRattachement, String anneeIndependance, String libelleCOG, String libelleEnrichi,
			String ancienNom, String codeIso2, String codeIso3, String codenum3) {
		super();
		this.codePays = codePays;
		this.codeActualite = codeActualite;
		this.codeAncienPaysRattachement = codeAncienPaysRattachement;
		this.codeActuelPaysRattachement = codeActuelPaysRattachement;
		this.anneeIndependance = anneeIndependance;
		this.libelleCOG = libelleCOG;
		this.libelleEnrichi = libelleEnrichi;
		this.ancienNom = ancienNom;
		this.codeIso2 = codeIso2;
		this.codeIso3 = codeIso3;
		this.codeNum3 = codenum3;
	}

	/**
	 * @return the codePays
	 */
	public String getCodePays() {
		return codePays;
	}

	/**
	 * @param codePays
	 *            the codePays to set
	 */
	public void setCodePays(String codePays) {
		this.codePays = codePays;
	}

	/**
	 * @return the codeActualite
	 */
	public String getCodeActualite() {
		return codeActualite;
	}

	/**
	 * @param codeActualite
	 *            the codeActualite to set
	 */
	public void setCodeActualite(String codeActualite) {
		this.codeActualite = codeActualite;
	}

	/**
	 * @return the codeAncienPaysRattachement
	 */
	public String getCodeAncienPaysRattachement() {
		return codeAncienPaysRattachement;
	}

	/**
	 * @param codeAncienPaysRattachement
	 *            the codeAncienPaysRattachement to set
	 */
	public void setCodeAncienPaysRattachement(String codeAncienPaysRattachement) {
		this.codeAncienPaysRattachement = codeAncienPaysRattachement;
	}

	/**
	 * @return the codeActuelPaysRattachement
	 */
	public String getCodeActuelPaysRattachement() {
		return codeActuelPaysRattachement;
	}

	/**
	 * @param codeActuelPaysRattachement
	 *            the codeActuelPaysRattachement to set
	 */
	public void setCodeActuelPaysRattachement(String codeActuelPaysRattachement) {
		this.codeActuelPaysRattachement = codeActuelPaysRattachement;
	}

	/**
	 * @return the anneeIndependance
	 */
	public String getAnneeIndependance() {
		return anneeIndependance;
	}

	/**
	 * @param anneeIndependance
	 *            the anneeIndependance to set
	 */
	public void setAnneeIndependance(String anneeIndependance) {
		this.anneeIndependance = anneeIndependance;
	}

	/**
	 * @return the libelleCOG
	 */
	public String getLibelleCOG() {
		return libelleCOG;
	}

	/**
	 * @param libelleCOG
	 *            the libelleCOG to set
	 */
	public void setLibelleCOG(String libelleCOG) {
		this.libelleCOG = libelleCOG;
	}

	/**
	 * @return the libelleEnrichi
	 */
	public String getLibelleEnrichi() {
		return libelleEnrichi;
	}

	/**
	 * @param libelleEnrichi
	 *            the libelleEnrichi to set
	 */
	public void setLibelleEnrichi(String libelleEnrichi) {
		this.libelleEnrichi = libelleEnrichi;
	}

	/**
	 * @return the ancienNom
	 */
	public String getAncienNom() {
		return ancienNom;
	}

	/**
	 * @param ancienNom
	 *            the ancienNom to set
	 */
	public void setAncienNom(String ancienNom) {
		this.ancienNom = ancienNom;
	}

	/**
	 * @return the codeIso2
	 */
	public String getCodeIso2() {
		return codeIso2;
	}

	/**
	 * @param codeIso2
	 *            the codeIso2 to set
	 */
	public void setCodeIso2(String codeIso2) {
		this.codeIso2 = codeIso2;
	}

	/**
	 * @return the codeIso3
	 */
	public String getCodeIso3() {
		return codeIso3;
	}

	/**
	 * @param codeIso3
	 *            the codeIso3 to set
	 */
	public void setCodeIso3(String codeIso3) {
		this.codeIso3 = codeIso3;
	}

	/**
	 * @return the codenum3
	 */
	public String getCodenum3() {
		return codeNum3;
	}

	/**
	 * @param codenum3
	 *            the codenum3 to set
	 */
	public void setCodenum3(String codenum3) {
		this.codeNum3 = codenum3;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PaysEtTerritoiresEtrangers [\n\tcodePays=");
		builder.append(codePays);
		builder.append("\n\t, codeActualite=");
		builder.append(codeActualite);
		builder.append("\n\t, codeAncienPaysRattachement=");
		builder.append(codeAncienPaysRattachement);
		builder.append("\n\t, codeActuelPaysRattachement=");
		builder.append(codeActuelPaysRattachement);
		builder.append("\n\t, anneeIndependance=");
		builder.append(anneeIndependance);
		builder.append("\n\t, libelleCOG=");
		builder.append(libelleCOG);
		builder.append("\n\t, libelleEnrichi=");
		builder.append(libelleEnrichi);
		builder.append("\n\t, ancienNom=");
		builder.append(ancienNom);
		builder.append("\n\t, codeIso2=");
		builder.append(codeIso2);
		builder.append("\n\t, codeIso3=");
		builder.append(codeIso3);
		builder.append("\n\t, codenum3=");
		builder.append(codeNum3);
		builder.append("\n]");
		return builder.toString();
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
		result = prime * result + ((libelleCOG == null) ? 0 : libelleCOG.hashCode());
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
		PaysEtTerritoiresEtrangers other = (PaysEtTerritoiresEtrangers) obj;
		if (libelleCOG == null) {
			if (other.libelleCOG != null)
				return false;
		} else if (!libelleCOG.equals(other.libelleCOG))
			return false;
		return true;
	}

}
