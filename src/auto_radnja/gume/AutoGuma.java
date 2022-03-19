package auto_radnja.gume;

/**
 * Klasa koja predstavlja automobilsku gumu sa njenim osnovnim karakteristikama.
 * 
 * Automobilska guma ima sledece atribute: visina, sirina i precnik kao int vrednosti kao i markaModel kao String vrednost.
 * 
 * @author Vuk Djedovic
 * @version 0.1
 */
public class AutoGuma {

	/**
	 * Marka i model gume kao String. Predefinisana vrednost ovog atributa je null.
	*/
	private String markaModel = null;
	
	/**
	 * Precnik gume kao int. Predefinisana vrednost atributa je -1.
	 */
	private int precnik = -1;
	
	/**
	 * Sirina gume kao int. Predefinisana vrednost atributa je -1.
	 */
	private int sirina = -1;
	
	/**
	 * Visina gume kao int. Predefinisana vrednost atributa je -1.
	 */
	private int visina = -1;

	/**
	 * Konstruktor koji incijalizuje objekat i postavlja vrednosti atributa objekta na njihove predefinisane vrednosti.
	 */
	public AutoGuma() {
	}

	/**
	 * Konstruktor koji inicijalizuje objekat i postavlja vrednosti njegovih atributa.
	 * 
	 * @param sirina Sirina gume kao int.
	 * @param visina Visina gume kao int.
	 * @param precnik Precnik gume kao int.
	 * @param markaModel Marka i model gume kao String.
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}

	/**
	 * Vraca marku i model gume.
	 * 
	 * @return Marka i model gume kao String.
	 */
	public String getMarkaModel() {
		return markaModel;
	}

	/**
	 * Postavlja marku i model gume na prosledjenu vrednost.
	 * 
	 * @param markaModel Marka i model gume kao String.
	 * @throws java.lang.NullPointerException ako je uneta marka i model gume null.
	 * @throws java.lang.IllegalArgumentException ako uneta marka i model ima manje od 3 karaktera.
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel == null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length() < 3)
			throw new IllegalArgumentException("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
	}

	/**
	 * Vraca precnik gume.
	 * @return Precnik gume kao int.
	 */
	public int getPrecnik() {
		return precnik;
	}

	/**
	 * Postavlja precnik gume na prosledjenu vrednost.
	 * 
	 * @param precnik Precnik gume kao int.
	 * @throws java.lang.IllegalArgumentException ako je uneti precnik manji od 13 i veci od 22.
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 && precnik > 22)
			throw new IllegalArgumentException("Precnik van opsega");
		this.precnik = precnik;
	}

	/**
	 * Vraca sirinu gume.
	 * 
	 * @return Sirina gume kao int.
	 */
	public int getSirina() {
		return sirina;
	}

	/**
	 * Postavlja sirinu gume na prosledjenu vrednost.
	 * 
	 * @param sirina Sirina gume kao int.
	 * @throws java.lang.IllegalArgumentException ako je uneta sirina manja od 135 i veca od 355.
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 && sirina > 355)
			throw new IllegalArgumentException("Sirina van opsega");
		this.sirina = sirina;
	}


	/**
	 * Vraca visinu gume.
	 * 
	 * @return Visina gume kao int. 
	 */
	public int getVisina() {
		return visina;
	}

	/**
	 * Postavlja visinu gume na prosledjenu vrednost.
	 * 
	 * @param visina Visina gume kao int.
	 * @throws java.lang.IllegalArgumentException ako je uneta visina manja od 25 ili veca od 95.
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new IllegalArgumentException("Visina van opsega");
		this.visina = visina;
	}

	/**
	 * @return String sa svim podacima o gumi.
	 */
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina="
				+ visina + "]";
	}

	/**
	 * Poredi dve automobilske gume i vraca true ako su identicne, a false ako nisu identicne.
	 * 
	 * Gume se porede po svim atributima: markaModel, precnik, visina, sirina. Da bi gume bile identicne potrebno je da svi atributi budu identicni.
	 * 
	 * @return 
	 * <ul>
	 * 		<li> true ako su oba objekta klase AutoGuma i imaju istu visinu, sirinu, precnik kao i marku i model.</li>
	 * 		<li> false u svim ostalim slucajevima</li>
	 * </ul> 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
		} else if (!markaModel.equals(other.markaModel))
			return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
	}

}
