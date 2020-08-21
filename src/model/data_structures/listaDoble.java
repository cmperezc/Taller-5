package model.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class listaDoble<T extends Comparable<T>> implements Iterable<T> {

	private Nodo<T> inicio;
	private Nodo<T> fin;
	private int tama�o = 0;


	public listaDoble(){
		inicio=fin=null;
	
	}

	public int darTama�o(){
		return tama�o;
	}

	public boolean estaVacia(){
		return darTama�o() == 0;
	}
	public Nodo<T> darInicio(){
		return inicio;
	}
	public void agregarInicio(T item){
		Nodo<T> NuevoInicio = new Nodo<T> (item, inicio, null);
		if (!estaVacia()) {
			inicio.CambiarAnterior(NuevoInicio);
			inicio = NuevoInicio;
			tama�o++;
		}else{
			inicio = new Nodo<T>(item, null, null);  
			tama�o++;
		}
	}
	public void agregarfinal(T item){
		Nodo<T> Nuevofinal = new Nodo<T> (item, null, fin);
		if (!estaVacia()) {
			
			fin.cambiarSiguiente(Nuevofinal);
			fin = Nuevofinal;
			tama�o++;
		}else{
			fin = new Nodo<T>(item, null, null);  
			inicio=fin;
			tama�o++;
		}
	}

	public void eliminar(T item){
		//si esta al principio
		if (inicio.obtenerItem().equals(item)) {
			inicio = inicio.darSiguiente();
			inicio.CambiarAnterior(null);
			//si esta al final
		}else if (fin.obtenerItem().equals(item)) {
			fin = fin.darAnterior();
			fin.cambiarSiguiente(null);
			//si no esta ni al principio ni al final
		}else{
			Nodo<T> aux=inicio.darSiguiente();
			boolean f=true;
			while (aux!=null && f ) {
				if (aux.obtenerItem().equals(item)) {
					f=false;
					aux.darAnterior().cambiarSiguiente(aux.darSiguiente());
					aux.darSiguiente().CambiarAnterior(aux.darAnterior());
				}else{
					aux = aux.darSiguiente();
				}

			}
		}

	}

	public T darElemento(int i){
		Nodo<T> aux=inicio;
		int apuntador=0;
		
		while (aux!=null) {
			
			if (apuntador == i) {
				
				return aux.obtenerItem();
			}else{
				aux = aux.darSiguiente();
			}
			apuntador++;
		}
		return null;
	}
	public T darElementoPorObjeto(T i){
		Nodo<T> aux=inicio;
		
		while (aux!=null) {
			
			if (i.compareTo(aux.getItem())==0) {
				
				return aux.obtenerItem();
			}else{
				aux = aux.darSiguiente();
			}
		}
		return null;
	}
	public T darUltimoElemento(){
		if(tama�o==0){
			return null;
		}
		return fin.getItem();
	}
	
	 private class ListIterator implements Iterator<T> {
	        private Nodo<T> actual      = inicio;  // the node that is returned by next()
	        private Nodo<T> lastAccessed = null;      // the last node to be returned by prev() or next()
	                                               // reset to null upon intervening remove() or add()
	        private int index = 0;

	        public boolean hasNext()      { return index < tama�o; }
	        public boolean hasPrevious()  { return index > 0; }
	        public int previousIndex()    { return index - 1; }
	        public int nextIndex()        { return index;     }

	        public T next() {
	            if (!hasNext()) throw new NoSuchElementException();
	            lastAccessed = actual;
	            T item = actual.obtenerItem();
	            actual = actual.darSiguiente(); 
	            index++;
	            return item;
	        }

	        public T previous() {
	            if (!hasPrevious()) throw new NoSuchElementException();
	            actual = actual.darAnterior();
	            index--;
	            lastAccessed = actual;
	            return actual.obtenerItem();
	        }
	 }

	@Override
	public Iterator<T> iterator() {
		return new ListIterator();
	}
}