package collections;

import java.util.*;

public class MapCodes {
    
    public static void main(String[] args) {
        
        System.out.println("Criando dicionário com modelos e seus consumos");
        Map<String, Double> carrosPopulares = new HashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares.toString());
        
        System.out.println("\nSubstituindo consumo do Gol");
        carrosPopulares.put("gol", 15d);
        System.out.println(carrosPopulares.toString());
        
        System.out.println("\nContém o modelo Polo?: " + carrosPopulares.containsKey("Polo"));
        
        System.out.println("\nConsumo do Gol: " + carrosPopulares.get("gol"));
        
        System.out.println("\nExibindo apenas os modelos: " + carrosPopulares.keySet()); // retorna um Set
        
        System.out.println("\nExibindo apenas os consumos: " + carrosPopulares.values()); // retorna uma Collection
        
        System.out.println("\nModelo de menor consumo");
        
        Double consumoMaisEficiente = Collections.min(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        String modeloMaisEficiente = "";
        
        for(Map.Entry<String, Double> entry : entries) {
            if(entry.getValue().equals(consumoMaisEficiente)) 
                modeloMaisEficiente = entry.getKey();
        }
        System.out.println("Modelo mais eficiente: " + modeloMaisEficiente + " - " + consumoMaisEficiente);
        
        // ---
        
        System.out.println("\nModelo de maior consumo");
        
        Double consumoMenosEficiente = Collections.max(carrosPopulares.values());
        String modeloMenosEficiente = "";
        
        for(Map.Entry<String, Double> entry : entries) {
            if(entry.getValue().equals(consumoMenosEficiente)) 
                modeloMenosEficiente = entry.getKey();
        }
        System.out.println("Modelo menos eficiente: " + modeloMenosEficiente + " - " + consumoMenosEficiente);
        
        System.out.print("\nSoma dos consumos: ");
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;
        while(iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.print(soma + "\n");
        
        System.out.println("\nMédia dos consumos: " + (soma/carrosPopulares.size()) );
        
        System.out.println("\nRemovendo modelos com consumo menor que 15,6 km/l");
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while(iterator1.hasNext()){
            if(iterator1.next().equals(15.6))
                iterator1.remove();
        }
        System.out.println(carrosPopulares);
        
        System.out.println("\nExibindo na ordem de inserção");
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares1.toString());
        
        System.out.println("\nExibindo ordenado pelo modelo (alfabético)");
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2);
        
        System.out.println("\nRemovendo todos os carros");
        carrosPopulares.clear();
        carrosPopulares1.clear();
        carrosPopulares2.clear();
        System.out.println(carrosPopulares.toString() + carrosPopulares1.toString() + carrosPopulares2.toString());
        
        System.out.println("\nConferindo se estão vazios: " + carrosPopulares.isEmpty() + " - " + carrosPopulares1.isEmpty() + " - " + carrosPopulares2.isEmpty());
    }
    
}
