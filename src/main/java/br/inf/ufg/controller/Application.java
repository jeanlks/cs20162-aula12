/*
 * Copyright (c) 2016. Jean Lucas Monte Carvalho
 * Creative Commons Attribution 4.0 International License.
 */

package br.inf.ufg.controller;

import java.io.IOException;
import java.util.ArrayList;


/*
 * Classe de execução da aplicação.
 */
public class Application {
    static ControllerExecuta controllerExecuta;
    static ArrayList<String[]> resultado = new ArrayList<String[]>();
    public static void main(String[] args) throws IOException {
        controllerExecuta = new ControllerExecuta();
       ControllerRead controllerRead = new ControllerRead();
        if (args.length > 0) {
            String path = (args[0]);
            
            resultado = controllerRead.lerArquivo(path);
            controllerExecuta.executa(resultado);
        }
        
    }
}
