/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipulacaodearquivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author João Victor
 */
public class RegrasHifenizacao extends SeparacaoDeSilabas {
    private FileWriter writer;
    private BufferedWriter escrever;
    public boolean Inicializar(boolean status) throws IOException
    {
        if(status == true)
        {
        writer = new FileWriter(palavrasSeparadas);
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
        
        VerificarCaractere vc = new VerificarCaractere();
      
        // REGRAS COMEÇAM A PARTIR DAQUI
            for(int j = 0; j<tp.transferencia.length; j++)
            {  
               
               if(vc.VerificarVogal(tp.transferencia[j]))
               {
                   if(tp.transferencia.length == 1){
                       escrever.append(tp.transferencia[j]);
                   }
                   else if(tp.transferencia.length == 2 && tp.transferencia[j] != 'í')
                   {
                       escrever.append(tp.transferencia[j]);
                   }
                   else if(j == 0 && j == fim)
                        escrever.append(tp.transferencia[j]);
                   else if(j == 0)
                  {
                      if(!vc.VerificarVogal(tp.transferencia[j+1])&& tp.transferencia[j+1] != 'n' && tp.transferencia[j+1] != 's' && tp.transferencia[j+1] != 'c' && tp.transferencia[j+1] != 'p' &&  tp.transferencia[j+1] != 'd' &&  tp.transferencia[j+1] != 'g' &&  tp.transferencia[j+1] != 'x' && tp.transferencia[j+1] != 'r' )
                      {
                       escrever.append(tp.transferencia[j]);
                       escrever.append('-');
                      }
                      else if(j == 0 && j+1 == fim)
                      {
                          escrever.append(tp.transferencia[j]);
                      }
                      else if( !vc.VerificarVogal(tp.transferencia[j+1]) && vc.VerificarVogal(tp.transferencia[j+2]) && tp.transferencia[j+1] != 't' && tp.transferencia[j+1] != 'm' && tp.transferencia[j+1] != 'n')
                      {
                          escrever.append(tp.transferencia[j]);
                          escrever.append('-');       
                      }
                      else
                      {
                          escrever.append(tp.transferencia[j]);
                      }
                     
                  }
                  else if(j == fim)
                  {
                      if(fim - 3 != 0 && vc.VerificarVogal(tp.transferencia[j-1]) && vc.VerificarVogal(tp.transferencia[j-2]) && tp.transferencia[j-3] == 'd')
                      {
                          escrever.append('-');
                          escrever.append(tp.transferencia[j]);
                      }
                      else
                      escrever.append(tp.transferencia[j]);
                  }
                  else if( j != fim && tp.transferencia[j+1] == tp.transferencia[j])
                  {
                      escrever.append(tp.transferencia[j]);
                      escrever.append('-');                      
                  }
                      
                   else if(j + 2<= fim && tp.transferencia[j+1] == 'n' && tp.transferencia[j+2] == 'h')
                   {
                       escrever.append(tp.transferencia[j]);
                       escrever.append('-');
                   }
                   else if(j + 2<= fim && tp.transferencia[j+1] == 'c' && tp.transferencia[j+2] == 'h')
                   {
                       escrever.append(tp.transferencia[j]);
                       escrever.append('-');
                   }
                   else if(j + 2<= fim && tp.transferencia[j+1] == 'l' && tp.transferencia[j+2] == 'h')
                   {
                       escrever.append(tp.transferencia[j]);
                       escrever.append('-');
                   }
                     
                  else if( j != 0 && j + 1 <= fim && vc.VerificarVogal(tp.transferencia[j-1]) && !vc.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] != 's' && tp.transferencia[j+1] != 'r' && tp.transferencia[j+1] != 'l')
                  {
                      if(tp.transferencia[j+1] == 'n' || tp.transferencia[j+1] == 'm')
                      {
                          escrever.append(tp.transferencia[j]);
                      }
                      else if(tp.transferencia[j+1] == 'd')
                      {
                          escrever.append(tp.transferencia[j]);
                          escrever.append('-');
                      }
                      else if(!vc.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] != 't')
                      {
                        escrever.append(tp.transferencia[j]);
                        escrever.append('-');   
                      }
                      else
                      {
                           escrever.append(tp.transferencia[j]);
                      }
                          
                      
                     
                  }
                   else if(j != fim && j-1 != 0 && j-2 >= 0)
                  {
                      if((tp.transferencia[j-1] == 'h') && (tp.transferencia[j-2] == 'c' || tp.transferencia[j-2] == 'l' || tp.transferencia[j-2] == 'n'))
                      {
                          if (tp.transferencia[j+1] == 'r' || tp.transferencia[j+1] == 'n' || tp.transferencia[j+1] == 'm')
                          {
                             escrever.append(tp.transferencia[j]);
                          }
                          else
                          {
                             escrever.append(tp.transferencia[j]);
                             escrever.append('-');
                          }
                      }
                      else if (!vc.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] == 'n' && tp.transferencia[j-1] != 'r')
                      {
                          escrever.append(tp.transferencia[j]);
                      }
                      else if ((j!= 0 && j + 3 <= fim) && !vc.VerificarVogal(tp.transferencia[j+2]) && tp.transferencia[j+1] == 'm' || tp.transferencia[j+1] == 's' && tp.transferencia[j-1] != 'o' && tp.transferencia[j-1] != 'i'  )
                      {
                          escrever.append(tp.transferencia[j]);
                      }
                      else if(tp.transferencia[j+1] == 'm' && j+1 == fim)
                      {
                           escrever.append(tp.transferencia[j]);
                      }
                      else if((!vc.VerificarVogal(tp.transferencia[j+1])) && (tp.transferencia[j+1] != 'r' && tp.transferencia[j+1] != 'm' && tp.transferencia[j+1] != 'l' && tp.transferencia[j+1] != 'n' && tp.transferencia[j+1] != 'b' && tp.transferencia[j+1] != 'c' && tp.transferencia[j+1] != 'p' &&  tp.transferencia[j+1] != 'd' &&  tp.transferencia[j+1] != 't' &&  tp.transferencia[j+1] != 'g' && tp.transferencia[j+1] != 'é' && tp.transferencia[j+1] != 'ã' && tp.transferencia[j+1] != 'õ' && tp.transferencia[j+1] != 'z' && tp.transferencia[j+1] != 's'))
                      {
                          escrever.append(tp.transferencia[j]);
                          escrever.append('-'); 
                      }
 
                      else if(j + 2 <= fim && !vc.VerificarVogal(tp.transferencia[j-1]) && !vc.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] != 'm' && tp.transferencia[j+1] != 'n' && tp.transferencia[j+1] != 'l' && tp.transferencia[j+1] != 't')
                      {
                          if((tp.transferencia[j+1] == 'r' && tp.transferencia[j+2] == 'r') || (tp.transferencia[j+1] == 's' && tp.transferencia[j+2] == 's') )
                          {
                              escrever.append(tp.transferencia[j]);
                          }
                          else if(tp.transferencia[j+1] == 'r' && tp.transferencia[j-1] != 's' && tp.transferencia[j-1] != 'v')
                          {
                              if(tp.transferencia[j-1] == 'f' && tp.transferencia[j] == 'e')
                              {
                                  escrever.append(tp.transferencia[j]);
                                  escrever.append('-');
                              }
                              else
                              {
                                  escrever.append(tp.transferencia[j]);
                              }
                          }
                           else if(tp.transferencia[j+1] == 'r' && tp.transferencia[j-1] == 's')
                          {
                              escrever.append(tp.transferencia[j]);
                              escrever.append('-');
                          }
                           else if(tp.transferencia[j-1] == 'q' && (vc.VerificarVogal(tp.transferencia[j+1]) || tp.transferencia[j+1] == 'é'))
                          {
                              escrever.append(tp.transferencia[j]);
                          }
                           else if(tp.transferencia[j+1] == 'g' && !vc.VerificarVogal(tp.transferencia[j+2]))
                           {
                            escrever.append(tp.transferencia[j]);
                           }
                           else if ((tp.transferencia[j] == 'u') && (tp.transferencia[j+1] == 'ã' || tp.transferencia[j+1] == 'õ'))
                           {
                               escrever.append(tp.transferencia[j]);
                           }
                           else if(!vc.VerificarVogal(tp.transferencia[j-1]) && tp.transferencia[j+1] == 'r')
                           {
                                escrever.append(tp.transferencia[j]);
                           }
                           else if(j+1<=fim && tp.transferencia[j+1] == 'c') 
                           {
                               escrever.append(tp.transferencia[j]);
                           }
                          else
                          {
                             escrever.append(tp.transferencia[j]);   
                             escrever.append('-');   
                          }
                       
                      }
                      else if(tp.transferencia[j-1] == tp.transferencia[j] && !vc.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] != 'l' )
                      {
                          escrever.append(tp.transferencia[j]);
                          escrever.append('-');
                      }
                      else if((j != 0 && j + 1 <= fim) && (tp.transferencia[j-1] == 'h' || tp.transferencia[j-1] == 's' || tp.transferencia[j-1] == 'j' || tp.transferencia[j-1] == 'r' && vc.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] != 'i'))
                      {
                        escrever.append(tp.transferencia[j]);
                        escrever.append('-');
                      }
                      else if(tp.transferencia[j-1] == 'é' || tp.transferencia[j-1] == 'ú')
                      {
                         escrever.append(tp.transferencia[j]);
                         escrever.append('-');
                      }
                      else if((j != 0 && j + 1 <= fim) && (tp.transferencia[j-1] == 'h' || tp.transferencia[j-1] == 's' || tp.transferencia[j-1] == 'j' || tp.transferencia[j-1] == 'r' && vc.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] != 'i') || (j == fim) && (tp.transferencia[j-1] == 'h' || tp.transferencia[j-1] == 's' || tp.transferencia[j-1] == 'j' || tp.transferencia[j-1] == 't' || tp.transferencia[j-1] == 'r' && (vc.VerificarVogal(tp.transferencia[j+1]))))
                      {
                        escrever.append(tp.transferencia[j]);
                        escrever.append('-');
                      }
                      else if(j != 0 && j + 1 <= fim && vc.VerificarVogal(tp.transferencia[j-1]) && !vc.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] != 'r' && tp.transferencia[j+1] != 's' && tp.transferencia[j+1] !='l')
                      {
                          escrever.append(tp.transferencia[j]);
                          escrever.append('-');
                      }
                      else if(j + 1 != fim && tp.transferencia[j+1] == 't')
                      {
                          escrever.append(tp.transferencia[j]);
                          escrever.append('-');
                      }
                      else if((j - 2 >= 0 && j + 2 <= fim) && (vc.VerificarVogal(tp.transferencia[j+1])) && (vc.VerificarVogal(tp.transferencia[j+2])))
                      {
                        if(tp.transferencia[j] == 'u')
                        {
                          escrever.append(tp.transferencia[j]);
                        }
                        else
                        {
                         escrever.append(tp.transferencia[j]);
                         escrever.append('-');
                        }
                      }
                      else if(tp.transferencia[j] == 'o' && tp.transferencia[j+1] == 's' )
                      {
                          escrever.append('-');
                          escrever.append(tp.transferencia[j]);
                      }
                      else if(tp.transferencia[j-1] == 't' && tp.transferencia[j] == 'u' && tp.transferencia[j+1] == 'a')
                      {
                          escrever.append(tp.transferencia[j]);
                          escrever.append('-');
                      }
                      else 
                      {
                          escrever.append(tp.transferencia[j]);
                      }
                  }
                   else if(!vc.VerificarVogal(tp.transferencia[j-1]) && !vc.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] != 's')
                   {
                       if(j + 2 <= fim && tp.transferencia[j+1] == 'r' && tp.transferencia[j+2] == 'r' || ( j+2<= fim && tp.transferencia[j+1] == 's' && tp.transferencia[j+2] == 's'))
                      {
                       escrever.append(tp.transferencia[j]);
                      }
                       else if(j + 2 <= fim && tp.transferencia[j+1] == 'r' ||  tp.transferencia[j+1] == 'm' ||  tp.transferencia[j+1] == 'n' || tp.transferencia[j+1] == 'l' )
                      {
                         escrever.append(tp.transferencia[j]);
                      }
                       else if(j + 2 <= fim && tp.transferencia[j+1] == 'b' ||  tp.transferencia[j+1] == 'p' ||  tp.transferencia[j+1] == 'd' || tp.transferencia[j+1] == 't' || tp.transferencia[j+1] == 'c' || tp.transferencia[j+1] == 'g' )
                       {
                           if(!vc.VerificarVogal(tp.transferencia[j-1]) && !vc.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] != 't' && tp.transferencia[j+1] != 'c')
                           {
                             escrever.append(tp.transferencia[j]);
                             escrever.append('-');
                           }
                           else if(!vc.VerificarVogal(tp.transferencia[j-1]) && !vc.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] == 'c')
                           {
                             escrever.append(tp.transferencia[j]);
                           }
                           else if(!vc.VerificarVogal(tp.transferencia[j-1]) && !vc.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] == 't')
                           {
                             escrever.append(tp.transferencia[j]);
                           }
                           else if( !vc.VerificarVogal(tp.transferencia[j+2]))
                           {
                             escrever.append(tp.transferencia[j]);
                           }
                           else
                           {
                           escrever.append(tp.transferencia[j]);
                           escrever.append('-');
                           }
                       
                       }
                       else if(j != 0 && j + 1 <= fim && tp.transferencia[j-1] == 'q' && tp.transferencia[j+1] == 'ã' || tp.transferencia[j+1] == 'õ' )
                       {
                           escrever.append(tp.transferencia[j]);
                       }
                       else
                       {
                           escrever.append(tp.transferencia[j]);
                           escrever.append('-');
                       }
                          
                   }
                   else if((j != 0 && j + 1 <= fim) && (tp.transferencia[j-1] == 'h' || tp.transferencia[j-1] == 's' || tp.transferencia[j-1] == 'j' || tp.transferencia[j-1] == 't' || tp.transferencia[j-1] == 'r' || tp.transferencia[j-1] == 'v' && vc.VerificarVogal(tp.transferencia[j+1])) || (j == fim) && (tp.transferencia[j-1] == 'h' || tp.transferencia[j-1] == 's' || tp.transferencia[j-1] == 'j' || tp.transferencia[j-1] == 't' || tp.transferencia[j-1] == 'r'  || tp.transferencia[j-1] == 'v' && vc.VerificarVogal(tp.transferencia[j+1])))
                   {
                       if((tp.transferencia[j-1] == 's') && (tp.transferencia[j+1] == 'u' || tp.transferencia[j+1] == 's'))
                       {
                           escrever.append(tp.transferencia[j]);
                       }
                       else
                       {
                            escrever.append(tp.transferencia[j]);
                            escrever.append('-');
                       }
                   }
                   else if(!vc.VerificarVogal(tp.transferencia[j-1]) && vc.VerificarVogal(tp.transferencia[j+1]))
                   {
                       escrever.append(tp.transferencia[j]);
                   }
                   else
                   {
                    escrever.append(tp.transferencia[j]);
                   }
                     
                  
                     
                  
                  
                    
                  
            
                   
              }
              else
              {
                  if(tp.transferencia[j] == 'ú' || tp.transferencia[j] == 'ó' || tp.transferencia[j] == 'á' || tp.transferencia[j] == 'é')
                  {
                      if(j == 0 && tp.transferencia[j+1] != 'r')
                      {
                          escrever.append(tp.transferencia[j]);
                          escrever.append('-');
                      }
                      else if(j != 0 && j + 1 <= fim && !vc.VerificarVogal(tp.transferencia[j-1]) && !vc.VerificarVogal(tp.transferencia[j+1]))
                      {
                          if((tp.transferencia[j+1] != 's' && tp.transferencia[j+2] != 's' && tp.transferencia[j+1] != 'r' && tp.transferencia[j+1] != 'r'))
                          {
                           escrever.append(tp.transferencia[j]);
                           escrever.append('-');
                          }  
                          else
                          {
                              escrever.append(tp.transferencia[j]);
                          }
                      }
                      else if(j + 1 <= fim && tp.transferencia[j+1] == 'i')
                      {
                          escrever.append(tp.transferencia[j]);
                      }
                      
                      else if(j == fim)
                       escrever.append(tp.transferencia[j]);
                      else if(!vc.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] != 'r')
                      {
                          escrever.append(tp.transferencia[j]);
                          escrever.append('-');
                      }
                      else
                      {
                       escrever.append(tp.transferencia[j]);
                      }
                      
                  }
                  
                else if((j!= 0 && j + 1 <= fim && tp.transferencia[j] != 'h') && (tp.transferencia[j+1] == 'á' || tp.transferencia[j+1] == 'é' || tp.transferencia[j+1] == 'ó' || tp.transferencia[j+1] == 'í') && (tp.transferencia[j-1] != 'g') && (tp.transferencia[j-1] != 'p') && (tp.transferencia[j-1]) != 'n')
                {   
                    if(tp.transferencia[j] == 'f'){
                    escrever.append(tp.transferencia[j]);
                    }
                    else
                    {
                    escrever.append('-');
                    escrever.append(tp.transferencia[j]);
                    }
                }
                else if(j + 2 <= fim && j != 0 && tp.transferencia[j] == 'r' && vc.VerificarVogal(tp.transferencia[j-1]) && tp.transferencia[j+1] == 'r')
                {
                     escrever.append(tp.transferencia[j]);
                     escrever.append('-');
                }
                else if(j + 2 <= fim && tp.transferencia[j] == 'r' && !vc.VerificarVogal(tp.transferencia[j+1]))
                {
                    if( tp.transferencia[j+1] == 'ã' || tp.transferencia[j+1] == 'õ' || tp.transferencia[j+1] == 'â' || tp.transferencia[j+1] == 'ô' )
                    {
                      escrever.append(tp.transferencia[j]);
                    }
                    else if(j + 1<= fim && tp.transferencia[j+1] == 'á' || tp.transferencia[j+1] == 'ó' || tp.transferencia[j+1] == 'é' || tp.transferencia[j+1] == 'ê' )
                    {
                        escrever.append(tp.transferencia[j]);
                    }
                    else
                    {
                    escrever.append(tp.transferencia[j]);
                    escrever.append('-');
                    }
                
                }
                 else if((j + 2 <= fim && j - 2 >=0) && (tp.transferencia[j] == 'r' && vc.VerificarVogal(tp.transferencia[j-1]) && tp.transferencia[j-2] != 's' && tp.transferencia[j+2] != 't'))
                {
                   escrever.append('-');
                   escrever.append(tp.transferencia[j]);
                }
                else if(j + 2 <= fim && j!= 0 && tp.transferencia[j] == 's' && vc.VerificarVogal(tp.transferencia[j-1]) && tp.transferencia[j+1] == 's')
                {
                    escrever.append(tp.transferencia[j]);
                    escrever.append('-');
                }
            
                
                else if( j + 1 <= fim && j != 0 && tp.transferencia[j] == 'n')
                {
                    if(!vc.VerificarVogal(tp.transferencia[j-1]) && vc.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j] == 'b' || tp.transferencia[j] == 'c' || tp.transferencia[j] == 'd' ||  tp.transferencia[j] == 't' ||  tp.transferencia[j] == 'g' )
                    {
                       escrever.append('-');
                       escrever.append(tp.transferencia[j]);
                    }
                    else if(vc.VerificarVogal(tp.transferencia[j-1]) && vc.VerificarVogal(tp.transferencia[j+1]))
                    {
                       escrever.append('-');
                       escrever.append(tp.transferencia[j]);          
                    }
                    else if(vc.VerificarVogal(tp.transferencia[j-1]) && tp.transferencia[j+1] == 'á')
                    {
                       escrever.append('-');
                       escrever.append(tp.transferencia[j]); 
                    }
                 
                    else if(tp.transferencia[j+1] == 'ã')
                    {
                      escrever.append('-');
                      escrever.append(tp.transferencia[j]);
                    }
                    else if(tp.transferencia[j+1] == 'h')
                    {
                     escrever.append(tp.transferencia[j]);
                    }
                    else if(vc.VerificarVogal(tp.transferencia[j-1]) && !vc.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] != 's' )
                    {
                         escrever.append(tp.transferencia[j]);
                         escrever.append('-');
                    }
                    else if(!vc.VerificarVogal(tp.transferencia[j+1]) && (tp.transferencia[j-1] == 'â' || tp.transferencia[j-1] == 'ô')) 
                    {
                       escrever.append(tp.transferencia[j]);
                       escrever.append('-'); 
                    }
                    else if((vc.VerificarVogal(tp.transferencia[j+1]) && (tp.transferencia[j-1] == 'â' || tp.transferencia[j-1] == 'ô')) )
                    {
                        escrever.append('-'); 
                        escrever.append(tp.transferencia[j]);
                    }
                    else if(j + 1 <= fim && !vc.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] != 's')
                    {
                        escrever.append(tp.transferencia[j]);
                        escrever.append('-');
                    }
                    else
                    {
                           escrever.append(tp.transferencia[j]);  
                    }
                    
                    
                }
                
                else if(tp.transferencia[j] == 's')
                {
                    if(j == 0 || j == fim)
                    {
                        escrever.append(tp.transferencia[j]);
                    }
                    else if ( j!= 0 && j + 1 <= fim && !vc.VerificarVogal(tp.transferencia[j-1]) && tp.transferencia[j-1] != 'n' && (tp.transferencia[j+1] == 'ã' || vc.VerificarVogal(tp.transferencia[j+1])))
                   {
                      escrever.append(tp.transferencia[j]);
                   }
                   else if(j!= 0 && j + 1 <= fim &&  vc.VerificarVogal(tp.transferencia[j-1]) && (tp.transferencia[j+1] == 'ã' || vc.VerificarVogal(tp.transferencia[j+1])))
                   {
                     escrever.append('-');
                     escrever.append(tp.transferencia[j]);
                   }
                   else if((j!= 0 && j + 2 <= fim) && (!vc.VerificarVogal(tp.transferencia[j+1])) && (tp.transferencia[j+1] != 'ã' && tp.transferencia[j+1] != 'õ'))
                   {
                     escrever.append(tp.transferencia[j]);
                     escrever.append('-');
                   }
                   else if (j!= 0 && j + 1 <= fim && tp.transferencia[j-1] == 'n' && vc.VerificarVogal(tp.transferencia[j+1]))
                   {
                       escrever.append('-');
                       escrever.append(tp.transferencia[j]);
                   }
                   else
                   {
                      escrever.append(tp.transferencia[j]);
                   }
                    
                }
                
                 else if(tp.transferencia[j] == 'm')
                {
                   if((j - 2 >= 0 && j + 1 <= fim) && (vc.VerificarVogal(tp.transferencia[j-1]) && vc.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j-2] != 't' && tp.transferencia[j-2] != 's')) 
                   {
                      escrever.append('-');
                      escrever.append(tp.transferencia[j]);
                   }
                   else if((j + 1 <= fim)&& (tp.transferencia[j+1] == 'á' || tp.transferencia[j+1] == 'ú' || tp.transferencia[j+1] == 'í' ))
                   {
                       escrever.append('-');
                       escrever.append(tp.transferencia[j]);
                   }  
                   else if(j!= 0 && j+1<=fim && !vc.VerificarVogal(tp.transferencia[j-1]) && vc.VerificarVogal(tp.transferencia[j+1]))
                   {
                     escrever.append(tp.transferencia[j]);
                   }
                   else if(j - 2 >= 0 && j + 1 <= fim && vc.VerificarVogal(tp.transferencia[j-1]) && vc.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j-2] != 't')
                   {
                       escrever.append('-');
                       escrever.append(tp.transferencia[j]);
                   }
                   else if(j - 2 >= 0 && j + 1 <= fim && vc.VerificarVogal(tp.transferencia[j-1]) && vc.VerificarVogal(tp.transferencia[j+1]) && !vc.VerificarVogal(tp.transferencia[j-2]))
                   {  
                       escrever.append('-');
                       escrever.append(tp.transferencia[j]);
                   }
                   else if((j + 1 <= fim) && (tp.transferencia[j+1] == 'p' || tp.transferencia[j+1] == 'b'))
                   {
                       escrever.append(tp.transferencia[j]);
                       escrever.append('-');
                   }
                   else 
                   {
                     escrever.append(tp.transferencia[j]);
                   }
                }
                   else if(tp.transferencia[j] == 'l')
                   {
                       if(j!= 0 && j + 2 <= fim)
                       {
                       if(tp.transferencia[j+1] == 'h')
                       {
                           escrever.append(tp.transferencia[j]);
                       }
                       else if(vc.VerificarVogal(tp.transferencia[j-1])&& !vc.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] != 'á' && tp.transferencia[j+1] != 'é' && tp.transferencia[j+1] != 'ó' && tp.transferencia[j+1] != 'í')
                       {
                           escrever.append(tp.transferencia[j]);
                           escrever.append('-');
                       }
                       else if((vc.VerificarVogal(tp.transferencia[j-1]))&& (!vc.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] == 'á' || tp.transferencia[j+1] == 'é' || tp.transferencia[j+1] == 'ó' || tp.transferencia[j+1] == 'í'))
                       {
                           escrever.append('-');
                           escrever.append(tp.transferencia[j]);

                       }
                       else if(vc.VerificarVogal(tp.transferencia[j-1])&& vc.VerificarVogal(tp.transferencia[j+1]))
                       {
                         escrever.append('-');
                         escrever.append(tp.transferencia[j]);
                       }
                       else if(!vc.VerificarVogal(tp.transferencia[j-1])&& vc.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j-1] != 'c' &&  tp.transferencia[j-1] != 'p' && tp.transferencia[j-1] != 'f' && tp.transferencia[j-1] != 'g'   )
                       {
                         escrever.append('-');
                         escrever.append(tp.transferencia[j]);
                       }
                       else
                       {
                           escrever.append(tp.transferencia[j]);
                       }
                       }
                       else if(j==0 && tp.transferencia[j] == 'l')
                       {
                           escrever.append(tp.transferencia[j]);
                       }
                       else if( j + 1 <= fim && vc.VerificarVogal(tp.transferencia[j-1]) && !vc.VerificarVogal(tp.transferencia[j-2]) && vc.VerificarVogal(tp.transferencia[j+1]))
                       {
                         escrever.append('-');
                         escrever.append(tp.transferencia[j]);
                       }
                       else
                       {
                           escrever.append(tp.transferencia[j]);
                       }
                       
                   }
                    else if((j != 0) &&(tp.transferencia[j] == 'b' || tp.transferencia[j] == 'c' || tp.transferencia[j] == 'd' ||  tp.transferencia[j] == 't' ||  tp.transferencia[j] == 'g'))
                       {
                           if(tp.transferencia[j] == 'c' && vc.VerificarVogal(tp.transferencia[j-1]) && !vc.VerificarVogal(tp.transferencia[j+1]))
                           {
                             escrever.append('-');
                             escrever.append(tp.transferencia[j]); 
                           } 
                           
                           else if(tp.transferencia[j] == 't' && j==fim)
                           {
                                escrever.append(tp.transferencia[j]);
                           }
                           else if(vc.VerificarVogal(tp.transferencia[j-1]) && !vc.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] != 'r')
                           {                        
                                   escrever.append(tp.transferencia[j]);
                                   escrever.append('-');   
                           }
                           else if( j == 0 && tp.transferencia[j+1] == 'b' || tp.transferencia[j+1] == 'c' || tp.transferencia[j+1] == 'p' ||  tp.transferencia[j+1] == 'd' ||  tp.transferencia[j+1] == 't' ||  tp.transferencia[j+1] == 'g' || tp.transferencia[j+1] == 'n' ) 
                         {
                              escrever.append(tp.transferencia[j]);
                              escrever.append('-');
                         }
                         else if( j != 0 && vc.VerificarVogal(tp.transferencia[j-1]) && tp.transferencia[j+1] == 'l')
                         {
                             escrever.append('-');
                             escrever.append(tp.transferencia[j]);
                         }
                          
                         else if(j - 2 >=0 && vc.VerificarVogal(tp.transferencia[j-1]) && !vc.VerificarVogal(tp.transferencia[j-2]) && !vc.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1]!= 'r')
                         {
                             escrever.append(tp.transferencia[j]);
                             escrever.append('-');
                         }
                         else if( j - 2 >=0 && vc.VerificarVogal(tp.transferencia[j-1]) && !vc.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] != 'r')
                         {
                               escrever.append(tp.transferencia[j]);
                               escrever.append('-');
                         }
                         else if(j + 2 <= fim && tp.transferencia[j] == 'c')
                         {
                             if(j != 0 && !vc.VerificarVogal(tp.transferencia[j+1]) && (tp.transferencia[j+2] == 'â' || tp.transferencia[j+2] == 'ô' ||  tp.transferencia[j+2] == 'á' || tp.transferencia[j+2] == 'ó'))
                             {
                               escrever.append('-');
                               escrever.append(tp.transferencia[j]);
                             }
                             else if(vc.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j-1] != 'n')
                             {
                               escrever.append('-');
                               escrever.append(tp.transferencia[j]);
                             }
                             else
                             {
                                 escrever.append(tp.transferencia[j]);
                             }
                             
                         }
                         else if(tp.transferencia[j] == 't')
                         {
                             if((j-2 >= 0) && (vc.VerificarVogal(tp.transferencia[j-1]) && tp.transferencia[j-2] != 'r'))
                             {
                              escrever.append('-');
                              escrever.append(tp.transferencia[j]);
                             }

                             else 
                             escrever.append(tp.transferencia[j]);
                           
                         }
                         else if(j != 0 && tp.transferencia[j] == 'c' && vc.VerificarVogal(tp.transferencia[j-1]))
                         {
                             escrever.append('-');
                          escrever.append(tp.transferencia[j]);
                         }
                         else
                             escrever.append(tp.transferencia[j]);
                       }
                    else if(tp.transferencia[j] == 'x' && tp.transferencia[j+1] == 'c')
                    {
                        escrever.append(tp.transferencia[j]);
                        escrever.append('-');
                    }
                    else if((j != 0 && j > 1) && ((!vc.VerificarVogal(tp.transferencia[j])) && (tp.transferencia[j] != 'r') && (vc.VerificarVogal(tp.transferencia[j-1])) && (vc.VerificarVogal(tp.transferencia[j-2]))))
                     {
                          escrever.append('-');
                          escrever.append(tp.transferencia[j]);
                     }
                    else if(tp.transferencia[j] == 'q')
                    {
                        if(tp.transferencia[j+1] == 'u' && tp.transferencia[j+2] == 'é')
                        {
                            escrever.append(tp.transferencia[j]);
                        }
                        else 
                        {
                            escrever.append(tp.transferencia[j]);
                        }

                    }
                    else if((j != 0 && j + 1 <= fim) && (tp.transferencia[j-1] == 'í' || tp.transferencia[j-1] == 'é' || tp.transferencia[j-1] == 'ó' || tp.transferencia[j-1] == 'ú' || tp.transferencia[j-1] == 'á') && vc.VerificarVogal(tp.transferencia[j+1]))
                    {
                      escrever.append('-');
                      escrever.append(tp.transferencia[j]);
                    }
                    else if( j - 2 >=0 && j + 1 <= fim && tp.transferencia[j] == 'r' && vc.VerificarVogal(tp.transferencia[j+1]) && vc.VerificarVogal(tp.transferencia[j-1]) && tp.transferencia[j-2] != 'v'  && tp.transferencia[j-2] != 's')
                    {
                        escrever.append('-');
                        escrever.append(tp.transferencia[j]);
                    }
                else
                {
                    escrever.append(tp.transferencia[j]);
                }
                    
              }
              
             
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
             
                   
                  
                   
                   
                   
                   
                   
                   
                   
                   
                   
                   
                   
                   
                   
                   
                   
                   
                   
                   
                   
                   
                   
                   
                   
                 
            }
            
            escrever.append("\r\n");
    }
    
    public void Close() throws IOException
    {
       escrever.close();
    }
    
  
    
}
