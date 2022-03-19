package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {

	AutoGuma autoGuma;

	@BeforeEach
	void setUp() throws Exception {
		autoGuma = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		autoGuma = new AutoGuma();
	}

	@Test
	void testAutoGuma() {
		autoGuma = new AutoGuma();
		assertNotNull(autoGuma);
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		autoGuma = new AutoGuma("Bridgestone", 20, 300, 50);

		assertNotNull(autoGuma);
		assertEquals("Bridgestone", autoGuma.getMarkaModel());
		assertEquals(20, autoGuma.getPrecnik());
		assertEquals(300, autoGuma.getSirina());
		assertEquals(50, autoGuma.getVisina());
	}

	@Test
	void testSetMarkaModel() {
		autoGuma.setMarkaModel("Bridgestone");
		assertEquals("Bridgestone", autoGuma.getMarkaModel());
	}

	@Test
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class, () -> autoGuma.setMarkaModel(null));
	}

	@Test
	void testSetMarkaModelKratakString() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> autoGuma.setMarkaModel("B"));
		assertThrows(java.lang.IllegalArgumentException.class, () -> autoGuma.setMarkaModel("Br"));
	}

	@Test
	void testSetMarkaModelPrazanString() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> autoGuma.setMarkaModel(""));
	}

	@Test
	void testSetPrecnik() {
		autoGuma.setPrecnik(15);
		assertEquals(15, autoGuma.getPrecnik());
	}

	@ParameterizedTest
	@CsvSource({ "-5", "10", "12", "23", "26", "30", "300", })

	void testSetPrecnikVanOpsega(int precnik) {
		assertThrows(java.lang.IllegalArgumentException.class, () -> autoGuma.setPrecnik(precnik));
	}

	@Test
	void testSetSirina() {
		autoGuma.setSirina(300);
		assertEquals(300, autoGuma.getSirina());
	}

	@ParameterizedTest
	@CsvSource({ "77", "132", "9", "113", "-56", "357", "555", "5050", })

	void testSetSirinaVanOpsega(int sirina) {
		assertThrows(java.lang.IllegalArgumentException.class, () -> autoGuma.setSirina(sirina));
	}

	@Test
	void testSetVisina() {
		autoGuma.setVisina(50);
		assertEquals(50, autoGuma.getVisina());
	}

	@ParameterizedTest
	@CsvSource({ "5", "10", "-12", "24", "96", "100", "150", "1000", })
	void testSetVisinaVanOpsega(int visina) {

		assertThrows(java.lang.IllegalArgumentException.class, () -> autoGuma.setVisina(visina));
	}

	@ParameterizedTest
	@CsvSource({ "25", "95", })

	void testSetVisinaGranice(int visina) {

		autoGuma.setVisina(visina);
		assertEquals(visina, autoGuma.getVisina());
	}

	@Test
	void testToString() {
		autoGuma.setMarkaModel("Bridgestone");
		autoGuma.setPrecnik(20);
		autoGuma.setSirina(300);
		autoGuma.setVisina(50);

		String naziv = autoGuma.toString();

		assertTrue(naziv.contains("Bridgestone"));
		assertTrue(naziv.contains("300"));
		assertTrue(naziv.contains("20"));
		assertTrue(naziv.contains("50"));

	}

	@ParameterizedTest
	@CsvSource({ "Bridgestone, 20, 300, 50, Bridgestone, 20, 300, 50, true",
			"Bridgestone, 20, 300, 50, Michelin, 20, 300, 50, false",
			"Bridgestone, 20, 300, 50, Bridgestone, 21, 300, 50, false",
			"Bridgestone, 20, 300, 50, Bridgestone, 20, 320, 50, false",
			"Bridgestone, 20, 300, 50, Bridgestone, 20, 300, 80, false",
			"Bridgestone, 21, 300, 50, Bridgestone, 21, 320, 50, false",
			"Bridgestone, 21, 300, 50, Bridgestone, 21, 300, 80, false",
			"Bridgestone, 20, 300, 50, Bridgestone, 20, 320, 50, false",
			"Bridgestone, 20, 300, 50, Bridgestone, 20, 300, 80, false",
			"Bridgestone, 20, 300, 50, Bridgestone, 21, 320, 80, false", })

	void testEqualsObject(String markaModel1, int precnik1, int sirina1, int visina1, String markaModel2, int precnik2,
			int sirina2, int visina2, boolean equals) {

		autoGuma.setMarkaModel(markaModel1);
		autoGuma.setPrecnik(precnik1);
		autoGuma.setSirina(sirina1);
		autoGuma.setVisina(visina1);

		AutoGuma autoGuma1 = new AutoGuma();
		autoGuma1.setMarkaModel(markaModel2);
		autoGuma1.setPrecnik(precnik2);
		autoGuma1.setSirina(sirina2);
		autoGuma1.setVisina(visina2);

		assertEquals(equals, autoGuma.equals(autoGuma1));
	}
}
