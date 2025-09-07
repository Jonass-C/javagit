package collections;

import java.util.*;

public class LinkedListCodes {
    
    public static void main(String[] args){
        
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        lista.add(6);
        lista.add(7);
        lista.push(8);
        
        System.out.println(lista + "\n");
        
        System.out.println(lista.removeFirst());
        System.out.println(lista.removeLast());
        System.out.println(lista + "\n");
        
        System.out.println(lista.pop());
        System.out.println(lista + "\n");
        
        System.out.println(lista.size());
        System.out.println(lista.reversed() + "\n");
        
    }
}
