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
        String[] test;
        Escrever escrever = new Escrever();
        SeparadorDePalavras separar = new SeparadorDePalavras();
        SeparacaoDeSilabas separacaoDeSilabas = new SeparacaoDeSilabas();
        SilabasSeparadasPorLinha silabas = new  SilabasSeparadasPorLinha();

        File arquivo = criar.CriarArquivo("C:\\Users\\joao.piccoli\\Desktop\\Teste.txt");
        //escrever.Escrever(arquivo);
        //ler.Leitura(arquivo);
        separar.Separar(arquivo);
        separacaoDeSilabas.Regras();
        silabas.Separar(arquivo);
        
 
        
        
        
        
       
        
        
        
         ler.Leitura("C:\\Users\\joao.piccoli\\Desktop\\Sílabas_Separadas_Por_Linha.txt");//"paralelepipedo"; // Tamanho do texto = 112 bits 
         test = new String[ler.retorno.size()];
         int i=0;
         for(String sílabas : ler.retorno)
         {
             test[i] = ler.retorno.get(i);
             i++;
         }
         HuffmanFunctions hf = new HuffmanFunctions();
         hf.MedirFrequencia(test);
         
         
        // Neste exemplo será considerado que teremos no máximo 256 caracteres diferentes
        // Passo 1 - Percorre o texto contando os símbolos e montando um vetor de frequências.
//        int[] charFreqs = new int[256];
//        for (String c : test.toString())
//            charFreqs[c]++;
//        
        // Criar a Árvore dos códigos para a Compactação
        HuffmanTree tree = buildTree(hf.sf);
        
        // Resultados das quantidade e o código da Compactação
        System.out.println("TABELA DE CÓDIGOS");
        System.out.println("SÍMBOLO\tQUANTIDADE\tHUFFMAN CÓDIGO");
        printCodes(tree, new StringBuffer());
//        
        // Compactar o texto
        String encode = hf.encode(tree,test);
        // Mostrar o texto Compactado
        System.out.println("\nTEXTO COMPACTADO");
        System.out.println(encode); // Tamanho de 40 bits - Economia de 72 bits
//        
        // Decodificar o texto
        System.out.println("\n\nTEXTO DECODIFICADO");
        System.out.println(decode(tree,encode));
    }

   

}
