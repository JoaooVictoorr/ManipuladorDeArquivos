package huffman;

/*
 * Classe abstrata da Árvore 
 * De forma objetiva uma classe abstrata serve como modelo para uma classe concreta, neste caso para as classes NODE e LEAF
 */
public abstract class HuffmanTree implements Comparable<HuffmanTree> {
    public final int frequency; // Frequência da árvore
    //
    public HuffmanTree(int freq) { 
    	frequency = freq; 
    }
    
    // Compara as frequências - Implementação da Interface Comparable para a ordenação na fila
    public int compareTo(HuffmanTree tree) {
        return frequency - tree.frequency;
    }
}