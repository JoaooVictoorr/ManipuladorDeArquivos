package manipulacaodearquivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author João Victor
 */
public class RegrasHifenizacao extends SeparacaoDeSilabas {
    private OutputStreamWriter writer;
    private BufferedWriter escrever;
    public int valorCompressao;
    public boolean Inicializar(boolean status, File arquivo) throws IOException
    {
        if(status == true)
        {
        writer = new OutputStreamWriter(new FileOutputStream(arquivo),"Windows-1252");
        escrever = new BufferedWriter(writer);
        return true;
        }
        else
        {
            return false;
        }
    }
    
    public void AplicarRegras(String palavra) throws IOException
    {  
        TransferirPalavra tp = new TransferirPalavra();
        tp.Transferir(palavra);
        int fim = tp.transferencia.length - 1;
        int j = 0;
        //int valorCompressao = 5;
        int parada = j + valorCompressao;
      
        // REGRAS COMEÇAM A PARTIR DAQUI
               for(j = 0; j<tp.transferencia.length; j++)
              {
                  if(j==parada)
                  {  
                    parada += valorCompressao;
                    escrever.append("-");
                    escrever.append(tp.transferencia[j]);
                  }
                  else
                  {
                    escrever.append(tp.transferencia[j]);
                  }
              }
            escrever.append("\r\n");
    }
    
    public void Close() throws IOException
    {
       escrever.close();
    }
    
  
    
}