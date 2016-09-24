package huffman;

/*
 * Classe de um nó da Árvore 
 */
class HuffmanNode extends HuffmanTree {
    public final HuffmanTree left, right; // sub-árvores
 
   public HuffmanNode(HuffmanTree l, HuffmanTree r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }
}