package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;




public abstract class RadnjaTest {

protected Radnja vulkanizerskaRadnja;
	
	@Test
	void testDodajGumu() {
		AutoGuma autoGuma = new AutoGuma();
		
		autoGuma.setMarkaModel("Bridgestone");
		autoGuma.setPrecnik(20);
		autoGuma.setSirina(300);
		autoGuma.setVisina(50);
		
		vulkanizerskaRadnja.dodajGumu(autoGuma);
		assertEquals(1, vulkanizerskaRadnja.pronadjiGumu("Bridgestone").size());
		assertEquals(autoGuma, vulkanizerskaRadnja.pronadjiGumu("Bridgestone").get(0));
	}
	
	@Test
	void testDodajGumuNull() {
		
		assertThrows(java.lang.NullPointerException.class, 
						() -> vulkanizerskaRadnja.dodajGumu(null));	
	}
	@Test
	void testDodajGumuDuplikat() {
		AutoGuma autoGuma1 = new AutoGuma();
		AutoGuma autoGuma2 = new AutoGuma();
		
		autoGuma1.setMarkaModel("Bridgestone");
		autoGuma1.setPrecnik(20);
		autoGuma1.setSirina(300);
		autoGuma1.setVisina(50);
		
		autoGuma2.setMarkaModel("Bridgestone");
		autoGuma2.setPrecnik(20);
		autoGuma2.setSirina(300);
		autoGuma2.setVisina(50);
		
		vulkanizerskaRadnja.dodajGumu(autoGuma1);
		
		assertThrows(java.lang.RuntimeException.class, 
				() -> vulkanizerskaRadnja.dodajGumu(autoGuma2));	
	}

	@Test
	void testPronadjiGumu() {
		AutoGuma autoGuma1 = new AutoGuma();
		AutoGuma autoGuma2 = new AutoGuma();
		AutoGuma autoGuma3 = new AutoGuma();
		
		autoGuma1.setMarkaModel("Bridgestone");
		autoGuma1.setPrecnik(20);
		autoGuma1.setSirina(300);
		autoGuma1.setVisina(50);
		
		autoGuma2.setMarkaModel("Bridgestone");
		autoGuma2.setPrecnik(20);
		autoGuma2.setSirina(305);
		autoGuma2.setVisina(53);

		autoGuma3.setMarkaModel("Pirelli");
		autoGuma3.setPrecnik(20);
		autoGuma3.setSirina(300);
		autoGuma3.setVisina(50);
		
		vulkanizerskaRadnja.dodajGumu(autoGuma1);
		vulkanizerskaRadnja.dodajGumu(autoGuma2);
		vulkanizerskaRadnja.dodajGumu(autoGuma3);
		
		List<AutoGuma> gume = vulkanizerskaRadnja.pronadjiGumu("Bridgestone");
		assertEquals(2, gume.size());
		assertTrue(gume.contains(autoGuma1));
		assertTrue(gume.contains(autoGuma2));
	}
	
	@Test
	void testPronadjiGumuNull() {
		assertEquals(vulkanizerskaRadnja.pronadjiGumu(null), null);
	}
	
	@Test
	void testPronadjiGumuNijeUVulkanizerskojRadnji() {
		AutoGuma autoGuma = new AutoGuma();
		autoGuma.setMarkaModel("Michelin");
		autoGuma.setPrecnik(19);
		autoGuma.setSirina(219);
		autoGuma.setVisina(69);
		
		vulkanizerskaRadnja.dodajGumu(autoGuma);
		
		List<AutoGuma> gume = vulkanizerskaRadnja.pronadjiGumu("Tigar");
		
		assertTrue(gume.isEmpty());
	}
	
	@Test
	void testVratiSveKnjige() {
		AutoGuma autoGuma = new AutoGuma();
		autoGuma.setMarkaModel("Bridgestone");
		autoGuma.setPrecnik(20);
		autoGuma.setSirina(300);
		autoGuma.setVisina(50);
		
		vulkanizerskaRadnja.dodajGumu(autoGuma);
		
		List<AutoGuma> autoGume = vulkanizerskaRadnja.vratiSveGume();
		
		assertEquals(1, autoGume.size());
		assertEquals(autoGuma, autoGume.get(0));
	}
	
}
