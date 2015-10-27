import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TrazoTest {

	Trazo d, b, i, s;
	@Before
	public void setUp() throws Exception {
		d = new Trazo('D');
		b = new Trazo('B');
		i = new Trazo('I');
		s = new Trazo('S');
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTrazo() {
		assertNotNull(new Trazo('B'));
		try{
			Trazo t = new Trazo('X');
			fail("No se debe permitir trazos que no sean D, B, I — S");
		}
		catch(IllegalArgumentException ex){
			assertTrue(true);
		}
	}
	
	@Test
	public void testGetOrientacion() {
		assertEquals('D', d.getOrientacion());
		assertEquals('B', b.getOrientacion());
		//Introducido
		assertEquals('I', i.getOrientacion());
		assertEquals('S', s.getOrientacion());
	}	

	@Test
	public void testEqualsObject() {
		Trazo t = new Trazo('D');
		assertTrue(d.equals(t));
		assertTrue(t.equals(d));
		assertFalse(b.equals(t));
		assertFalse(i.equals(t));
		//Introducido
		assertFalse(s.equals(t));
	}

	@Test
	public void testGirarDerecha() {
		Trazo t = new Trazo('D');
		t.girarDerecha();
		assertTrue(b.equals(t));
		t.girarDerecha();
		assertTrue(i.equals(t));
		t.girarDerecha();
		assertTrue(s.equals(t));
		t.girarDerecha();
		assertTrue(d.equals(t));
	}

	@Test
	public void testClone() throws CloneNotSupportedException {
		try {
			Trazo t = (Trazo) d.clone();
			assertNotSame(t,d);
			assertEquals('D', t.getOrientacion());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			throw  e;	
		}
	}


	@Test
	public void testToString() {
		assertEquals("D", d.toString());
		assertEquals("B", b.toString());
		assertEquals("I", i.toString());
		assertEquals("S", s.toString());
		
	}

}
