package huffman;

/*
 * Classe do nó folha da Árvore 
 */
class HuffmanLeaf extends HuffmanTree {
    public final char value; // A letra é atribuida a um nó folha 
 
    public HuffmanLeaf(int freq, char val) {
        super(freq);
        value = val;
    }
}