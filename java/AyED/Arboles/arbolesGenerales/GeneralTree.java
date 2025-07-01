package arbolesGenerales;

import java.util.LinkedList;
import java.util.List;

import ejercicio1.Queue;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {	 
		if (this.isLeaf()) return 0;
		List<GeneralTree<T>> children  =  this.getChildren();
		int maxAltura = 0;
		for (GeneralTree<T> child : children){
			int alturaHijo = child.altura();
			if (alturaHijo>maxAltura){
				maxAltura = alturaHijo;
			}
		}
		return maxAltura + 1 ;
		
	}
	
	public int nivel(T dato){
		Queue<GeneralTree<T>> cola = new Queue<>();
		cola.enQueue(this);
		cola.enQueue(null);
		int nivel = 0;
		while(!cola.isEmpty()){
			GeneralTree<T> arbol = cola.deQueue();
			if (arbol != null){
				if (arbol.getData() == dato) return nivel;
				for(GeneralTree<T> child : arbol.getChildren()){
					cola.enQueue(child);
				}
			} else {
				if (!cola.isEmpty()){
					nivel++;
					cola.enQueue(null);

				}
			}
		}
		return -1;
	  }

	public int ancho(){
		
		return 0;
	}
}