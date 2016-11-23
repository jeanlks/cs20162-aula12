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


/**
 * @author Jean
 * Classe de execução da aplicação.
 */
public class Application {
    private static ControllerExecuta controllerExecuta;
    private static ArrayList<String[]> resultado =
                         new ArrayList<String[]>();
    private static WriteInterface controllerWrite;
    private static ControllerRetorno controllerRetorno;
    private static Long tempoInicial,tempoFinal,usoMemoria;
   
    private static Runtime runtime;
    
    public static void main(final String[] args)
                            throws IOException {
        ControllerRead controllerRead = new ControllerRead();
        controllerExecuta = new ControllerExecuta();
        controllerRetorno = new ControllerRetorno();
        runtime = Runtime.getRuntime();
        
        if (args.length > 0) {
            String path = (args[0]);
            tempoInicial = System.currentTimeMillis();
            resultado = controllerRead.lerArquivo(path);
            controllerRetorno.setListaRetorno(controllerExecuta.executa(resultado));
            tempoFinal = System.currentTimeMillis();
            controllerRetorno.setTempoDecorrido(tempoFinal-tempoInicial);
            usoMemoria = runtime.totalMemory() - runtime.freeMemory();
            
        }
          if (args.length == 1) {
              controllerWrite = new ControllerWriteJson();
              controllerWrite.write(controllerRetorno.getListaRetorno(),
                                    controllerRetorno.getTempoDecorrido(),
                                    controllerRetorno.getUsoMemoria());
              System.out.println("Gerado Arquivo Json em:");
              System.out.println(System.getProperty("user.dir").toString());
          } else if (args.length > 1) {
              if ("-h".equals(args[1])) {
                  controllerWrite = new ControllerWriteHTML();
                  controllerWrite.write(controllerRetorno.getListaRetorno(),
                                        controllerRetorno.getTempoDecorrido(),
                                        controllerRetorno.getUsoMemoria());
                  System.out.println("Gerado Arquivo HTML em:");
                  System.out.println(System.getProperty("user.dir").toString());
              }else{
                  System.out.println("Argumento errado");
              }
          }
    }
}
