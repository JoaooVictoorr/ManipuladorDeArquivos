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
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 *
 * @author joao.macedo
 */
public class SeparacaoDeSilabas extends SeparadorDePalavras {
 public String caminhoSilabas;
 protected File palavrasSeparadas;
 public File separadorFile;
 public File Regras() throws IOException {
       
        VerificarCaractere vv = new VerificarCaractere();
        SeparadorDePalavras sdp = new SeparadorDePalavras();
        palavrasSeparadas = new File(caminhoSilabas + "\\Separação_De_Sílabas.txt");
        palavrasSeparadas.createNewFile();
        ArrayList<String> palavras = new ArrayList<>();
        InputStreamReader reader = new InputStreamReader(new FileInputStream(separadorFile),"Windows-1252");
        BufferedReader ler = new BufferedReader(reader);
        RegrasHifenizacao rh = new RegrasHifenizacao();

        String linha = ler.readLine();
        while (linha != null) {
            if (linha.equals("")) {
                linha = ler.readLine();
            } else {
                palavras.add(linha + "*");
                linha = ler.readLine();
            }
        }
        File arquivoSilabasSeparadas = palavrasSeparadas;
        rh.Inicializar(true, arquivoSilabasSeparadas );
     
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
     return palavrasSeparadas;
      
    
    }
}
        
                    
        
        
       
        
                     
                
            
            

        
      

    

