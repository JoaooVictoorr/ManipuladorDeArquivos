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
        VerificarCaractere vv = new VerificarCaractere();
        int fim = tp.transferencia.length - 1;
        int j = 0;
        //int valorCompressao = 5;
        int parada = j + valorCompressao;
      
        // REGRAS COMEÇAM A PARTIR DAQUI
               for( j = 0; j<tp.transferencia.length; j++)
            {  
               
               if(vv.VerificarVogal(tp.transferencia[j]))
               {
                   if(j == 0 && j == fim)
                 escrever.append(tp.transferencia[j]);
                   else if(j == 0)
                  {
                      if(!vv.VerificarVogal(tp.transferencia[j+1])&& tp.transferencia[j+1] != 'n' && tp.transferencia[j+1] != 's' && tp.transferencia[j+1] != 'm' && tp.transferencia[j+1] != 'n' && tp.transferencia[j+1] != 'b' && tp.transferencia[j+1] != 'c' && tp.transferencia[j+1] != 'p' &&  tp.transferencia[j+1] != 'd' &&  tp.transferencia[j+1] != 't' &&  tp.transferencia[j+1] != 'g' &&  tp.transferencia[j+1] != 'x' )
                      {
                       escrever.append(tp.transferencia[j]);
                       escrever.append('-');
                      }
                      else if(!vv.VerificarVogal(tp.transferencia[j+1]) && vv.VerificarVogal(tp.transferencia[j+2]) && tp.transferencia[j+1] != 't' && tp.transferencia[j+1] != 'm' && tp.transferencia[j+1] != 'n')
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
                      if(fim - 3 != 0 && vv.VerificarVogal(tp.transferencia[j-1]) && vv.VerificarVogal(tp.transferencia[j-2]) && tp.transferencia[j-3] == 'd')
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
                     
                  else if(vv.VerificarVogal(tp.transferencia[j-1]) && !vv.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] != 's' && tp.transferencia[j+1] != 'r' && tp.transferencia[j+1] != 'l')
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
                      else if (!vv.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] == 'n' && tp.transferencia[j-1] != 'r')
                      {
                          escrever.append(tp.transferencia[j]);
                      }
                      else if (j + 3 <= fim && !vv.VerificarVogal(tp.transferencia[j+2]) && tp.transferencia[j+1] == 'm' || tp.transferencia[j+1] == 's' )
                      {
                          escrever.append(tp.transferencia[j]);
                      }
                      else if(tp.transferencia[j+1] == 'm' && j+1 == fim)
                      {
                           escrever.append(tp.transferencia[j]);
                      }
                      else if((!vv.VerificarVogal(tp.transferencia[j+1])) && (tp.transferencia[j+1] != 'r' && tp.transferencia[j+1] != 'm' && tp.transferencia[j+1] != 'l' && tp.transferencia[j+1] != 'n' && tp.transferencia[j+1] != 'b' && tp.transferencia[j+1] != 'c' && tp.transferencia[j+1] != 'p' &&  tp.transferencia[j+1] != 'd' &&  tp.transferencia[j+1] != 't' &&  tp.transferencia[j+1] != 'g' && tp.transferencia[j+1] != 'é' && tp.transferencia[j+1] != 'ã' && tp.transferencia[j+1] != 'õ' && tp.transferencia[j+1] != 'z'))
                      {
                          escrever.append(tp.transferencia[j]);
                          escrever.append('-'); 
                      }
 
                      else if(j + 2 <= fim && !vv.VerificarVogal(tp.transferencia[j-1]) && !vv.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] != 'm' && tp.transferencia[j+1] != 'n' && tp.transferencia[j+1] != 'l')
                      {
                          if((tp.transferencia[j+1] == 'r' && tp.transferencia[j+2] == 'r') || (tp.transferencia[j+1] == 's' && tp.transferencia[j+2] == 's') )
                          {
                              escrever.append(tp.transferencia[j]);
                          }
                          else if(tp.transferencia[j+1] == 'r' && tp.transferencia[j-1] != 's' )
                          {
                              escrever.append(tp.transferencia[j]);
                          }
                           else if(tp.transferencia[j+1] == 'r' && tp.transferencia[j-1] == 's')
                          {
                              escrever.append(tp.transferencia[j]);
                              escrever.append('-');
                          }
                           else if(tp.transferencia[j-1] == 'q' && (vv.VerificarVogal(tp.transferencia[j+1]) || tp.transferencia[j+1] == 'é'))
                          {
                              escrever.append(tp.transferencia[j]);
                          }
                           else if(tp.transferencia[j+1] == 'g' && !vv.VerificarVogal(tp.transferencia[j+2]))
                           {
                            escrever.append(tp.transferencia[j]);
                           }
                           else if ((tp.transferencia[j] == 'u') && (tp.transferencia[j+1] == 'ã' || tp.transferencia[j+1] == 'õ'))
                           {
                               escrever.append(tp.transferencia[j]);
                           }
                          else
                          {
                             escrever.append(tp.transferencia[j]);   
                             escrever.append('-');   
                          }
                       
                      }
                      else if(tp.transferencia[j-1] == tp.transferencia[j] && !vv.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] != 'l' )
                      {
                          escrever.append(tp.transferencia[j]);
                          escrever.append('-');
                      }
                      else if((j != 0 && j + 1 <= fim) && (tp.transferencia[j-1] == 'h' || tp.transferencia[j-1] == 's' || tp.transferencia[j-1] == 'j' || tp.transferencia[j-1] == 'r' && vv.VerificarVogal(tp.transferencia[j+1])))
                      {
                        escrever.append(tp.transferencia[j]);
                        escrever.append('-');
                      }
                      else if(tp.transferencia[j-1] == 'é' || tp.transferencia[j-1] == 'ú')
                      {
                         escrever.append(tp.transferencia[j]);
                         escrever.append('-');
                      }
                      else if((j != 0 && j + 1 <= fim) && (tp.transferencia[j-1] == 'h' || tp.transferencia[j-1] == 's' || tp.transferencia[j-1] == 'j' || tp.transferencia[j-1] == 't' || tp.transferencia[j-1] == 'r' && vv.VerificarVogal(tp.transferencia[j+1])) || (j == fim) && (tp.transferencia[j-1] == 'h' || tp.transferencia[j-1] == 's' || tp.transferencia[j-1] == 'j' || tp.transferencia[j-1] == 't' || tp.transferencia[j-1] == 'r' && vv.VerificarVogal(tp.transferencia[j+1])))
                      {
                        escrever.append(tp.transferencia[j]);
                        escrever.append('-');
                      }
                      else
                      {
                          escrever.append(tp.transferencia[j]);
                      }
                  }
                   else if(!vv.VerificarVogal(tp.transferencia[j-1]) && !vv.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] != 's')
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
                           if(!vv.VerificarVogal(tp.transferencia[j-1]) && !vv.VerificarVogal(tp.transferencia[j+1]))
                           {
                             escrever.append(tp.transferencia[j]);
                             escrever.append('-');
                           }
                           else if( !vv.VerificarVogal(tp.transferencia[j+2]))
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
                   else if((j != 0 && j + 1 <= fim) && (tp.transferencia[j-1] == 'h' || tp.transferencia[j-1] == 's' || tp.transferencia[j-1] == 'j' || tp.transferencia[j-1] == 't' || tp.transferencia[j-1] == 'r' && vv.VerificarVogal(tp.transferencia[j+1])) || (j == fim) && (tp.transferencia[j-1] == 'h' || tp.transferencia[j-1] == 's' || tp.transferencia[j-1] == 'j' || tp.transferencia[j-1] == 't' || tp.transferencia[j-1] == 'r' && vv.VerificarVogal(tp.transferencia[j+1])))
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
                   else if(!vv.VerificarVogal(tp.transferencia[j-1]) && vv.VerificarVogal(tp.transferencia[j+1]))
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
                      if(j == 0)
                      {
                          escrever.append(tp.transferencia[j]);
                          escrever.append('-');
                      }
                      else if(j != 0 && j + 1 <= fim && !vv.VerificarVogal(tp.transferencia[j-1]) && !vv.VerificarVogal(tp.transferencia[j+1]))
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
                      else if(!vv.VerificarVogal(tp.transferencia[j+1]))
                      {
                          escrever.append(tp.transferencia[j]);
                          escrever.append('-');
                      }
                      else
                      {
                       escrever.append(tp.transferencia[j]);
                      }
                      
                  }
                  
                else if((j!= 0 && j + 1 <= fim) && (tp.transferencia[j+1] == 'á' || tp.transferencia[j+1] == 'é' || tp.transferencia[j+1] == 'ó' || tp.transferencia[j+1] == 'í') && (tp.transferencia[j-1] != 'g') && (tp.transferencia[j-1] != 'p'))
                {
                    escrever.append('-');
                    escrever.append(tp.transferencia[j]);
                }
                else if(j + 2 <= fim && j != 0 && tp.transferencia[j] == 'r' && vv.VerificarVogal(tp.transferencia[j-1]) && tp.transferencia[j+1] == 'r')
                {
                     escrever.append(tp.transferencia[j]);
                     escrever.append('-');
                }
                else if(j + 2 <= fim && tp.transferencia[j] == 'r' && !vv.VerificarVogal(tp.transferencia[j+1]))
                {
                    if( tp.transferencia[j+1] == 'ã' || tp.transferencia[j+1] == 'õ' || tp.transferencia[j+1] == 'â' || tp.transferencia[j+1] == 'ô' )
                    {
                      escrever.append(tp.transferencia[j]);
                    }
                    else if(j + 1<= fim && tp.transferencia[j+1] == 'á' || tp.transferencia[j+1] == 'ó' || tp.transferencia[j+1] == 'é' )
                    {
                        escrever.append(tp.transferencia[j]);
                    }
                    else
                    {
                    escrever.append(tp.transferencia[j]);
                    escrever.append('-');
                    }
                
                }
                 else if((j + 2 <= fim && j!=0) && (tp.transferencia[j] == 'r' && vv.VerificarVogal(tp.transferencia[j-1]) && tp.transferencia[j-2] != 's' && tp.transferencia[j+2] != 't'))
                {
                   escrever.append('-');
                   escrever.append(tp.transferencia[j]);
                }
                else if(j + 2 <= fim && j!= 0 && tp.transferencia[j] == 's' && vv.VerificarVogal(tp.transferencia[j-1]) && tp.transferencia[j+1] == 's')
                {
                    escrever.append(tp.transferencia[j]);
                    escrever.append('-');
                }
            
                
                else if( j + 1 <= fim && j != 0 && tp.transferencia[j] == 'n')
                {
                    if(!vv.VerificarVogal(tp.transferencia[j-1]) && vv.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j] == 'b' || tp.transferencia[j] == 'c' || tp.transferencia[j] == 'd' ||  tp.transferencia[j] == 't' ||  tp.transferencia[j] == 'g' )
                    {
                       escrever.append('-');
                       escrever.append(tp.transferencia[j]);
                    }
                    else if(vv.VerificarVogal(tp.transferencia[j-1]) && vv.VerificarVogal(tp.transferencia[j+1]))
                    {
                       escrever.append('-');
                       escrever.append(tp.transferencia[j]);          
                    }
                    else if(vv.VerificarVogal(tp.transferencia[j-1]) && tp.transferencia[j+1] == 'á')
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
                    else if(vv.VerificarVogal(tp.transferencia[j-1]) && !vv.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] != 's' )
                    {
                         escrever.append(tp.transferencia[j]);
                         escrever.append('-');
                    }
                    else if(!vv.VerificarVogal(tp.transferencia[j+1]) && (tp.transferencia[j-1] == 'â' || tp.transferencia[j-1] == 'ô')) 
                    {
                       escrever.append(tp.transferencia[j]);
                       escrever.append('-'); 
                    }
                    else if((vv.VerificarVogal(tp.transferencia[j+1]) && (tp.transferencia[j-1] == 'â' || tp.transferencia[j-1] == 'ô')) )
                    {
                        escrever.append('-'); 
                        escrever.append(tp.transferencia[j]);
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
                    else if ( j!= 0 && j + 1 <= fim && !vv.VerificarVogal(tp.transferencia[j-1]) && tp.transferencia[j-1] != 'n' && (tp.transferencia[j+1] == 'ã' || vv.VerificarVogal(tp.transferencia[j+1])))
                   {
                      escrever.append(tp.transferencia[j]);
                   }
                   else if(j!= 0 && j + 1 <= fim &&  vv.VerificarVogal(tp.transferencia[j-1]) && (tp.transferencia[j+1] == 'ã' || vv.VerificarVogal(tp.transferencia[j+1])))
                   {
                     escrever.append('-');
                     escrever.append(tp.transferencia[j]);
                   }
                   else if(j!= 0 && j + 2 <= fim && !vv.VerificarVogal(tp.transferencia[j+1]))
                   {
                     escrever.append(tp.transferencia[j]);
                     escrever.append('-');
                   }
                   else if (j!= 0 && j + 1 <= fim && tp.transferencia[j-1] == 'n' && vv.VerificarVogal(tp.transferencia[j+1]))
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
                   if((j - 2 >= 0 && j + 1 <= fim) && (vv.VerificarVogal(tp.transferencia[j-1]) && vv.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j-2] != 't' && tp.transferencia[j-2] != 's')) 
                   {
                      escrever.append('-');
                      escrever.append(tp.transferencia[j]);
                   }
                   else if((j + 1 <= fim)&& (tp.transferencia[j+1] == 'á' || tp.transferencia[j+1] == 'ú' || tp.transferencia[j+1] == 'í' ))
                   {
                       escrever.append('-');
                       escrever.append(tp.transferencia[j]);
                   }  
                   else if(j!= 0 && j+1<=fim && !vv.VerificarVogal(tp.transferencia[j-1]) && vv.VerificarVogal(tp.transferencia[j+1]))
                   {
                     escrever.append(tp.transferencia[j]);
                   }
                   else if(j - 2 >= 0 && vv.VerificarVogal(tp.transferencia[j-1]) && vv.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j-2] != 't')
                   {
                       escrever.append('-');
                       escrever.append(tp.transferencia[j]);
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
                       else if(vv.VerificarVogal(tp.transferencia[j-1])&& !vv.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] != 'á' && tp.transferencia[j+1] != 'é' && tp.transferencia[j+1] != 'ó' && tp.transferencia[j+1] != 'í')
                       {
                           escrever.append(tp.transferencia[j]);
                           escrever.append('-');
                       }
                       else if((vv.VerificarVogal(tp.transferencia[j-1]))&& (!vv.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] == 'á' || tp.transferencia[j+1] == 'é' || tp.transferencia[j+1] == 'ó' || tp.transferencia[j+1] == 'í'))
                       {
                           escrever.append('-');
                           escrever.append(tp.transferencia[j]);

                       }
                       else if(vv.VerificarVogal(tp.transferencia[j-1])&& vv.VerificarVogal(tp.transferencia[j+1]))
                       {
                         escrever.append('-');
                         escrever.append(tp.transferencia[j]);
                       }
                       else if(!vv.VerificarVogal(tp.transferencia[j-1])&& vv.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j-1] != 'c' &&  tp.transferencia[j-1] != 'p' && tp.transferencia[j-1] != 'f' && tp.transferencia[j-1] != 'g'   )
                       {
                         escrever.append('-');
                         escrever.append(tp.transferencia[j]);
                       }
                       else
                       {
                           escrever.append(tp.transferencia[j]);
                       }
                       }
                       else if( j + 1 <= fim && vv.VerificarVogal(tp.transferencia[j-1]) && !vv.VerificarVogal(tp.transferencia[j-2]) && vv.VerificarVogal(tp.transferencia[j+1]))
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
                           if(tp.transferencia[j] == 'c' && vv.VerificarVogal(tp.transferencia[j-1]) && !vv.VerificarVogal(tp.transferencia[j+1]))
                           {
                             escrever.append('-');
                             escrever.append(tp.transferencia[j]); 
                           }
                           else if(vv.VerificarVogal(tp.transferencia[j-1]) && !vv.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] != 'r')
                           {
                             escrever.append(tp.transferencia[j]);
                             escrever.append('-');   
                           }
                           else if( j == 0 && tp.transferencia[j+1] == 'b' || tp.transferencia[j+1] == 'c' || tp.transferencia[j+1] == 'p' ||  tp.transferencia[j+1] == 'd' ||  tp.transferencia[j+1] == 't' ||  tp.transferencia[j+1] == 'g' || tp.transferencia[j+1] == 'n' ) 
                         {
                              escrever.append(tp.transferencia[j]);
                              escrever.append('-');
                         }
                         else if( j != 0 && vv.VerificarVogal(tp.transferencia[j-1]) && tp.transferencia[j+1] == 'l')
                         {
                             escrever.append('-');
                             escrever.append(tp.transferencia[j]);
                         }
                          
                         else if(j - 2 >=0 && vv.VerificarVogal(tp.transferencia[j-1]) && !vv.VerificarVogal(tp.transferencia[j-2]) && !vv.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1]!= 'r')
                         {
                             escrever.append(tp.transferencia[j]);
                             escrever.append('-');
                         }
                         else if( j - 2 >=0 && vv.VerificarVogal(tp.transferencia[j-1]) && !vv.VerificarVogal(tp.transferencia[j+1]) && tp.transferencia[j+1] != 'r')
                         {
                               escrever.append(tp.transferencia[j]);
                               escrever.append('-');
                         }
                         else if(j + 2 <= fim && tp.transferencia[j] == 'c')
                         {
                             if(j != 0 && !vv.VerificarVogal(tp.transferencia[j+1]) && (tp.transferencia[j+2] == 'â' || tp.transferencia[j+2] == 'ô' ||  tp.transferencia[j+2] == 'á' || tp.transferencia[j+2] == 'ó'))
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
                             if((j-2 >= 0) && (vv.VerificarVogal(tp.transferencia[j-1]) && tp.transferencia[j-2] != 'r'))
                             {
                              escrever.append('-');
                              escrever.append(tp.transferencia[j]);
                             }
                             else if(j != 0 && vv.VerificarVogal(tp.transferencia[j-1]) && tp.transferencia[j-1] != 'e' )
                             {
                              escrever.append('-');
                              escrever.append(tp.transferencia[j]);
                             }
                             else 
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
                    else if((j - 2>= 0) && ((!vv.VerificarVogal(tp.transferencia[j])) && (tp.transferencia[j] != 'r') && (vv.VerificarVogal(tp.transferencia[j-1])) && (vv.VerificarVogal(tp.transferencia[j-2]))))
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
                    else if((j != 0 && j + 1 <= fim) && (tp.transferencia[j-1] == 'í' || tp.transferencia[j-1] == 'é' || tp.transferencia[j-1] == 'ó' || tp.transferencia[j-1] == 'ú' || tp.transferencia[j-1] == 'á') && vv.VerificarVogal(tp.transferencia[j+1]))
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
    }
    
    
    public void Close() throws IOException
    {
       escrever.close();
    }
    
  
    
}