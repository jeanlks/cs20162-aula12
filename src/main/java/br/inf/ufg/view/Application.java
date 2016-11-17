/*
 * Copyright (c) 2016. Jean Lucas Monte Carvalho
 * Creative Commons Attribution 4.0 International License.
 */

package br.inf.ufg.view;

import java.io.IOException;
import java.util.ArrayList;

import br.inf.ufg.controller.ControllerExecuta;
import br.inf.ufg.controller.ControllerRead;
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
    static Retorno retorno;
    static WriteInterface controllerWrite;
    
    public static void main(String[] args) throws IOException {
       controllerExecuta = new ControllerExecuta();
       ControllerRead controllerRead = new ControllerRead();
       
        if (args.length > 0) {
            String path = (args[0]); 
            resultado = controllerRead.lerArquivo(path);
            retorno = controllerExecuta.executa(resultado);
            
        }
       
            controllerWrite = new ControllerWriteHTML();
            controllerWrite.write(retorno);
  
             controllerWrite = new ControllerWriteJson();
            controllerWrite.write(retorno);
        
    }
}
