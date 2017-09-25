package nc.dva.examples.hystrix;

public class Country {

	private String codeIso3;
	private String libelleCOG;

	/**
	 * @param codeIso3
	 * @param libelleCOG
	 */
	public Country(String codeIso3, String libelleCOG) {
		super();
		this.codeIso3 = codeIso3;
		this.libelleCOG = libelleCOG;
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

}
