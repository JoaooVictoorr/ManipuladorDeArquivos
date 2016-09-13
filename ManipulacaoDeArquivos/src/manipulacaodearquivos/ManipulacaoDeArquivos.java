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

/**
 *
 * @author joao.piccoli
 */
public class ManipulacaoDeArquivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        Criar criar = new Criar();
        Ler ler = new Ler();
        Escrever escrever = new Escrever();
        SeparadorDePalavras separar = new SeparadorDePalavras();
        SeparacaoDeSilabas separacaoDeSilabas = new SeparacaoDeSilabas();

        File arquivo = criar.CriarArquivo("C:\\Users\\joao.piccoli\\Desktop\\Teste.txt");
        //escrever.Escrever(arquivo);
        //ler.Leitura(arquivo);
        separar.Separar(arquivo);
        separacaoDeSilabas.Regras();
    }

}
