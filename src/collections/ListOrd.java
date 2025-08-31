package collections;

import java.util.*;

public class ListOrd {
    
    public static void main(String[] args) {
        
        List<Gato> gatos = new ArrayList<>(){{
            add(new Gato("Elton", 18, "preto"));
            add(new Gato("John", 12, "cinza escuro"));
            add(new Gato("Dog", 15, "amaral"));
        }};
        
        // ordem de inserção
        System.out.println("Por inserção\n" + gatos + "\n");
        
        // ordem aleatório
        Collections.shuffle(gatos);
        System.out.println("Aleatório\n" + gatos + "\n");
        
        // ordem natural (alfabética) - adiciona-se o Comparable e CompareTo
        Collections.sort(gatos);
        System.out.println("Alfabética\n" + gatos + "\n");
        
        // ordem por idade
        Collections.sort(gatos, new ComparatorIdade());
        gatos.sort(new ComparatorIdade());
        System.out.println("Por idade\n" + gatos + "\n");
        
        // ordem por cor
        Collections.sort(gatos, new ComparatorCor());
        gatos.sort(new ComparatorCor());
        System.out.println("Por cor\n" + gatos + "\n");
        
        // ordem por nome/cor/idade
        gatos.sort(new ComparatorNomeCorIdade());
        System.out.println(gatos + "\n");
        
    }
    
    public static class Gato implements Comparable<Gato>{
        
        private String nome;
        private Integer idade;
        private String cor;
        
        public Gato (String nome, Integer idade, String cor) {
            this.nome = nome;
            this.idade = idade;
            this.cor = cor;
        }
        
        public void setNome(String nome){
            this.nome = nome;
        }
        
        public String getNome(){
            return nome;
        }
        
        public void setIdade(Integer idade){
            this.idade = idade;
        }
        
        public Integer getIdade(){
            return idade;
        }
        
        public void setCor(String cor){
            this.cor = cor;
        }
        
        public String getCor(){
            return cor;
        }
        
        @Override
        public String toString(){
            return(String.format("{Nome: %s - idade: %d - cor: %s}", nome, idade, cor));
        }
        
        @Override
        public int compareTo(Gato gato){
            return this.getNome().compareToIgnoreCase(gato.getNome());
        }
        
    }
    
    public static class ComparatorIdade implements Comparator<Gato> {
        @Override
        public int compare(Gato g1, Gato g2){
            return Integer.compare(g1.getIdade(), g2.getIdade());
        }
    }
    
    public static class ComparatorCor implements Comparator<Gato> {
        @Override
        public int compare(Gato g1, Gato g2){
            return g1.getCor().compareToIgnoreCase(g2.getCor());
        }
    }
    
    public static class ComparatorNomeCorIdade implements Comparator<Gato>{
        @Override
        public int compare(Gato g1, Gato g2){
            
            int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
            if(nome != 0) return nome;
            
            int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
            if(cor != 0) return cor;
            
            return Integer.compare(g1.getIdade(), g2.getIdade());
        }
    }
    
}
