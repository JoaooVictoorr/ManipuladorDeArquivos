/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipulacaodearquivos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joao.piccoli
 */
public class TransferirPalavra {

    public char[] transferencia;
    public char[] transferenciaSemEsp;
    public ArrayList<Character> passar = new ArrayList<>(); 
    VerificarCaractere vc = new VerificarCaractere();

    public void Transferir(String palavra) {
        transferencia = new char[palavra.length()];
        for (int i = 0; i < palavra.length(); i++) {
            transferencia[i] = palavra.charAt(i);
        }
    }

    public void TransferirSemCharEspecial(String palavra) {
        
               for (int i = 0; i < palavra.length(); i++) 
               {
                   if(vc.VerificarCharEspecial(palavra.charAt(i)))
                   passar.add(palavra.charAt(i));
                   else
                   passar.add(palavra.charAt(i));
                   
               }
               
                for(int j = 0; j<=passar.size(); j++)
                {
                    if(vc.VerificarCharEspecial(passar.get(j)))
                    {
                        passar.remove(j);
                    }
                    
                }
           }
    
    public boolean Contem(String contem, SilabaFreq[] contemAqui)
    {
        for(int i = 0;i<=contemAqui.length;i++)
            if(contemAqui[i] != null)
            {
               if(contem.equals(contemAqui[i].silaba))
                   return false;
            }
            else 
               return true;
        return false;
    }
        
        
        
        
       
        
                
         
            
        }

    

