package collections;

import java.util.Objects;
import java.util.*;

public class SetOrd {
    
    public static void main(String[] args) {
        
        // ordem aleatória
        System.out.println("Por ordem aleatória");
        Set<Serie> series = new HashSet<>(){{
            add(new Serie("The Middle", "Comédia", 22));
            add(new Serie("Big Bang Theory", "Comédia", 21));
            add(new Serie("The Fresh Prince of Bel-Air", "Comédia", 23));
        }};
        for (Serie serie : series)
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        
        
        // ordem de inserção
        System.out.println("\nPor ordem de inserção");
        Set<Serie> series1 = new LinkedHashSet<>(){{
            add(new Serie("The Middle", "Comédia", 22));
            add(new Serie("Big Bang Theory", "Comédia", 21));
            add(new Serie("The Fresh Prince of Bel-Air", "Comédia", 23));
        }};
        for (Serie serie : series1)
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        
        
        // ordem natural (tempo) - adiciona-se o Comparable e o CompareTo
        System.out.println("\nPor tempo");
        Set<Serie> series2 = new TreeSet<>(series1);
        for (Serie serie : series2)
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        
        
        // ordem por nome/gênero/tempoEpisódio
        System.out.println("\nPor nome / gênero / tempo de episódio");
        Set<Serie> series3 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
        series3.addAll(series);
        for (Serie serie : series3)
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
    }
    
    
    public static class Serie implements Comparable<Serie>{
        
        private String nome;
        private String genero;
        private Integer tempoEpisodio;
        
        public Serie(String nome, String genero, Integer tempoEpisodio) {
            this.nome = nome;
            this.genero = genero;
            this.tempoEpisodio = tempoEpisodio;
        }
        
        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getGenero() {
            return genero;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public Integer getTempoEpisodio() {
            return tempoEpisodio;
        }

        public void setTempoEpisodio(Integer tempoEpisodio) {
            this.tempoEpisodio = tempoEpisodio;
        }

        @Override
        public String toString() {
            return "Serie{" + "nome=" + nome + ", genero=" + genero + ", tempoEpisodio=" + tempoEpisodio + '}';
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 31 * hash + Objects.hashCode(this.nome);
            hash = 31 * hash + Objects.hashCode(this.genero);
            hash = 31 * hash + Objects.hashCode(this.tempoEpisodio);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Serie other = (Serie) obj;
            if (!Objects.equals(this.nome, other.nome)) {
                return false;
            }
            if (!Objects.equals(this.genero, other.genero)) {
                return false;
            }
            return Objects.equals(this.tempoEpisodio, other.tempoEpisodio);
        }

        @Override
        public int compareTo(Serie serie) {
            return Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
        }
        
    }
    
    public static class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie>{
        
        @Override
        public int compare(Serie s1, Serie s2){
            
            int nome = s1.getNome().compareTo(s2.getNome());
            if(nome != 0) return nome;
            
            int genero = s1.getGenero().compareTo(s2.getGenero());
            if(genero != 0) return genero;
            
            return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
        }
        
    }
    
}
