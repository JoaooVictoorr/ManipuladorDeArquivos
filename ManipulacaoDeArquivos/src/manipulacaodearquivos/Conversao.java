/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipulacaodearquivos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joao.piccoli
 */
public class Conversao 
{
    public char[]guardar;
    public ArrayList<Integer> ConverterBinDec(char[] binario)
    {
        int limite = binario.length/8;
        guardar = binario;
        int contador = 0;
        int i = 0;
        int parada = i + 8;
        int valor = 0;
        ArrayList<Integer> formaDecimal = new ArrayList<>();
        String dados = "";
        
        
        for(i = 0; i < binario.length; i++)
        { 
            if(contador <= limite)
            {
                if(i <= parada)   
                 dados += binario[i];
                else
                { 
                  valor = TransformarEmDecimal(dados);
                  formaDecimal.add(valor);
                  dados = "";
                  dados += binario[i];
                  contador++;
                  parada = i + 8; 
                } 
            }  
            else
            {
                dados+=binario[i];
                if(i <binario.length)
                {
                  valor = TransformarEmDecimal(dados);
                  formaDecimal.add(valor);   
                }      
            }
        } 
        
//        if(limite == 8)
//        {
          valor = TransformarEmDecimal(dados);
          formaDecimal.add(valor);
        //}
        return formaDecimal;
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
    
    public char[] TransformarEmSimbolo(ArrayList<Integer> valor)
    {
        char[] simbolos = new char[valor.size()];
        int j = 0;
       for(int i:valor)
       {
          simbolos[j] = (char)i;
          j++;
       }   
       
       return simbolos;
    }
    
    public String TransformarSimbEmBin(List<String> valor)
    {
//        int i = 0;
//        int k = 0;
//        String bin ="";
//        String descompactadoInt;
//        char[] aux;
//        int[] novoValor;
//        char[] verificador;
//        ArrayList<Character> comparar = new ArrayList<>();
//        
//        for(String j : valor)
//        {
//          descompactadoInt = j;
//          aux = descompactadoInt.toCharArray();
//          novoValor = new int[aux.length];
//          for(k = 0; k < aux.length; k++)
//          {
//              novoValor[k] = (int)aux[k];
//              bin += TransformarDecEmBinario(novoValor[k]);
//          }  
//        } 
//        
//        return bin;
        
        //SOLUÇÃO PROVISÓRIA
        String retornar = "";
        for(char i : guardar)
         retornar += i;   
        
        return retornar; 
        //SOLUÇÃO PROVISÓRIA
    }  
    
    public String TransformarDecEmBinario(int valor)
    {
        String resultado = "";
        ArrayList<Integer> valores = new ArrayList<>();
        int resto;
        int i = 0;
        
        while(valor > 0)
        {
          resto = (valor % 2);
          valores.add(resto);
          valor = (valor / 2);
        }
       
        for(int j = valores.size()-1; j >= 0; j--)
            resultado += valores.get(j);
       
        return resultado;
    }
}
