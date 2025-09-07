package collections;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueCodes {
    
    public static void main(String[] args) {
        
        Queue<String> pessoas = new LinkedList<>();
        pessoas.add("João");
        pessoas.add("Maria");
        pessoas.add("José");
        pessoas.add("Ana");
        
        System.out.println("Atendimento");
        System.out.println("Primeira pessoa: " + pessoas.poll());
        System.out.println("Segunda pessoa: " + pessoas.poll());
        System.out.println("Terceira pessoa: " + pessoas.poll());
        System.out.println("Quarta pessoa: " + pessoas.poll());
        System.out.println("Quinta pessoa: " + pessoas.poll());
        System.out.println(pessoas + "\n");
        
        Queue<String> pessoas2 = new LinkedList<>();
        pessoas2.add("Enzo");
        pessoas2.add("Valentina");
        pessoas2.add("Miguel");
        
        System.out.println("Atendimento infantil");
        System.out.println("Primeira criança: " + pessoas2.remove());
        System.out.println("Segunda criança: " + pessoas2.remove());
        
        System.out.println("\nFila de espera");
        System.out.println("Criança: " + pessoas2.peek());
        System.out.println(pessoas2 + "\n");
        
        System.out.println("Criança atendida: " + pessoas2.remove());
        
        try {
            System.out.println("Próxima da fila: " + pessoas2.remove()); // sem elementos = erro
        } catch (NoSuchElementException e){
            System.out.println("Próxima da fila: não há mais crianças");
        }
        
    }
}
