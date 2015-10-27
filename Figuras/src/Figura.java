

import java.util.*;

public class Figura {
	//Representa una figura mediante trazos echos a mano
	LinkedList<Trazo> trazos = new LinkedList<Trazo>();
	private String nombre;

	/**
	 * Crea una figura con los trazos indicados
	 * @param trazos, una secuencia de trazos
	 */
	public Figura(String trazos){
		for(int i = 0;i<trazos.length();i++){
			this.trazos.add(new Trazo(trazos.charAt(i)));
		}
	}
	
	/**
	 * Crea una figura con los trazos indicados y lo nombra con el nombre dado
	 * @param trazos, una secuencia de trazos 
	 * @param nombre, un nombre 
	 */
	public Figura(String trazos, String nombre){
		this(trazos);
		this.nombre=nombre;
	}
	
	/**
	 * Devuelve el nombre e la figura
	 * @return el nombre
	 */
	public String getNombre(){
		return nombre;
	}
	
	/**
	 * Devuelve una lista de trazos
	 * @return lista de trazos
	 */
	public List<Trazo> getTrazos(){
		return trazos;
	}
	
	/**
	 * A–ade un trazo al final de los trazos de la figura
	 * @param c, letra que indica un trazo
	 */
	public void anadirTrazo(char c){
		Trazo nuevoTrazo = new Trazo(c);
		trazos.add(nuevoTrazo);
	}
	
	/**
	 * A–ade un trazo al inicio o al final de los trazos de la figura
	 * @param c, letra que indica un trazo
	 * @param alInicio, si True indica al inicio y False, al final
	 */
	public void anadirTrazo(char c, boolean alInicio){
		Trazo nuevoTrazo = new Trazo(c);
		if(alInicio){
			trazos.addFirst(nuevoTrazo);
		}
		else{
			trazos.addLast(nuevoTrazo);
		}
	}
	
	/**
	 * Fusiona la figura 'f' al final de la figura actual
	 * @param f, una figura
	 */
	public void fusionar(Figura f){
		trazos.addAll(f.getTrazos());
	}
	
	/**
	 * Inserta la figura 'f' despues del trazo en la posicion 'pos'.
	 * Pre: La figura 'f' debe ser una secuencia cerrada, es decir, debe terminar en el punto donde empieza. 
	 * Porque si no repercute en la anchura y altura.
	 * @param pos, posicion entre [1..longitud(figura)]
	 * @param f, una figura
	 */
	public void insertar(int pos, Figura f){
		trazos.addAll(pos, f.getTrazos());
	}
	
	/**
	 * Elimina la secuencia de trazos desde la œltima ocurrencia del trazo de tipo 'c'
	 * @param c, un tipo de trazo
	 */
	public void eliminarDesdeUltimoTrazo(char c){
		Trazo nuevoTrazo = new Trazo(c);
		int pos = trazos.lastIndexOf(nuevoTrazo);
		if(pos == -1)
			return;
		for(int i = pos; i < trazos.size();i++){
			trazos.removeLast();
		}
	}
	
	/**
	 * Sustituye el primer trazo de tipo 'c' con los trazos dados en 'trazos'
	 * Pre: Loz trazos dados deben de formar una secuencia casi-cerrada-1, es decir, le falta un trazo para que sea cerrada y
	 * deber’a de seguir correctamente la secuencia con el siguinte trazo a 'c'. Porque si no repercute en la anchura y altura.
	 * @param c, un tipo de trazo
	 * @param trazos
	 */
	public void sustituir(char c, String trazos){
		Trazo nuevoTrazo = new Trazo(c);
		LinkedList<Trazo> nuevaLista = new LinkedList<Trazo>();
		for(int i = 0; i < trazos.length(); i++){
			nuevaLista.add(new Trazo(trazos.charAt(i)));
		}
		int pos = this.trazos.indexOf(nuevoTrazo);
		if(pos == -1)
			return;
		this.trazos.remove(pos);
		this.trazos.addAll(pos, nuevaLista);
	}
	
	/**
	 * Gira la figura 90¼ a la derecha
	 */
	public void girarDerecha(){	
		for(Trazo trazo: trazos)
			trazo.girarDerecha();
	}
	
	/**
	 * Aplica una homotecia de factor 2 a la figura
	 */
	public void homotecia2(){
		LinkedList<Trazo> temp = new LinkedList<Trazo>();
		temp.addAll(trazos);
		trazos.clear();
		for(Trazo t: temp) {
			trazos.add(t);
			trazos.add(t);
		}
	}
	
	/**
	 * Devuelve la longitud de la figura, es decir, el numero de trazos que componen la figura
	 * @return longitud de la figura
	 */
	public int longitud(){
		return trazos.size();
	}
	
	/**
	 * Devuelve la altura de la figura
	 * @return altura de la figura
	 */
	public int altura(){
		LinkedList<Trazo> trazosAltura = new LinkedList<Trazo>();
		for(int i = 0; i < trazos.size();i++){
			if(trazos.get(i).getOrientacion() == 'S' || trazos.get(i).getOrientacion() == 'B')
				trazosAltura.add(trazos.get(i));	
		}
		int contSubir = 0;
		int contBajar = 0;
		int contTotal = 0;
		int totalMayor = 0;
		int totalMenor = 0;
		int altura = 0;
		int[] iteraciones = new int[trazosAltura.size()];
		for(int i = 0;i<trazosAltura.size();i++){
			if(trazosAltura.get(i).getOrientacion() == 'S'){
				contSubir ++; 
				contTotal ++;
				iteraciones[i] = contTotal;
			}
			else{
				contBajar --;
				contTotal --;
				iteraciones[i] = contTotal;
			}
		}
		for(int i = 0;i<iteraciones.length;i++){
			if(iteraciones[i] > totalMayor)
				totalMayor = iteraciones[i];	
		}
		for(int i = 0;i<iteraciones.length;i++){
			if(iteraciones[i] < totalMenor)
				totalMenor = iteraciones[i];
		}
		altura = totalMayor + -(totalMenor);
		return altura;
	}
	
