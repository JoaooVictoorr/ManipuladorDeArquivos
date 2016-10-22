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
import java.util.ArrayList;

/**
 *
 * @author João Victor
 */
public class ManipulacaoDeArquivos {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void Classe() throws IOException {

        Criar criar = new Criar();
        Ler ler = new Ler();
        String[] test;
        Escrever escrever = new Escrever();
        SeparadorDePalavras separar = new SeparadorDePalavras();
        SeparacaoDeSilabas separacaoDeSilabas = new SeparacaoDeSilabas();
        SilabasSeparadasPorLinha silabas = new  SilabasSeparadasPorLinha();
        Conversao c = new Conversao();
        File arquivoLeitura;
        File arquivo = criar.CriarArquivo("C:\\Users\\João Victor\\Desktop\\Teste.txt");
        //escrever.Escrever(arquivo);
        //ler.Leitura(arquivo);
        separar.Separar(arquivo);
        separacaoDeSilabas.Regras();
        arquivoLeitura = silabas.Separar(arquivo);
        
 
        
        
        
        
       //INSERIR DAQUI PARA BAIXO NO SWING
        
        
        
         ler.Leitura(arquivoLeitura);//"paralelepipedo"; // Tamanho do texto = 112 bits 
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
        
       
        ArrayList<Integer> decimal = c.ConverterBinDec(encode.toCharArray());
        
        escrever.EscreverChar(c.TransformarEmSimbolo(decimal), "C:\\Users\\João Victor\\Desktop\\TextoCompactado.txt");
        Ler descompactar = new Ler();
        //descompactar.Leitura("C:\\Users\\João Victor\\Desktop\\TextoCompactado.txt");
       
        encode = c.TransformarSimbEmBin(descompactar.retorno);
        
//        
        // Decodificar o texto
        System.out.println("\n\nTEXTO DECODIFICADO");
        System.out.println(decode(tree,encode));
        String descompactado = decode(tree,encode);
        escrever.EscreverString(descompactado,"C:\\Users\\João Victor\\Desktop\\TextoDescompactado.txt");
    }

   

}
