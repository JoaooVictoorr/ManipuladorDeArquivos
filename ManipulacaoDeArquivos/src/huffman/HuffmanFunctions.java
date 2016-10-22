/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import manipulacaodearquivos.SilabaFreq;
import manipulacaodearquivos.TransferirPalavra;

/**
 *
 * @author joao.piccoli
 */
public class HuffmanFunctions {
    
    public SilabaFreq[] sf;
    
      public static HuffmanTree buildTree(SilabaFreq[] charFreqs) {
    	// Cria uma Fila de Prioridade 
    	// A Fila será criado pela ordem de frequência da letra no texto
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<HuffmanTree>();
        // Criar as Folhas da Árvore para cada letra 
        for (int i = 0; i < charFreqs.length; i++){
            
                trees.offer(new HuffmanLeaf(charFreqs[i].frequencia, charFreqs[i].silaba)); // Inser os elementos, nó folha, na fila de prioridade
            
        }
        
        // Percorre todos os elementos da fila
        // Criando a árvore binária de baixo para cima
        while (trees.size() > 1) {
            // Pega os dois nós com menor frequência
            HuffmanTree a = trees.poll(); // poll - Retorna o próximo nó da Fila ou NULL se não tem mais
            HuffmanTree b = trees.poll(); // poll - Retorna o próximo nó da Fila ou NULL se não tem mais
 
            // Criar os nós da árvore binária
            trees.offer(new HuffmanNode(a, b)); 
        }
        // Retorna o primeiro nó da árvore
        return trees.poll();
    }
      
        public String encode(HuffmanTree tree, String[] encode){
    	assert tree != null;
    	
    	String encodeText = "";
        for (String c : encode){
        	encodeText+=(getCodes(tree, new StringBuffer(),c));
        }
    	return encodeText; // Retorna o texto Compactado
    }
    
    
    /* DECODIFICAR a string
     *     Parâmetros de Entrada: tree - Raiz da Árvore de compactação
     *     						  encode - Texto Compactado
     *     Parâmetros de Saída: decodeText- Texto decodificado
    */
    public static String decode(HuffmanTree tree, String encode) {
    	assert tree != null;
    	
    	String decodeText="";
    	HuffmanNode node = (HuffmanNode)tree;
    	for (char code : encode.toCharArray()){
    		if (code == '0'){ // Quando for igual a 0 é o Lado Esquerdo
    		    if (node.left instanceof HuffmanLeaf) { 
    		    	decodeText += ((HuffmanLeaf)node.left).value; // Retorna o valor do nó folha, pelo lado Esquerdo  
	                node = (HuffmanNode)tree; // Retorna para a Raíz da árvore
	    		}else{
	    			node = (HuffmanNode) node.left; // Continua percorrendo a árvore pelo lado Esquerdo 
	    		}
    		}else if (code == '1'){ // Quando for igual a 1 é o Lado Direito
    		    if (node.right instanceof HuffmanLeaf) {
    		    	decodeText += ((HuffmanLeaf)node.right).value; //Retorna o valor do nó folha, pelo lado Direito
	                node = (HuffmanNode)tree; // Retorna para a Raíz da árvore
	    		}else{
	    			node = (HuffmanNode) node.right; // Continua percorrendo a árvore pelo lado Direito
	    		}
    		}
    	} // End for
    	return decodeText; // Retorna o texto Decodificado
    }    
    
    /* 
     * Método para percorrer a Árvore e mostra a tabela de compactação
     *     Parâmetros de Entrada: tree - Raiz da Árvore de compactação
     *     						  prefix - texto codificado com 0 e/ou 1
     */
    public static void printCodes(HuffmanTree tree, StringBuffer prefix) {
        assert tree != null;
        
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf)tree;
            
            // Imprime na tela a Lista
            System.out.println(leaf.value + "\t" + leaf.frequency + "\t\t" + prefix);
 
        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode)tree;
 
            // traverse left
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length()-1);
 
            // traverse right
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
    
    /* 
     * Método para retornar o código compactado de uma letra (w)
     *     Parâmetros de Entrada: tree - Raiz da Árvore de compactação
     *     						  prefix - texto codificado com 0 e/ou 1
     *     						  w - Letra
     *     Parâmetros de Saída: prefix- Letra codificada
     */
    public static String getCodes(HuffmanTree tree, StringBuffer prefix, String w) {
        assert tree != null;
        
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf)tree;
            
            // Retorna o texto compactado da letra
            if (leaf.value.equals(w)){
            	return prefix.toString();
            }
            
        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode)tree;
 
            // Percorre a esquerda
            prefix.append('0');
            String left = getCodes(node.left, prefix, w);
            prefix.deleteCharAt(prefix.length()-1);
 
            // Percorre a direita
            prefix.append('1');
            String right = getCodes(node.right, prefix,w);
            prefix.deleteCharAt(prefix.length()-1);
            
            if (left==null) return right; else return left;
        }
		return null;
    }
    
    public SilabaFreq[] MedirFrequencia(String[] silaba)
    {
       TransferirPalavra tp = new TransferirPalavra();
       String[] comparar = new String[silaba.length];
       sf = new SilabaFreq[silaba.length];
       int j = 0;
       int i = 0;
       for(String verificar : silaba)
       for(String testar : comparar)
       {
           if(testar == null && tp.Contem(verificar, sf))
           {
               sf[i] = new SilabaFreq();
               sf[i].silaba = verificar;
               sf[i].frequencia ++; 
               comparar[j] = verificar;
               i++;
               j++;
               break;
           }
           else if(verificar.equals(testar))
           {
             for(int k = 0; k <= sf.length; k++)
             {
                 if(verificar.equals(sf[k].silaba))
                 {
                     sf[k].frequencia++;
                     break;
                 }         
             }
           }
       }
       List<SilabaFreq> lista = new ArrayList<>();
       int tirar = 0;
       for(SilabaFreq passar : sf)
           lista.add(passar);
       for(int l = 0; l<lista.size(); l++)
       { 
        if(lista.get(l) == null)
           {
                tirar = l;
           while(lista.contains(null))
           {
               if(lista.size() > tirar)
                 lista.remove(tirar);
               else if(lista.size() == tirar)
                   break;
           }
           }      
       }
       
       
       int u = 0;
       sf = new SilabaFreq[lista.size()];
       for(SilabaFreq passar : lista)
       {
           sf[u] = passar;
         u++;
       }
          return sf;
}
}
