package test.logic;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.Nodo23;
import model.data_structures.RedBlackBST2;
public class testRedBlack {
	public RedBlackBST2<Integer, String> arbol1;
	public RedBlackBST2<Integer, String> arbol2;
	public RedBlackBST2<Integer, String> arbol3;
	@Before
	public void setUp1(){
		arbol1 = new RedBlackBST2<Integer, String>();
		for(int i=1;i<30;i+=2){
			arbol1.put(i, "Valor"+i);
		}
	
	}
	@Before
	public void setUp3(){
		arbol3 = new RedBlackBST2<Integer, String>();
	
	
	}
	@Before
	public void setUp2(){
		arbol2 = new RedBlackBST2<Integer, String>();
		arbol2.put(2, "UNO");
		arbol2.put(3, "UNO1");
		arbol2.put(5, "UNO2");
		arbol2.put(1, "UNO3");
		arbol2.put(4, "UNO4");
		arbol2.put(0, "UNO7");	
	}
	
		@Test
	public  void testAgregar1(){
		setUp1();

		assertTrue(arbol1.min().value.equals("Valor1"));

		assertTrue(arbol1.get(3).equals("Valor3"));
		assertTrue(arbol1.max().value.equals("Valor29"));
	}
	@Test
	public  void testSize(){
		setUp1();

		assertTrue(arbol1.size()==15);
		setUp2();

		assertTrue(arbol2.size()==6);

		
	}
	@Test
	public  void testGetHeight(){
		setUp1();
		Nodo23<Integer,String> in=arbol1.principal;
		int i=1;
		while(in.siguiente!=null){
			assertTrue(arbol1.getHeight(in.item)==i);
			i+=1;
			in=in.siguiente;
		}
		
		setUp2();
		
		Nodo23<Integer,String> in1=arbol2.principal;
		int j=1;
		while(in1.siguiente!=null){
			assertTrue(arbol2.getHeight(in1.item)==j);
			j+=1;
			in1=in1.siguiente;
		}		}
	@Test
	public  void testContains(){
		setUp1();
		assertTrue(!arbol1.contains( 6));
		assertTrue(arbol1.contains( 3));
		setUp2();
		assertTrue(!arbol2.contains( 10));
		assertTrue(arbol2.contains( 0));		
	}
	@Test
	public  void testHeight(){
		setUp1();
		assertTrue(arbol1.height()==3);	
		setUp2();
		
		assertTrue(arbol2.height()==2);		
	}
	@Test
	public  void testmin(){
		setUp1();

		assertTrue(arbol1.min().value.equals("Valor1"));
		setUp2();

		assertTrue(arbol2.min().value.equals("UNO7"));
	}
	@Test
	public  void testmax(){
		setUp1();

		assertTrue(arbol1.max().value.equals("Valor29"));
		setUp2();

		assertTrue(arbol2.max().value.equals("UNO2"));
	}
	@Test
	public  void testEmpty(){
		setUp1();

		assertTrue(!arbol1.isEmpty());
		setUp2();

		assertTrue(!arbol2.isEmpty());
		setUp3();

		assertTrue(arbol3.isEmpty());


		
	}
	@Test
	public  void testget(){
		setUp1();
		assertTrue(arbol1.get(21).equals("Valor21"));
		assertTrue(arbol1.get(11).equals("Valor11"));
		assertTrue(arbol1.get(12)==null);
		setUp2();
		assertTrue(arbol2.get(2).equals("UNO"));
		assertTrue(arbol2.get(5).equals("UNO2"));
		assertTrue(arbol2.get(12)==null);		

		
	}
		@Test
		public  void testAgregar2(){
			setUp2();

			assertTrue(arbol2.min().value.equals("UNO7"));
			assertTrue(arbol2.principal.value.equals("UNO1"));
			assertTrue(arbol2.get(3).equals("UNO1"));
			assertTrue(arbol2.max().value.equals("UNO2"));
		}
		@Test
		public  void testIterator(){
			setUp1();
			int h=1;
			Iterator<Integer> it=arbol1.keys().iterator();
			
			while(it.hasNext()){
				assertTrue(it.next()==h);
				h+=2;
			}
		}
		
		public  void testKeysIterator(){
			setUp1();
			int h=3;
			Iterator<Integer> it=arbol1.KeysInRange(2, 18).iterator();
			
			while(it.hasNext()){
				assertTrue(it.next()==h);
				h+=2;
			}
		}
		public  void testValueIterator(){
			setUp1();
			int h=5;
			Iterator<String> it=arbol1.valuesInRange(5, 16).iterator();
			
			while(it.hasNext()){
				assertTrue(it.next().equals("Valor"+h));
				h+=2;
			}
		}	

}
