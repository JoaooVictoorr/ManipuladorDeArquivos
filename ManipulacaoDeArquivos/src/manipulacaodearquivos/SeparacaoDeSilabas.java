/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipulacaodearquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author joao.macedo
 */
public class SeparacaoDeSilabas extends SeparadorDePalavras {
 protected File palavrasSeparadas = new File("C:\\Users\\joao.piccoli\\Desktop\\Separação_De_Sílabas.txt");
 public void Regras() throws IOException {
       
   
        VerificarVogal vv = new VerificarVogal();
        SeparadorDePalavras sdp = new SeparadorDePalavras();
        palavrasSeparadas.createNewFile();
        ArrayList<String> palavras = new ArrayList<String>();
        InputStreamReader reader = new InputStreamReader(new FileInputStream(separador),"Windows-1252");
        BufferedReader ler = new BufferedReader(reader);
        RegrasHifenizacao rh = new RegrasHifenizacao();

        String linha = ler.readLine();
        while (linha != null) {
            if (linha.equals("")) {
                linha = ler.readLine();
            } else {
                palavras.add(linha);
                linha = ler.readLine();
            }
        }
        
        rh.Inicializar(true);
     
        for (int i = 0; i <= palavras.size(); i++)
        {
            if(i == palavras.size())
            {
                rh.Close();
            }
            else
            { 
                rh.AplicarRegras(palavras.get(i));  
            }
          
            
        }     
      
    
    }
}
        
                    
        
        
       
        
                     
                
            
            

        
      

    

