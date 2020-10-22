package model.data_structures;




public class Nodo24 <E>
{
	private Nodo24<E> siguiente;
	private E item;

	public Nodo24(E Pitem){
		siguiente=null;
		item=Pitem;
	}

	public Nodo24<E> darSiguiente(){
		return siguiente;
	}

	public void cambiarSiguiente(Nodo24<E> pSiguiente){
		siguiente=pSiguiente;
	}

	public E obtenerItem(){
		return item;
	}
	public void cambiarItem(E pItem){
		item=pItem;
	}
}