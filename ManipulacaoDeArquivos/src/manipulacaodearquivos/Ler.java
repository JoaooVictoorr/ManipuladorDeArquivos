/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipulacaodearquivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author joao.piccoli
 */
public class Ler {
    
    //        File file = new File("C:\\Users\\joao.piccoli\\Desktop\\Teste");
//        file.mkdir();
       
    
    public File Leitura(File arquivo) throws IOException
    {
         
         arquivo.createNewFile();
          // OPÇÃO COM FILEREADER
          FileReader read = new FileReader(arquivo);
          BufferedReader ler = new BufferedReader(read);
          String linha = ler.readLine();
          
        while (linha != null) {
            System.out.println(linha);
            linha = ler.readLine();
        }
        
          return arquivo;
    }
          
         //  OPÇÃO COM SCANNER
          
//          Scanner scan = new Scanner(arquivo);
//          
//          while(scan.hasNext())
//          {
//              System.out.println(scan.nextLine());
//          }
//          return arquivo;
//    }
}
