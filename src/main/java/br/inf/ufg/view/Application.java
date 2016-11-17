/*
 * Copyright (c) 2016. Jean Lucas Monte Carvalho
 * Creative Commons Attribution 4.0 International License.
 */

package br.inf.ufg.view;

import java.io.IOException;
import java.util.ArrayList;

import br.inf.ufg.controller.ControllerExecuta;
import br.inf.ufg.controller.ControllerRead;
import br.inf.ufg.controller.ControllerRetorno;
import br.inf.ufg.controller.ControllerWriteHTML;
import br.inf.ufg.controller.ControllerWriteJson;
import br.inf.ufg.model.Retorno;
import br.inf.ufg.write.WriteInterface;


/*
 * Classe de execução da aplicação.
 */
public class Application {
    static ControllerExecuta controllerExecuta;
    static ArrayList<String[]> resultado = new ArrayList<String[]>();
    static Retorno listaRetorno;
    static WriteInterface controllerWrite;
    static ControllerRetorno controllerRetorno;
    
    public static void main(String[] args) throws IOException {
        ControllerRead controllerRead = new ControllerRead();
        controllerExecuta = new ControllerExecuta();
      
       
        if (args.length > 0) {
            String path = (args[0]); 
            resultado = controllerRead.lerArquivo(path);
            controllerRetorno = controllerExecuta.executa(resultado);
            
            
        }
          if(args.length==1){
              controllerWrite = new ControllerWriteJson();
              controllerWrite.write(controllerRetorno.getListaRetorno());
              System.out.println("Gerado Arquivo Json");
         
          } else if(args.length>1){
              if(args[1].equals("-h")){
                  controllerWrite = new ControllerWriteHTML();
                  controllerWrite.write(controllerRetorno.getListaRetorno());
                  System.out.println("Gerado Arquivo HTML");
              }
          }
             
        
    }
}
