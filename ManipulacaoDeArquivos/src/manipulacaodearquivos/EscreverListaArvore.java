/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipulacaodearquivos;

import java.io.Serializable;

/**
 *
 * @author joao.piccoli
 */
public class EscreverListaArvore implements Serializable {
    
   String silaba;
   int frequencia;
    
    public EscreverListaArvore(String silaba, int frequencia)
    {
        this.silaba = silaba;
        this.frequencia = frequencia;     
    }  
}
