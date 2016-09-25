package huffman;

/*
 * Classe do nó folha da Árvore 
 */
class HuffmanLeaf extends HuffmanTree {
    public final String value; // A letra é atribuida a um nó folha 
 
    public HuffmanLeaf(int freq, String val) {
        super(freq);
        value = val;
    }
}