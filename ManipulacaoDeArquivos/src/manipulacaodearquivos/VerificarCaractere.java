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
public class VerificarCaractere {

    public boolean VerificarVogal(char letra) {
        char[] vogais = {'a', 'e', 'i', 'o', 'u'};

        for (int i = 0; i < vogais.length; i++) 
        {
            if (letra == vogais[i]) 
                return true;       
        }
        return false;

    }
    
      public boolean VerificarCharEspecial(char letra) {
        char[] especiais = {'.', ';', '!', '?', ':', ','};

        for (int i = 0; i < especiais.length; i++) 
        {
            if (letra == especiais[i]) 
                return true;       
        }
        return false;

    }
}
