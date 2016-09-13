/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipulacaodearquivos;

import java.io.File;

/**
 *
 * @author joao.piccoli
 */
public class Criar {
    
    public File CriarArquivo(String novo)
    {
          File arquivo = new File(novo);
        return arquivo;
    }
    
}
