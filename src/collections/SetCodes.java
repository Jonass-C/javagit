package collections;

import java.util.*;

public class SetCodes {
    
    public static void main(String[] args) {
        
        System.out.println("Adicionando algumas notas");
        Set<Double> notas = new HashSet<>(Arrays.asList(10d, 9.5, 9.5, 6.8, 6.7, 8d));
        System.out.println(notas.toString());
        
        System.out.println("\nContém a nota 10? : " + notas.contains(10.0));
        
        System.out.println("\nMenor nota: " + Collections.min(notas));
        System.out.println("\nMaior nota: " + Collections.max(notas));
        
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d, next;
        while(iterator.hasNext()){
            next = iterator.next();
            soma += next;
        }
        System.out.println("\nA soma das notas é: " + soma);
        System.out.println("\nA média das notas é: " + (soma/notas.size()));
        
        System.out.print("\nRemovendo nota 10: ");
        notas.remove(10d);
        System.out.print(notas + "\n");
        
        System.out.print("\nRemovendo notas menores que 8: ");
        Iterator<Double> iterator1 = notas.iterator();
        Double next1;
        while(iterator1.hasNext()){
            next1 = iterator1.next();
            if(next1 < 8.0) iterator1.remove();
        }
        System.out.print(notas + "\n");
        
        System.out.println("\nExibindo na ordem que foram adicionados");
        Set<Double> notas2 = new LinkedHashSet<>();
        notas2.add(10d);
        notas2.add(9.5);
        notas2.add(9.5);
        notas2.add(6.8);
        notas2.add(6.7);
        notas2.add(8d);
        System.out.println(notas2);
        
        System.out.print("\nExibindo notas da ordem crescente: ");
        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.print(notas3 + "\n");
        
        System.out.println("\nRemovendo todas as notas");
        notas.clear();
        notas2.clear();
        notas3.clear();
        System.out.println(notas + " " + notas2 + " " + notas3.toString());
        System.out.println("\nAs listas estão vazias: " + notas.isEmpty() + " " + notas2.isEmpty() + " " + notas3.isEmpty());
        
    }
    
}
