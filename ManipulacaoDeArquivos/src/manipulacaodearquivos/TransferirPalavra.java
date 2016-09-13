/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipulacaodearquivos;

/**
 *
 * @author joao.piccoli
 */
public class TransferirPalavra {

    public char[] transferencia;

    public void Transferir(String palavra) {
        transferencia = new char[palavra.length()];

        for (int i = 0; i < palavra.length(); i++) 
        {    
                transferencia[i] = palavra.charAt(i);
        }
    }
}
