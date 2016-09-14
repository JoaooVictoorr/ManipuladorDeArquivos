/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipulacaodearquivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author joao.piccoli
 */
public class Escrever {

    public File Escrever(File arquivo) throws IOException {

        arquivo.createNewFile();

        OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(arquivo),"Windows-1252");
        try (BufferedWriter escrever = new BufferedWriter(write)) {
            escrever.write("Insira seu Texto Aqui");
        }

        return arquivo;
    }

}
