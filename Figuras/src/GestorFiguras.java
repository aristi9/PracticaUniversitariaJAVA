
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GestorFiguras {
	//Representacion de una coleccion de figuras
	Hashtable<String,Figura> figuras;
	
	/**
	 * Crea un gestor de figuras vacia
	 */
	public GestorFiguras(){
		figuras = new Hashtable<String,Figura>();
	}
	
	/**
	 * Anade una nueva figura
	 * @param figura
	 */
	public void guardar(Figura figura){
		figuras.put(figura.getNombre(), figura);
	}
	
	/**
	 * Devuelve la figura que tiene el nombre 'nombre' y si no null
	 * @param nombre, el nombre de una figura
	 * @return la figura
	 */
	public Figura recuperar(String nombre){
		return figuras.get(nombre);
	}
	
	/**
	 * Cambia la figura que tiene el mismo nombre que la figura dada
	 * @param figura, una figura 
	 */
	public void cambiar(Figura figura){
		figuras.put(figura.getNombre(), figura);
	}
	
	/**
	 * Verifica si existe o no una figura con el mismo nombre que el parametro 'nombre'
	 * @param nombre, el nombre de una figura
	 * @return devuelve True si existe y False, en caso contrario
	 */
	public boolean existe(String nombre){
		if(figuras.get(nombre) == null){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * Devuelve una lista de figuras que tengan los mismos nombres que contiene el array 'nombres'
	 * @param nombres, una lista de nombres
	 * @return una lista de figuras
	 */
	public List<Figura> recuperarLista(String[] nombres){
		List<Figura> lista = new LinkedList<Figura>();
		for(String nombre: nombres){
			lista.add(figuras.get(nombre));
		}
		return lista;
	}

	/**
	 * Devuelve una lista de figuras que son iguales a la figura dada 
	 * @param figura, una figura
	 * @return una lista de figuras
	 */
	public List<Figura> recuperarIguales(Figura figura){
		//HECHO
		List<Figura> lista = new LinkedList<Figura>();
		for(Figura fig: figuras.values()){
			if(fig.equals(figura)){
				lista.add(fig);
			}
		}
		return lista;
	}

	/**
	 * Devuelve una lista de figuras que son semejantes a la figura dada 
	 * @param figura, una figura
	 * @return una lista de figuras
	 */
	public List<Figura> recuperarSemejantes(Figura figura){
		List<Figura> lista = new LinkedList<Figura>();
		for(Figura fig: figuras.values()){
			if(figura.esSemejante(fig)){
				lista.add(fig);
			}
		}
		return lista;
	}
}
