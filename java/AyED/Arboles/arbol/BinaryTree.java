package arbol;

import ejercicio1.Queue;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
	    int suma = 0;
		if ((this.isLeaf())){
			suma++;
			}
		else {
			if (this.hasLeftChild()){
				suma += this.getLeftChild().contarHojas();
			}
			if (this.hasRightChild()){
				suma += this.getRightChild().contarHojas();
			}
		}
	return suma;
	}
			
    	 
    public BinaryTree<T> espejo(){
	   
		BinaryTree<T> Ae = new BinaryTree<T>(this.data);
	   if (this.isLeaf()){
		return Ae; 
	   } else{
			if (this.hasLeftChild()){
				Ae.addRightChild(this.getLeftChild().espejo());
			}
			if (this.hasRightChild()) {
				Ae.addLeftChild(this.getRightChild().espejo());
			}
	   }
 	   return Ae;
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		BinaryTree<T> ab = null; 
		Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>(); 
		cola.enQueue(this); 
		cola.enQueue(null); 
		int nivel = 0;
		while (!cola.isEmpty()) {
			
			ab=cola.deQueue(); 
			if (ab!= null) {
				if ((nivel>=n) & (nivel<=m)){
					System.out.print(ab.getData()); 	
				}
				if (ab.hasLeftChild()) { 
					cola.enQueue(ab.getLeftChild()); 
				} 
				if (ab.hasRightChild()) { 
					cola.enQueue(ab.getRightChild()); 
				} 
			} else if (!cola.isEmpty()) { 
				System.out.println(); 
				cola.enQueue(null); 
				nivel++;
			} 
			} 
		}
   }
		


