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
public class EscreverTextoCompactado implements Serializable {
    
    public String texto;
    
    public EscreverTextoCompactado(String texto)
    {
        this.texto = texto;
    }
}
