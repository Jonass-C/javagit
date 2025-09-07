package collections;

import java.util.*;

public class Streams {
    
    public static void main(String[] args) {
        
        List<String> nomes = new ArrayList<>();
        nomes.add("Joao Martins");
        nomes.add("Joao Goncalves");
        nomes.add("Joao Moreira");
        nomes.add("Joao Roberto");
        nomes.add("Cristiano Ronaldo");
        nomes.add("Rafael Leao");
        
        System.out.println(nomes.toString());
        
        List<String> joao = nomes
                .stream()
                .filter(String -> String.startsWith("Joao"))
                .map(String::toUpperCase)
                .map(String -> String.replaceAll(" ", ""))
                .toList();
//                .reduce
//                .collect
//                .toSet, .toArray

        System.out.println("Joaos: " + joao);
        
    }
}
