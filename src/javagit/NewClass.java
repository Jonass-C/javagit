package javagit;

import java.util.Scanner;
import java.util.Date;

public class NewClass {
    
    public static void main(String[] args){
        
        // DECLARAÇÃO DE OBJETO
        SmartTV tv = new SmartTV();
        
        System.out.println("STATUS TELEVISÃO");
        System.out.println("Ligada? " + tv.ligada);
        System.out.println("Canal: " + tv.canal);
        System.out.println("Volume: " + tv.volume);
        
        System.out.println("\nNOVO STATUS TELEVISÃO");
        tv.ligarTV();
        System.out.println("Ligada? " + tv.ligada);
        tv.aumentarVolume();
        System.out.println("Novo Volume: " + tv.volume);
        tv.mudarCanal();
        System.out.println("Novo Canal: " + tv.canal);
        tv.mudarCanal(7);
        System.out.println("Novo Canal: " + tv.canal);
        
        Scanner sc = new Scanner(System.in);
        
        Calculadora calc = new Calculadora();
        
        System.out.format("Soma: %d\nSubtração: %d\nMultiplicação: %d\nDivisão: %.2f\n", calc.soma(7,2), calc.subtracao(7,2), calc.multiplicacao(7,2), calc.divisao(7,2));
        
        cumprimentar(19); cumprimentar(20); cumprimentar(3); cumprimentar(12);
        
        calcularEmprestimoFinal(1000, 3);
        
        System.out.println("A área é: " + calcularArea(3));
        System.out.println("A área é: " + calcularArea(5, 5));
        System.out.println("A área é: " + calcularArea(7, 8, 9));
        
        Carro carro = new Carro();
        
        carro.setCapacidadeTanque(10);
        
        carro.calcularValorTanque(carro.getCapacidadeTanque());
        
        Funcionario func = new Funcionario();
        
        // upcast
        Funcionario gerente = new Gerente();
        Funcionario vendedor = new Vendedor();
        Funcionario faxineiro = new Faxineiro();
        
        // downcast
        Vendedor vendedor_ = (Vendedor) new Funcionario();
        
    }
    
    public static class SmartTV {
        
        boolean ligada = false;
        int canal = 1;
        int volume = 1;
        
        public void ligarTV(){
            ligada = true;
        }
        
        public void desligarTV(){
            ligada = false;
        }
        
        public void aumentarVolume(){
            volume++;
        }
        
        public void diminuirVolume(){
            volume--;
        }
        
        // SOBRECARGA DE MÉTODOS
        public void mudarCanal(){
            canal++;
        }
        
        // SOBRECARGA DE MÉTODOS
        public void mudarCanal(int numCanal){
            canal = numCanal;
        }
        
    }
    
    public static void cumprimentar(int hora){
        if(hora >= 0 && hora <= 24){
            if(hora > 4 && hora < 13){
                System.out.println("Bom dia!");
            }
            else if(hora > 13 && hora < 20){
                System.out.println("Boa tarde!");
            }
            else
                System.out.println("Boa noite!");
        }
        else
            System.out.println("Horário inválido.");
        
    }
    
    public static void calcularEmprestimoFinal(double valor, int parcelas){
        
        double taxaJuros = 0.0;
        
        if(parcelas == 2){
            taxaJuros = 0.05;
        }
        else if(parcelas == 3){
            taxaJuros = 0.1;
        }
        
        double valorFinal = valor + (valor * taxaJuros);
        
        System.out.println("O valor do empréstimo é: R$" + valorFinal);
        
    }
    
    public static double calcularArea(double lado){
        
        double area = lado * lado;
        
        return area;
        
    }
    
    public static double calcularArea(double base, double altura){
        
        double area = base * altura;
        
        return(area);
        
    }
    
    public static double calcularArea(double baseMaior, double baseMenor, double altura){
        
        double area = ((baseMaior + baseMenor) * altura) / 2;
        
        return(area);
        
    }
    
    public static class Carro {
        
        String cor;
        String modelo;
        int capacidadeTanque;
        
        public Carro(){
            
        }
        
        public Carro(String cor, String modelo, int capacidadeTanque){
            
        }
        
        public void setCor(String cor){
            this.cor = cor;
        }
        
        public void setModelo(String modelo){
            this.modelo = modelo;
        }
        
        public void setCapacidadeTanque(int capacidadeTanque){
            this.capacidadeTanque = capacidadeTanque;
        }
        
        public String getCor(){
            return(cor);
        }
        
        public String getModelo(){
            return(modelo);
        }
        
        public int getCapacidadeTanque(){
            return(capacidadeTanque);
        }
        
        public void calcularValorTanque(int capacidadeTanque){
            
            double valorCombustivel = 7;
            
            System.out.println("O pre~p para encher o tanque é de R$" + valorCombustivel * capacidadeTanque);
            
        }
        
        
        
    }
    
    public static class Veiculo{
        
        String marca;
        String modelo;
        int ano;
        
        public Veiculo(String marca, String modelo, int ano){
            this.marca = marca;
            this.modelo = modelo;
            this.ano = ano;
        }
    }
    
    public static class Moto extends Veiculo{
        
        int cilindradas;
        
        public Moto(String marca, String modelo, int ano, int cilindradas){
            super(marca, modelo, ano);
            this.cilindradas = cilindradas;
        }
    }
    
    public static class Caminhao extends Veiculo{
        
        int pesoCarga;
        
        public Caminhao(String marca, String modelo, int ano, int pesoCarga){
            super(marca, modelo, ano);
            this.pesoCarga = pesoCarga;
        }
    }
    
    public static class Funcionario{
        
    }
    
    public static class Gerente extends Funcionario{
        
    }
    
    public static class Vendedor extends Funcionario{
        
    }
    
    public static class Faxineiro extends Funcionario{
        
    }
    
    public static class Endereco{
        
    }
    
    public static class Disciplina{
        
    }
    
    public static class Cupom{
        
    }
    
    // Composição
    public static class Pessoa{
        Endereco endereco;
    }
    
    // Agregação
    public static class Aluno{
        Disciplina disciplina;
    }
    
    // Dependência
    public static class Compra{
        void finalizar(Cupom cupom){
        }
        
    }
    
    public static interface OperacaoMatematica{
        int soma(int x, int y);
        int subtracao(int x, int y);
        int multiplicacao(int x, int y);
        float divisao(int x, int y);
    }
    
    public static class Calculadora implements OperacaoMatematica{
        
        @Override
        public  int soma(int x, int y){
            return(x + y);
        }
        
        @Override
        public  int subtracao(int x, int y){
            return(x - y);
        }
        
        @Override
        public  int multiplicacao(int x, int y){
            return(x * y);
        }
        
        @Override
        public  float divisao(int x, int y){
            return(x / y);
        }
        
    }
    
}