/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipulacaodearquivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author joao.piccoli
 */
public class Escrever {

    public File EscreverChar(char[] conteudo, String caminho) throws IOException {
       Criar c = new Criar();
       File arquivo = c.CriarArquivo(caminho);

        OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(arquivo),"UTF-8");
        try (BufferedWriter escrever = new BufferedWriter(write)) {
            for(char i: conteudo)
             escrever.write(i);
        }

        return arquivo;
    }
    
    public File EscreverString(String conteudo, String caminho) throws IOException {
       Criar c = new Criar();
       File arquivo = c.CriarArquivo(caminho);

        OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(arquivo),"UTF-8");
        try (BufferedWriter escrever = new BufferedWriter(write)) {
             escrever.write(conteudo);
        }

        return arquivo;
    }

}
