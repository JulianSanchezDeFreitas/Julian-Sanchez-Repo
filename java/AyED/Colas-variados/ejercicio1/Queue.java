package ejercicio1;
import java.util.*;

public class Queue<T> {
    private List<T> dato;

public Queue(){
   this.dato = new ArrayList<T>();
}

public void enQueue(T valor){
    this.dato.add(valor);
}
public T deQueue(){
    T elem = this.dato.getFirst();
    this.dato.removeFirst(); 
    return elem;
}

public T head(){
    return this.dato.getFirst();
}

public boolean isEmpty(){
    return this.dato.isEmpty();
    
}

public int size(){
    return this.dato.size();
}

public String toString(){
    String aux = "";
    for(int i = 0; i<dato.size(); i++){
        aux += dato.get(i)+" " ;

    }
    return aux;
}
}
