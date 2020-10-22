package model.data_structures;




import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.swing.JOptionPane;


import model.data_structures.Ayuda.ListCola;



public class Queue23 <T>  implements ListCola<T>{
	private Nodo24<T> primero;
	private Nodo24<T> ultimo;
	private int tama�o;

	public Queue23(){
		primero=null;
		ultimo=null;
	}
	public Queue23(T item){
		primero =new Nodo24<T>(item);
		ultimo=primero;
		tama�o=1;
	}
	public void enQueue23 (T elem) {
		Nodo24 <T> newNode = new Nodo24<> (elem);
		if (tama�o == 0) {
			primero = newNode;
			ultimo = newNode;
		}
		else {
			Nodo24 <T> oldLast = ultimo;
			oldLast.cambiarSiguiente(newNode);
			ultimo = newNode;
		}
		tama�o++;
	}

	
	   public Iterator<T> iterator()  {
	        return new LinkedIterator(primero);  
	    }

	    // an iterator, doesn't implement remove() since it's optional
	    private class LinkedIterator implements Iterator<T> {
	        private Nodo24<T> current;

	        public LinkedIterator(Nodo24<T> first) {
	            current = first;
	        }

	        public boolean hasNext()  { return current != null;                     }
	        public void remove()      { throw new UnsupportedOperationException();  }

	        public T next() {
	            if (!hasNext()) throw new NoSuchElementException();
	            T item = current.obtenerItem();
	            current = current.darSiguiente(); 
	            return item;
	        }
	    }

	public T deQueue23 () {
		if (tama�o == 0){
		}

		Nodo24 <T> oldFirst = primero;
		T elem = primero.obtenerItem();
		primero = oldFirst.darSiguiente();
		oldFirst.cambiarSiguiente(null);
		tama�o--;
		return elem;
	}

	public T get(int pos) {
		Nodo24<T> actual=primero;
		if(primero!=null){
			int i=0;

			while(actual.darSiguiente()!=null && i!=pos){
				actual=actual.darSiguiente();
				i++;
			}
		}
		return actual.obtenerItem();
	}

	@Override
	public int size() {

		// TODO Auto-generated method stub
		return tama�o;
	}
	@Override
	public boolean isEmpty() {

		return (primero==null);
	}
	@Override
	public void enqueue(T elem) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		return null;
	}
}