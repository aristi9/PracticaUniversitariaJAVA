import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FiguraTest {
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
	public void testGetNombre(){
		Figura figura = new Figura("IBBDSI", "seis");
		assertEquals("seis",figura.getNombre());
	}
	
	@Test
	public void testGetTrazos(){
		String trazos = "IBBDSI";
		LinkedList<Trazo> list = new LinkedList<Trazo>();
		assertEquals(0,list.size());
		for(int i = 0;i<trazos.length();i++){
			list.add(new Trazo(trazos.charAt(i)));
		}
		assertEquals(6,list.size());
		assertEquals(i,list.get(0));
		assertEquals(b,list.get(1));
		assertEquals(b,list.get(2));
		assertEquals(d,list.get(3));
		assertEquals(s,list.get(4));
		assertEquals(i,list.get(5));
		
	}
	
	@Test
	public void testAnadirTrazo(){
		Figura figura = new Figura("IBBDSI", "seis");
		List<Trazo> list =  figura.getTrazos();
		assertEquals(6,list.size());
		figura.anadirTrazo('D');
		assertEquals(7,list.size());
		assertEquals(d,list.get(6));
	}
	
	@Test
	public void testAnadirTrazo2(){		
		Figura figura = new Figura("IBBDSI", "seis");
		List<Trazo> list =  figura.getTrazos();
		assertEquals(6,list.size());
		figura.anadirTrazo('D', true);
		assertEquals(7,list.size());
		assertEquals(d,list.get(0));
		assertEquals(i,list.get(1));
		assertEquals(b,list.get(2));
		assertEquals(i,list.get(6));
		figura.anadirTrazo('S', false);
		assertEquals(8,list.size());
		assertEquals(d,list.get(0));
		assertEquals(i,list.get(6));
		assertEquals(s,list.get(7));
		
	}
	
	@Test
	public void testFusionar(){
		Figura figura1 = new Figura("IBBDSI", "seis");
		List<Trazo> list1 =  figura1.getTrazos();
		Figura figura2 = new Figura("DBIDBI", "tres");
		List<Trazo> list2 =  figura2.getTrazos();
		assertEquals(6,list1.size());
		assertEquals(6,list2.size());
		figura1.fusionar(figura2);
		assertEquals(12,list1.size());
		assertEquals(i,list1.get(5));
		assertEquals(d,list1.get(6));
		assertEquals(b,list1.get(7));
		assertEquals(i,list1.get(8));
		assertEquals(d,list1.get(9));
		assertEquals(b,list1.get(10));
		assertEquals(i,list1.get(11));
	}
	
	@Test
	public void testInsertar(){
		int pos = 3;
		Figura figura1 = new Figura("IBBDSI", "seis");
		List<Trazo> list1 =  figura1.getTrazos();
		Figura figura2 = new Figura("DBIDBI", "tres");
		List<Trazo> list2 =  figura2.getTrazos();
		assertEquals(6,list1.size());
		assertEquals(6,list2.size());
		figura1.insertar(pos, figura2);
		assertEquals(12,list1.size());
		assertEquals(d,list1.get(3));
		assertEquals(b,list1.get(4));
		assertEquals(i,list1.get(5));
		assertEquals(d,list1.get(6));
		assertEquals(b,list1.get(7));
		assertEquals(i,list1.get(8));
		assertEquals(d,list1.get(9));
		assertEquals(s,list1.get(10));
		assertEquals(i,list1.get(11));
	}
	
	@Test
	public void testEliminarDesdeUltimoTrazo(){
		Character nuevoCaracter = 'D';
		Figura figura = new Figura("IBBDSI", "seis");
		List<Trazo> list1 =  figura.getTrazos();
		assertEquals(6,list1.size());
		figura.eliminarDesdeUltimoTrazo(nuevoCaracter);
		assertEquals(4,list1.size());
		assertEquals(i,list1.get(0));
		assertEquals(b,list1.get(1));
		assertEquals(b,list1.get(2));
	}
	
	@Test
	public void testSustituir(){
		Character nuevoCaracter = 'D';
		String nuevaLista = "IBD";
		Figura figura = new Figura("IBBDSI", "seis");
		List<Trazo> lista = figura.getTrazos();
		assertEquals(6, lista.size());
		figura.sustituir(nuevoCaracter, nuevaLista);
		List<Trazo> nuevaListaTrazos = figura.getTrazos();
		assertEquals(8,nuevaListaTrazos.size());	
		assertEquals(i,nuevaListaTrazos.get(3));
		
	}
	
	@Test
	public void testGirarDerecha(){
		Figura figura = new Figura("IBBDSI", "seis");
		List<Trazo> list =  figura.getTrazos();
		assertEquals(6,list.size());
		figura.girarDerecha();
		assertEquals(6,list.size());
		assertEquals(s,list.get(0));
		assertEquals(i,list.get(1));
		assertEquals(i,list.get(2));
		assertEquals(b,list.get(3));
		assertEquals(d,list.get(4));
		assertEquals(s,list.get(5));
	}
	
	@Test
	public void testHomotecia2(){
		Figura figura = new Figura("IBBDSI", "seis");
		List<Trazo> list =  figura.getTrazos();
		assertEquals(6,list.size());
		figura.homotecia2();
		assertEquals(12,list.size());
		assertEquals(i,list.get(0));
		assertEquals(i,list.get(1));
		assertEquals(b,list.get(2));
		assertEquals(b,list.get(3));
		assertEquals(b,list.get(4));
		assertEquals(b,list.get(5));
		assertEquals(d,list.get(6));
		assertEquals(d,list.get(7));
		assertEquals(s,list.get(8));
		assertEquals(s,list.get(9));
		assertEquals(i,list.get(10));
		assertEquals(i,list.get(11));
		
	}
	
	@Test
	public void testLongitud(){
		Figura figura = new Figura("IBBDSI", "seis");
		List<Trazo> list =  figura.getTrazos();
		assertEquals(6,list.size());
	}
	
	@Test
	public void testAltura(){
		Figura figura1 = new Figura("DBDDDBIIIII", "figura1");
		Figura figura2 = new Figura("DSDBBIII", "figura2");
		Figura figura3 = new Figura("IBDDDBIIII", "figura3");
		assertEquals(2,figura1.altura());
		assertEquals(2,figura2.altura());
		assertEquals(2,figura3.altura());
		
	}
	
	@Test
	public void testAnchura(){
		Figura figura1 = new Figura("DBDDDBIIIII", "figura1");
		Figura figura2 = new Figura("DSDBBIII", "figura2");
		Figura figura3 = new Figura("IBDDDBIIII", "figura3");
		assertEquals(5,figura1.anchura());
		assertEquals(3,figura2.anchura());
		assertEquals(4,figura3.anchura());
	}
	
	@Test
	public void testSuperficie(){
		Figura figura1 = new Figura("DBDDDBIIIII", "figura1");
		Figura figura2 = new Figura("DSDBBIII", "figura2");
		Figura figura3 = new Figura("IBDDDBIIII", "figura3");
		assertEquals(10,figura1.superficie());
		assertEquals(6,figura2.superficie());
		assertEquals(8,figura3.superficie());
	}
	
	@Test
	public void testEquals(){
		Figura figura1 = new Figura("IBBDSI", "seis");
		Figura figura2 = new Figura("IBBDSI", "segundseis");
		Figura figura3 = new Figura("DBIBD", "dos");
		assertTrue(figura1.equals(figura2));
		assertFalse(figura1.equals(figura3));
	}
	
	@Test
	public void testEsHomotetica(){
		Figura figura1 = new Figura("IBBDSI", "seis");
		Figura figura2 = new Figura("IIBBBBDDSSII", "seishomotetico");
		Figura figura3 = new Figura("DBIBDI", "dos");
		Figura figura4 = new Figura("ISBBBBDDSSII", "seishomotetico");
		Figura figura5 = new Figura("IBBDSI");
		assertTrue(figura1.esHomotetica(figura2));
		assertFalse(figura1.esHomotetica(figura3));
		assertTrue(figura2.esHomotetica(figura1));
		assertFalse(figura2.esHomotetica(figura3));
		assertFalse(figura4.esHomotetica(figura5));
		assertFalse(figura5.esHomotetica(figura4));
	}
	
	@Test
	public void testEsSemejante(){
		Figura figura1 = new Figura("IBBDSI", "seis");
		Figura figura2 = new Figura("IIBBBBDDSSII", "seishomotetico");
		Figura figura3 = new Figura("DBIBD", "dos");
		Figura figura4 = new Figura("SSIIIIBBDDSS","seisgirado");
		assertTrue(figura1.esSemejante(figura2));
		assertFalse(figura1.esSemejante(figura3));
		assertTrue(figura1.esSemejante(figura4));
	}
	
	@Test
	public void testClone() throws CloneNotSupportedException{
		Figura figura1 = new Figura("IBBDSI", "seis");
		Figura figura2 = (Figura) figura1.clone();
		assertTrue(figura1.equals(figura2));
		Figura figura3 = new Figura("DBIBD", "dos");
		assertFalse(figura1.equals(figura3));
	}
	
	@Test
	public void testToSring(){
		Figura f1 = new Figura("IBBDSI", "seis");
		Figura f2 = new Figura("DBIBD", "dos");
		assertTrue(f1.toString().equals("Nombre: seis, Trazos: IBBDSI"));
		assertTrue(f2.toString().equals("Nombre: dos, Trazos: DBIBD"));	
	}
}
