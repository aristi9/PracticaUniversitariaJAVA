import static org.junit.Assert.*;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GestorFigurasTest {
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
	/*
	@Test
	public void testGestorFiguras() {
		fail("Not yet implemented");
	}
	*/
	@Test
	public void testGuardar() {
		Figura figura1 = new Figura("IBBDSI","seis");
		Figura figura2 = new Figura("DBIBD","dos");
		GestorFiguras gestor = new GestorFiguras();
		assertEquals(0,gestor.figuras.size());
		gestor.guardar(figura1);
		gestor.guardar(figura2);
		assertEquals(2,gestor.figuras.size());
		assertEquals("seis",gestor.figuras.get("seis").getNombre());
		assertEquals("dos",gestor.figuras.get("dos").getNombre());
	}
	
	@Test
	public void testRecuperar() {
		Figura figura1 = new Figura("IBBDSI","seis");
		Figura figura2 = new Figura("DBIBD","dos");
		GestorFiguras gestor = new GestorFiguras();
		assertEquals(0,gestor.figuras.size());
		gestor.guardar(figura1);
		gestor.guardar(figura2);
		assertEquals(2,gestor.figuras.size());
		assertEquals(figura1,gestor.recuperar("seis"));
		assertEquals(figura2,gestor.recuperar("dos"));	
	}
	
	@Test
	public void testCambiar() {
		Figura figura1 = new Figura("IBBDSI","seis");
		Figura figura2 = new Figura("DBIBD","dos");
		Figura figuraNueva = new Figura("BDS","seis");
		GestorFiguras gestor = new GestorFiguras();
		assertEquals(0,gestor.figuras.size());
		gestor.guardar(figura1);
		gestor.guardar(figura2);
		assertEquals(2,gestor.figuras.size());
		assertEquals(figura1,gestor.figuras.get("seis"));
		gestor.cambiar(figuraNueva);
		assertEquals(2,gestor.figuras.size());
		assertEquals(figuraNueva,gestor.figuras.get("seis"));
	}
	
	@Test
	public void testExiste() {
		Figura figura1 = new Figura("IBBDSI","seis");
		Figura figura2 = new Figura("DBIBD","dos");
		GestorFiguras gestor = new GestorFiguras();
		assertEquals(0,gestor.figuras.size());
		gestor.guardar(figura1);
		gestor.guardar(figura2);
		assertEquals(2,gestor.figuras.size());
		assertEquals(figura1,gestor.figuras.get("seis"));
		assertTrue(gestor.existe("seis"));
		assertTrue(gestor.existe("dos"));
		assertFalse(gestor.existe("diez"));
	}
	
	@Test
	public void testRecuperarLista() {
		String[] listaFiguras = {"seis","dos"};
		Figura figura1 = new Figura("IBBDSI","seis");
		Figura figura2 = new Figura("DBIBD","dos");
		Figura figura3 = new Figura("BDS","u");
		List<Figura> lista = new LinkedList<Figura>();
		GestorFiguras gestor = new GestorFiguras();
		assertEquals(0,gestor.figuras.size());
		assertEquals(0,lista.size());
		gestor.guardar(figura1);
		gestor.guardar(figura2);
		gestor.guardar(figura3);
		lista.addAll(gestor.recuperarLista(listaFiguras));
		assertEquals(2,lista.size());
		assertEquals("seis",lista.get(0).getNombre());
		assertEquals("dos",lista.get(1).getNombre());
	}
	
	@Test
	public void testRecuperarIguales() {
		Figura figura1 = new Figura("IBBDSI","seis");
		Figura figura2 = new Figura("IBBDSI","otroseis");
		Figura figura3 = new Figura("DBIBD","dos");
		Figura figura4 = new Figura("IBBDSI","tercerseis");
		Figura figura5 = new Figura("BDS","u");
		Figura figuraReferencia = new Figura("IBBDSI","elseis");
		GestorFiguras gestor = new GestorFiguras();
		List<Figura> lista = new LinkedList<Figura>();
		assertEquals(0,gestor.figuras.size());
		assertEquals(0,lista.size());
		gestor.guardar(figura1);
		gestor.guardar(figura2);
		gestor.guardar(figura3);
		gestor.guardar(figura4);
		gestor.guardar(figura5);
		assertEquals(5,gestor.figuras.size());
		lista.addAll(gestor.recuperarIguales(figuraReferencia));
		assertEquals(3,lista.size());
	}
	
	@Test
	public void testRecuperarSemejantes() {
		Figura figura1 = new Figura("IIBBBBDDSSII","seishomotecia");
		Figura figura2 = new Figura("SSIIIIBBDDSS","seisgirado");
		Figura figura3 = new Figura("BDS","u");
		Figura figuraReferencia = new Figura("IBBDSI","seis");
		GestorFiguras gestor = new GestorFiguras();
		List<Figura> lista = new LinkedList<Figura>();
		assertEquals(0,gestor.figuras.size());
		assertEquals(0,lista.size());
		gestor.guardar(figura1);
		gestor.guardar(figura2);
		gestor.guardar(figura3);
		assertEquals(3,gestor.figuras.size());
		lista.addAll(gestor.recuperarSemejantes(figuraReferencia));
		assertEquals(2,lista.size());		
	}
}
