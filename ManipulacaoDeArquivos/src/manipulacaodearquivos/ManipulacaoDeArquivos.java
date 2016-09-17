/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipulacaodearquivos;

import huffman.HuffmanFunctions;
import static huffman.HuffmanFunctions.buildTree;
import static huffman.HuffmanFunctions.decode;
import static huffman.HuffmanFunctions.printCodes;
import huffman.HuffmanTree;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author joao.piccoli
 */
public class ManipulacaoDeArquivos {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
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
        
        
        
        
        
        
        
        
         String test = "paralelepipedo"; // Tamanho do texto = 112 bits 
         HuffmanFunctions hf = new HuffmanFunctions();
        // Neste exemplo será considerado que teremos no máximo 256 caracteres diferentes
        // Passo 1 - Percorre o texto contando os símbolos e montando um vetor de frequências.
        int[] charFreqs = new int[256];
        for (char c : test.toCharArray())
            charFreqs[c]++;
        
        // Criar a Árvore dos códigos para a Compactação
        HuffmanTree tree = buildTree(charFreqs);
        
        // Resultados das quantidade e o código da Compactação
        System.out.println("TABELA DE CÓDIGOS");
        System.out.println("SÍMBOLO\tQUANTIDADE\tHUFFMAN CÓDIGO");
        printCodes(tree, new StringBuffer());
        
        // Compactar o texto
        String encode = hf.encode(tree,test);
        // Mostrar o texto Compactado
        System.out.println("\nTEXTO COMPACTADO");
        System.out.println(encode); // Tamanho de 40 bits - Economia de 72 bits
        
        // Decodificar o texto
        System.out.println("\n\nTEXTO DECODIFICADO");
        System.out.println(decode(tree,encode));
    }

   

}
