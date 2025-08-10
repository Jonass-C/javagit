package javagit;

import javax.swing.JOptionPane;

public class TryCatch {

    public static void main(String[] args) {
        
        String numerador = JOptionPane.showInputDialog("Numerador: ");
        String denominador = JOptionPane.showInputDialog("Denominador: ");
        
        try{
            int resultado = dividir(Integer.parseInt(numerador), Integer.parseInt(denominador));
            JOptionPane.showMessageDialog(null, "Resultado da divisão: " + resultado);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Digite apenas números!");
        } catch (ArithmeticException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não é possível dividir por 0");
        } finally{
            System.out.println("Finally concluído.");
        }
        
        int[] numerador2 = {4, 5, 8, 10};
        int[] denominador2 = {2, 4, 0, 2, 8};
        
        for(int i = 0; i < denominador2.length; i++){
            
            try {
                if(numerador2[i] % 2 != 0){
                    throw new DivisaoNaoExataException("Divisão não exata", numerador2[i], denominador2[i]);
                }
                
                if(denominador2[i] == 0){
                    throw new DenominadorZeroException("Não é possível dividir com 0", denominador2[i]);
                }
                
                int resultado2 = numerador2[i] / denominador2[i];
                System.out.println("Resultado da divisão: " + resultado2);
            } catch (DivisaoNaoExataException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage() + " com numerador " + numerador2[i]);
            } catch (DenominadorZeroException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e){
                JOptionPane.showMessageDialog(null, "Array de tamanhos diferentes");
            }
        }
        
        System.out.println("Programa concluído");
    }
    
    public static int dividir(int a, int b){
        return(a/b);
    }
    
    public static class DivisaoNaoExataException extends Exception{
        
        int numerador;
        int denominador;
        
        public DivisaoNaoExataException(String message, int numerador, int denominador){
            super(message);
            this.numerador = numerador;
            this.denominador = denominador;
        }
    }
    
    public static class DenominadorZeroException extends Exception{
        
        int denominador;
        
        public DenominadorZeroException(String message, int denominador){
            super(message);
            this.denominador = denominador;
        }
    }
    
}


