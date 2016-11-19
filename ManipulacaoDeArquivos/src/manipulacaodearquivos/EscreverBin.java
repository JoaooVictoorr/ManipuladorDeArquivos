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
public class EscreverBin implements Serializable {

    public String bin;

    public EscreverBin(String bin) {
        this.bin = bin;
    }

}
