/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipulacaodearquivos;

import Interface.TelaPrincipal;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joao.piccoli
 */
public class Conversao 
{
    public int tamanhoComparar;
    public int diferenca;
    public ArrayList<Integer> ConverterBinDec(char[] binario)
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
    
    public int PuxarValor(char[]valor)
    {
       int tamanho;
       tamanho = valor.length;
       return tamanho;
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
    
    public String TransformarSimbEmBin(List<String> valor, boolean verificar)
    {
        int i = 0;
        int k;
        List<String>reajuste = valor;
        String bin ="";
        String descompactadoInt;
        char[] aux;
        int[] novoValor;
        char[] verificador;
        int compararUltima = -1;
        ArrayList<Character> comparar = new ArrayList<>();
        
        if(valor.size()>1)
        {
            for(String j : valor)
            {
             compararUltima++;
             descompactadoInt = j;
             aux = descompactadoInt.toCharArray();
             novoValor = new int[aux.length];
              for(k = 0; k < aux.length; k++)
              {  
              novoValor[k] = (int)aux[k];
              //if(k != aux.length - 1)
              if(compararUltima != valor.size()-1)
              bin += TransformarDecEmBinario(novoValor[k], true, false);
              else if(compararUltima == valor.size()-1 && k == aux.length-1)
              bin += TransformarDecEmBinario(novoValor[k], false, verificar);             
              }  
            }
            
            while(bin.toCharArray().length != tamanhoComparar)
           {
            diferenca = tamanhoComparar - bin.toCharArray().length;   
            return TransformarSimbEmBin(reajuste, true);
           }
           
           /*File teste = new File("C:\\Users\\joao.piccoli\\Desktop\\Teste.txt");
           FileWriter fw = new FileWriter(teste);
           
           BufferedWriter bw = new BufferedWriter(fw);
           
           bw.write(bin);
           bw.close();*/
           
           
           return bin;
        }
        else
        {
          for(String j : valor)
            {
             compararUltima++;
             descompactadoInt = j;
             aux = descompactadoInt.toCharArray();
             novoValor = new int[aux.length];
              for(k = 0; k < aux.length; k++)
              {  
              novoValor[k] = (int)aux[k];
              if(k != aux.length - 1)
              bin += TransformarDecEmBinario(novoValor[k], true, false);
              else
              bin += TransformarDecEmBinario(novoValor[k], false, verificar);             
              }  
            }
          while(bin.toCharArray().length != tamanhoComparar)
           {
            diferenca = tamanhoComparar - bin.toCharArray().length;   
            return TransformarSimbEmBin(reajuste, true);
           }
           return bin;
        }
        
        //SOLUÇÃO PROVISÓRIA
        //String retornar = "";
//        for(char i : guardar)
//         retornar += i;   
//        
//        return retornar; 
        //SOLUÇÃO PROVISÓRIA
    }  
   
    
    public String TransformarDecEmBinario(int valor, boolean inserir, boolean verificar)
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
          i++;
        }
       
        
        if(valores.size()<9 && inserir)
        {
           for(int j = 0; j<=8-i; j++)
             valores.add(0);
        }
        
        if(verificar)
        {
            int adicionar = diferenca;
            for(int j = 0; j<adicionar; j++)
            valores.add(0); 
        }
        

        for(int j = valores.size()-1; j >= 0; j--)
            resultado += valores.get(j);
        return resultado;
    }
}
