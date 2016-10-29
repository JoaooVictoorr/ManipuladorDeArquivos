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
        char[] vogais = {'a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U'};

        for (int i = 0; i < vogais.length; i++) 
        {
            if (letra == vogais[i]) 
                return true;       
        }
        return false;

    }
    
     public boolean VerificarNumero(char letra) {
        char[] numeros = {'0', '1', '2', '3', '4','5', '6', '7', '8', '9'};

        for (int i = 0; i < numeros.length; i++) 
        {
            if (letra == numeros[i]) 
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
