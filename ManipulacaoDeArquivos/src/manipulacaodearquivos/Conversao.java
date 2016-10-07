/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipulacaodearquivos;

import java.util.ArrayList;

/**
 *
 * @author joao.piccoli
 */
public class Conversao 
{
    public String ConverterBinDec(char[] binario)
    {
        int limite = binario.length/8;
        int contador = 0;
        int i = 0;
        int parada = i + 8;
        int valor = 0;
        ArrayList<Integer> formaDecimal = new ArrayList<>();
        String dados = "";
        
        
        for(i = 0; i < binario.length; i++)
        { 
            if(contador != limite)
            {
                if(i != parada)   
                 dados += binario[i];
                else
                { 
                  valor = TransformarEmDecimal(dados);
                  formaDecimal.add(valor);
                  dados = "";
                  contador++;
                  parada = i + 8; 
                } 
            }  
            else
            {
                dados+=binario[i];
                if(i == binario.length-1)
                {
                  valor = TransformarEmDecimal(dados);
                  formaDecimal.add(valor);   
                }      
            }
        }
        TransformarEmBinario(formaDecimal);
        return formaDecimal.toString();
    }
    
    
    public int TransformarEmDecimal(String valor)
    {
       int potencia = 0;
       int decimal = 0;
       for(int i = valor.length() - 1; i>=0; i--)
       {
           decimal += Math.pow(2, potencia) * Character.getNumericValue(valor.charAt(i));
           potencia++;
       }
       return decimal;
    }
    
    public String TransformarEmBinario(ArrayList<Integer> valor)
    {
       String conversao = "";
       for(int i:valor)
       {
         conversao+= Integer.toBinaryString(i);
       }
       return conversao;
    }
    
    
    
    
    
    
    
    
}
