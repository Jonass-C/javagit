package collections;

import java.util.*;

public class ListCodes {
    
    public static void main(String[] args) {
        
        System.out.println("Adicione as notas que você tirou no semestre 25.1: \n");
        
        List<Double> notas = new ArrayList<>();
        
        notas.add(8d);
        notas.add(8d);
        notas.add(7.8);
        notas.add(6d);
        
        System.out.println("Contêm 7.8? " + notas.contains(7.8));
        
        notas.add(4, 10d);
        System.out.println("Índice do 10: " + notas.indexOf(10d));
        
        System.out.println("Tamanho da lista: " + notas.size() + "\n");
        
        System.out.println("Notas: " + notas.toString());
        
        /*double media = 0.0;
        for(int i = 0; i < notas.size(); i++){
            media += notas.get(i);
            System.out.println(media);
        }
        media = media / notas.size();*/
        
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d, next;
        while(iterator.hasNext()){
            next = iterator.next();
            soma += next;
        }
        
        System.out.println("\nSoma das notas obtidas: " + soma);
        System.out.println("\nMédia das notas obtidas: " + (soma/notas.size()) + "\n");
        
        System.out.println("Menor nota: " + Collections.min(notas));
        System.out.println("Maior nota: " + Collections.max(notas) + "\n");
        
        notas.remove(3); // remove por índice
        notas.remove(10d); // remove por valor
        
        for(Double nota : notas) 
            System.out.print(nota + " ");
        
        System.out.print("\n\nRemovendo notas menores que 8: ");
        Iterator<Double> iterator1 = notas.iterator(); 
        Double next1;
        while(iterator1.hasNext()){
            next1 = iterator1.next();
            if(next1 < 8) 
                iterator1.remove();
        }
        
        for(Double nota : notas) 
            System.out.print(nota + " ");
        
        System.out.println("\n\nApagando a lista");
        notas.clear();
        System.out.print(notas + " " + notas.toString());
        System.out.println("\nA lista está vazia: " + notas.isEmpty());
    }
    
}
