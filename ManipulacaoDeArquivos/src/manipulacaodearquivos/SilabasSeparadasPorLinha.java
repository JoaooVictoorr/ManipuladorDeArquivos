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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 *
 * @author joao.piccoli
 */
public class SilabasSeparadasPorLinha extends SeparacaoDeSilabas{
    
        protected File separador = new File("C:\\Users\\João Victor\\Desktop\\Sílabas_Separadas_Por_Linha.txt");
        
    public void Separar(File arquivo) throws IOException {

        String[] separar;
        separador.createNewFile();
        Ler leitura = new Ler();
        InputStreamReader read = new InputStreamReader(new FileInputStream(palavrasSeparadas),"Windows-1252");
        OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(separador),"Windows-1252");
        BufferedWriter escrever = new BufferedWriter(write);
        BufferedReader ler = new BufferedReader(read);
        ArrayList<String> armazenar = new ArrayList<>();
        String linha = ler.readLine();
       
        while (linha != null) {
             if (linha.equals("")) {
                linha = ler.readLine();
            } else {
               armazenar.add(linha);
               System.out.println(armazenar);
                linha = ler.readLine();
            }
        }
        for (int i = 0; i < armazenar.size(); i++) {
            for (int j = 0; i < armazenar.size(); i++) {
                separar = armazenar.get(i).split("-");
                for (String lista : separar) 
                    {
                         escrever.write(lista + "\r\n");
                    }
                }
         escrever.close();
            } 
    }
  
}
