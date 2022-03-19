package auto_radnja;

import java.util.List;

import auto_radnja.gume.AutoGuma;

/**
 * Interfejs koji predstavlja vulkanizersku radnju.
 *  
 * Ima metodu za dodavanje gume u vulkanizersku radnju i metodu za pronalazak gume u radnji.
 * 
 * @author Vuk Djedovic
 * @version 0.6
 */
public interface Radnja {

	/**
	 * Dodaje novu gumu u vulkanizersku radnju.
	 * 
	 * @param a Guma koja se dodaje.
	 * @throws java.lang.NullPointerException ako je uneta guma null.
	 * @throws java.lang.RuntimeException ako uneta guma vec postoji u vulkanizerskoj radnji.
	 */
	void dodajGumu(AutoGuma a);

	/**
	 * Pronalazi i vraca listu guma u radnji koji odgovaraju unetoj marki i modelu.
	 * 
	 * @param markaModel Marka i model guma koje se traze.
	 * @return 
	 * <ul>
	 * 		<li>null ako je uneta marka i model null</li>
	 *  	<li>novaLista u svim ostalim slucajevima</li>
	 * </ul>
	 */
	List<AutoGuma> pronadjiGumu(String markaModel);

	/**
	 * Vraca sve gume iz vulkanizerske radnje.
	 * 
	 * @return auto gume kao listu
	 */
	List<AutoGuma> vratiSveGume();
}
