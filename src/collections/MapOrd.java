package collections;

import java.util.*;

public class MapOrd {
    
    public static void main(String[] args) {
        
        // ordem aleatória
        System.out.println("Por ordem aleatória");
        Map<String, Livro> livros = new HashMap<>(){{
           put("Ortlund, Dane", new Livro("Manso e Humilde", 224)); 
           put("Keller, Timothy", new Livro("Ego Transformado", 112));
           put("Tony, Cooke", new Livro("O Fim da Igreja Espectadora", 256));
           put("Dias Lopes, Hernandes", new Livro("Daniel: Um Homem Amado no Céu", 160));
        }};
        for(Map.Entry<String, Livro> livro : livros.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getTitulo());
        
        // ordem de inserção
        System.out.println("\nPor ordem de inserção");
        Map<String, Livro> livros1 = new LinkedHashMap<>(){{ 
           put("Ortlund, Dane", new Livro("Manso e Humilde", 224)); 
           put("Keller, Timothy", new Livro("Ego Transformado", 112));
           put("Tony, Cooke", new Livro("O Fim da Igreja Espectadora", 256)); 
           put("Dias Lopes, Hernandes", new Livro("Daniel: Um Homem Amado no Céu", 160));
        }};
        for(Map.Entry<String, Livro> livro : livros1.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getTitulo());
        
        // ordem alfabética autores
        System.out.println("\nPor ordem de autores");
        Map<String, Livro> livros2 = new TreeMap<>(livros1);
        for(Map.Entry<String, Livro> livro : livros2.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getTitulo());
        
        // ordem alfabética título dos livros
        System.out.println("\nPor ordem de título");
        Set<Map.Entry<String, Livro>> livros3 = new TreeSet<>(new ComparatorTitulo());
        livros3.addAll(livros.entrySet());
        for(Map.Entry<String, Livro> livro : livros3)
            System.out.println(livro.getKey() + " - " + livro.getValue().getTitulo());
        
        // ordem de número de páginas
        System.out.println("\nPor ordem de páginas");
        Set<Map.Entry<String, Livro>> livros4 = new TreeSet<>(new ComparatorPagina());
        livros4.addAll(livros.entrySet());
        for(Map.Entry<String, Livro> livro : livros4)
            System.out.println(livro.getKey() + " - " + livro.getValue().getTitulo());
        
    }
    
    public static class Livro {
        
        private String titulo;
        private Integer paginas;

        public Livro(String titulo, Integer paginas) {
            this.titulo = titulo;
            this.paginas = paginas;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public Integer getPaginas() {
            return paginas;
        }

        public void setPaginas(Integer paginas) {
            this.paginas = paginas;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 11 * hash + Objects.hashCode(this.titulo);
            hash = 11 * hash + Objects.hashCode(this.paginas);
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
            final Livro other = (Livro) obj;
            if (!Objects.equals(this.titulo, other.titulo)) {
                return false;
            }
            return Objects.equals(this.paginas, other.paginas);
        }

        @Override
        public String toString() {
            return "Livro{" + "titulo=" + titulo + ", paginas=" + paginas + '}';
        }
    }
    
    public static class ComparatorTitulo implements Comparator<Map.Entry<String, Livro>> {
        @Override
        public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
            return l1.getValue().getTitulo().compareToIgnoreCase(l2.getValue().getTitulo());
        }
    }
    
    public static class ComparatorPagina implements Comparator<Map.Entry<String, Livro>> {
        @Override
        public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
            return l1.getValue().getPaginas().compareTo(l2.getValue().getPaginas());
        }
    }
    
}
