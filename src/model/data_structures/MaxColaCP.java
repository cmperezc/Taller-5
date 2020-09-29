package model.data_structures;




import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Iterator;

import javax.swing.JOptionPane;

import model.data_structures.Ayuda.Nodo;



public class MaxColaCP <T  extends Comparable>{
	private Nodo<T> primero;
	private Nodo<T> ultimo;
	private int tama�o;

	public MaxColaCP(){
		primero=null;
		ultimo=null;
	}
	public MaxColaCP(T item){
		primero =new Nodo<T>(item);
		ultimo=primero;
		tama�o=1;
	}
	public int darNumElementos(){
		return tama�o;
	}
	public boolean esVacia(){
		return (tama�o==0);
	}
	public void agregar (T elem) {
		Nodo <T> newNode = new Nodo<> (elem);
		newNode.cambiarSiguiente(null);
		if (tama�o == 0) {
			primero = newNode;
			ultimo = newNode;
		}
		else {
			Nodo <T> oldFirst = primero;
			if(newNode.obtenerItem().compareTo(primero.obtenerItem())>=0){
				
				if(tama�o==1){
					Nodo <T> oldLast= ultimo;
					newNode.cambiarSiguiente(oldFirst);
					primero=newNode;
					ultimo=oldFirst;
				}else{
					primero=newNode;
					newNode.cambiarSiguiente(oldFirst);	
				}
				
			}else if(newNode.obtenerItem().compareTo(ultimo.obtenerItem())<=0){
				
					ultimo.cambiarSiguiente(newNode);
					ultimo=newNode;	
				
				
			}else{
			
			while(oldFirst.darSiguiente()!=null){
				
				if(newNode.obtenerItem().compareTo(oldFirst.darSiguiente().obtenerItem())>=0){
					newNode.cambiarSiguiente(oldFirst.darSiguiente());
					oldFirst.cambiarSiguiente(newNode);
					
					break;
					
				}
				oldFirst=oldFirst.darSiguiente();

			}
			}
			
			
		}
		
		tama�o++;
	}

	public T darMaximo(){
		return primero.obtenerItem();
	}
	
	public T sacarMax () {
		if (tama�o == 0){
			return null;
		}

		Nodo <T> oldFirst = primero;
		T elem = primero.obtenerItem();
		primero = oldFirst.darSiguiente();
		oldFirst.cambiarSiguiente(null);
		tama�o--;
		return elem;
	}
	public Nodo<T> darPrimero(){
		return primero;
	}
	
	public T get(int pos) {
		Nodo<T> actual=primero;
		if(primero!=null){
			int i=0;

			while(actual.darSiguiente()!=null && i!=pos){
				actual=actual.darSiguiente();
				i++;
			}
		}
		return actual.obtenerItem();
	}


}