	/**
	 * Devuelve la anchura de la figura
	 * @return anchura de la figura
	 */
	public int anchura(){
		LinkedList<Trazo> trazosAltura = new LinkedList<Trazo>();
		for(int i = 0; i < trazos.size();i++){
			if(trazos.get(i).getOrientacion() == 'I' || trazos.get(i).getOrientacion() == 'D')
				trazosAltura.add(trazos.get(i));	
		}
		int contDerecha = 0;
		int contIzquierda = 0;
		int contTotal = 0;
		int totalMayorDer = 0;
		int totalMenorIzq = 0;
		int anchura = 0;
		int[] iteraciones = new int[trazosAltura.size()];
		for(int i = 0;i<trazosAltura.size();i++){
			if(trazosAltura.get(i).getOrientacion() == 'D'){
				contDerecha ++; 
				contTotal ++;
				iteraciones[i] = contTotal;
			}
			else{
				contIzquierda --;
				contTotal --;
				iteraciones[i] = contTotal;
			}
		}
		for(int i = 0;i<iteraciones.length;i++){
			if(iteraciones[i] > totalMayorDer)
				totalMayorDer = iteraciones[i];	
		}
		for(int i = 0;i<iteraciones.length;i++){
			if(iteraciones[i] < totalMenorIzq)
				totalMenorIzq = iteraciones[i];
		}
		anchura = totalMayorDer + -(totalMenorIzq);
		return anchura;
	}
	
	/**
	 * Calcula y devuelve la superficie de la figura
	 * @return superficie de la figura
	 */
	public int superficie(){
		return altura() * anchura();
	}

	/**
	 * Verifica si la figura actual y la fgura dada por parametro 'obj' son iguales
	 * @paramm obj, una figura
	 * @return True si son iguales y False, en caso contrario
	 */
	@Override
	public boolean equals(Object obj) {
		// NOTA: No se puede utilizar la comparacion entre Strings.
		Figura f = (Figura) obj;
		for(int i = 0;i<this.longitud();i++){
			if(!this.getTrazos().get(i).equals(f.getTrazos().get(i))){
				return false;
			}	
		}
		return true;
	}	

	/**
	 * Verifica si la figura actual y la figura 'f' son homoteticas. Es homotetica si las dos figuras tienen la misma orientaci—n 
	 * y aplicando una secuencia de homotecias del factor 2 a una de las figuras se obtiene la otra.
	 * @param f, una figura
	 * @return True si es homotetica y False, en caso contrario
	 */
	public boolean esHomotetica(Figura f){
		// NOTA: No se puede utilizar la comparacion entre Strings.
		if(this.longitud() * 2 != f.longitud())
			if(f.longitud() * 2 != this.longitud())
				return false;
		
		if(this.longitud() > f.longitud()){
			for(int i = 0;i < this.getTrazos().size();i+=2){
				if(!this.getTrazos().get(i).equals(f.getTrazos().get(i/2)) 
						|| !this.getTrazos().get(i+1).equals(f.getTrazos().get(i/2))){
					return false;
				}
			}			
			return true;
		}
		else{
			for(int i = 0;i < f.getTrazos().size();i+=2){
				if(!this.getTrazos().get(i/2).equals(f.getTrazos().get(i)) 
						|| !this.getTrazos().get(i/2).equals(f.getTrazos().get(i+1))){
					return false;
				}
			}
			return true;
		}
	}
	
	/**
	 * Verifica si la figura actual y la figura 'f' son semejantes. Es semejante si aplicando una secuencia de homotecias del 
	 * factor 2 y giros a la derecha a una de las figuras se obtiene la otra.
	 * @param f, una figura
	 * @return True si es semejante y False, en caso contrario
	 */
	public boolean esSemejante(Figura f){
		// NOTA: No se puede utilizar la comparacion entre Strings.
		if(this.esHomotetica(f))
			return true;
		for(int i = 0;i<3; i++){
			f.girarDerecha();
			if(this.esHomotetica(f)){
				return true;
			}
		}
		Figura temp = this;
		if(f.esHomotetica(temp))
			return true;
		for(int i = 0;i<3; i++){
			temp.girarDerecha();
			if(f.esHomotetica(temp)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Devuelve una copia exacta a la figura actual
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		String trazosLista = "";
		for(Trazo t: trazos){
			trazosLista += t.toString();
		}
		Figura f;
			f= new Figura(trazosLista,nombre);
		return (Object) f; 
	}

	/** 
	 * Devuelve la representacion de una figura de trazos como una cadena de caracteres
	 */
	@Override
	public String toString() {
		String losTrazos = "";
		for(Trazo t: trazos)
			losTrazos += t.toString();
		return "Nombre: " + nombre + ", Trazos: " + losTrazos;
	}
}
