/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipulacaodearquivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joao.piccoli
 */
public class Ler {
    
    public List<String> retorno = new ArrayList<>();
    
    public String Leitura(String caminho) throws IOException
    { 
          InputStreamReader reader = new InputStreamReader(new FileInputStream(caminho),"Windows-1252");
          BufferedReader ler = new BufferedReader(reader);
          String linha = ler.readLine();
          
        while (linha != null) {
            retorno.add(linha);
            System.out.println(linha);
            linha = ler.readLine();
        }
        
        return retorno.toString();
    }

}