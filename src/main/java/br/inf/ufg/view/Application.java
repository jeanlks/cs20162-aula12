/*
 * Copyright (c) 2016. Jean Lucas Monte Carvalho
 * Creative Commons Attribution 4.0 International License.
 */

package br.inf.ufg.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.inf.ufg.controller.ControllerExecuta;
import br.inf.ufg.controller.ControllerRead;
import br.inf.ufg.controller.ControllerRetorno;
import br.inf.ufg.controller.ControllerWriteHTML;
import br.inf.ufg.controller.ControllerWriteJson;
import br.inf.ufg.write.WriteInterface;


/**
 * @author Jean
 * Classe de execução da aplicação.
 */
public final class Application {

    /**
     * Construtor.
     */
    public Application() {

    }
    /**
     * Controlador de execução de expressoes.
     */
    private static ControllerExecuta controllerExecuta;

    /**
     * resultados de expressoes.
     */
    private static List<String[]> resultado =
                         new ArrayList<String[]>();

    /**
     * Controlador de escrita.
     */
    private static WriteInterface controllerWrite;

    /**
     * Controlador de retorno.
     */
    private static ControllerRetorno controllerRetorno;

    /**
     * Variaveis de informação.
     */
    private static Long tempoInicial, tempoFinal, usoMemoria;

    /**
     * Runtime para leitura de memoria de maquina virtual.
     */
    private static Runtime runtime;

    /**
     * Metodo Main.
     * @param args argumentos de caminho e parametros.
     * @throws IOException caso haja excessao de algum modo.
     */
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
            controllerRetorno.setListaRetorno(
                    controllerExecuta.executa(resultado));
            tempoFinal = System.currentTimeMillis();
            controllerRetorno.setTempoDecorrido(tempoFinal - tempoInicial);
            usoMemoria = runtime.totalMemory() - runtime.freeMemory();
        }
          if (args.length == 1) {
              controllerWrite = new ControllerWriteJson();
              controllerWrite.write(controllerRetorno.getListaRetorno(),
                                    controllerRetorno.getTempoDecorrido(),
                                    controllerRetorno.getUsoMemoria());
              System.out.println("Gerado Arquivo Json em:");
              System.out.println(System.getProperty("user.dir"));
          } else if (args.length > 1) {
              if ("-h".equals(args[1])) {
                  controllerWrite = new ControllerWriteHTML();
                  controllerWrite.write(controllerRetorno.getListaRetorno(),
                                        controllerRetorno.getTempoDecorrido(),
                                        controllerRetorno.getUsoMemoria());
                  System.out.println("Gerado Arquivo HTML em:");
                  System.out.println(System.getProperty("user.dir"));
              } else {
                  System.out.println("Argumento errado");
              }
          }
    }
}
