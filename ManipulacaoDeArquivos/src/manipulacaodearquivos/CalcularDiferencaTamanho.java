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
public class CalcularDiferencaTamanho {

    public long CalcularDiferencaPorcentagem(File arquivo1, File arquivo2) {
        long resultadoFinal, maior, menor;
        /*if (arquivo1.length() > arquivo2.length()) {
            maior = arquivo1.length();
            menor = arquivo2.length();
        } else {
            maior = arquivo2.length();
            menor = arquivo1.length();
        }*/
        maior = arquivo1.length();
        menor = arquivo2.length();
        resultadoFinal = menor*100;
        resultadoFinal = resultadoFinal/maior;
        resultadoFinal = 100-resultadoFinal;
        return resultadoFinal;
    }
}
