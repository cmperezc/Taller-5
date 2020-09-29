package model.data_structures;

import java.util.Comparator;
import java.util.Iterator;

public class maxheapCP<T> implements Iterable<T> {
	T [] datos;
	int tama�o;
	private Comparator<T> comparator;
	

	public maxheapCP(int initCapacity ){
		datos = (T[]) new Object[initCapacity + 1];
		tama�o = 0;
		

	}
	public int darNumElementos(){
		return tama�o;
	}
	public boolean isEmpty() {
		return tama�o == 0;
	}
	public void agregar(T elemento){
		if(tama�o == datos.length){
			resize(datos.length*2);
		}
		datos[++tama�o]	 = elemento;
		swim(tama�o);
	}

	public T EliminarMax ()
	{
		T max = datos[1];
		exch(1, tama�o--);
		sink(1);
		datos[tama�o+1] = null;
		return max;
	}

	public T darMaximo(){
		return datos[1];
	}
	private void sink (int k)
	{
		while (2*k <= tama�o)
		{
			int j = 2*k;
			if (j < tama�o && less(j, j+1))
				j++;
			if (!less(k, j))
				break;
			exch(k, j);
			k = j;
		}
	}
	public void resize(int capacity) {
		assert capacity > tama�o;
		T[] temp = (T[]) new Object[capacity];
		for (int i = 1; i <= tama�o; i++) {
			temp[i] = datos[i];
		}
		datos = temp;
	}

	private void swim(int k) {

		{
			while (k > 1 && less(k/2, k))
			{
				exch(k, k/2);
				k = k/2;
			}
		}

	}
	private boolean less(int i, int j) {
        if (comparator == null) {
            return ((Comparable<T>) datos[i]).compareTo(datos[j]) < 0;
        }
        else {
            return comparator.compare(datos[i], datos[j]) < 0;
        }
    }


	private void exch (int i, int j)
	{
		T t = datos[i];
		datos[i] = datos[j];
		datos[j] = t;
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}

