/*
 * Copyright (c) 2016. Jean Lucas Monte Carvalho
 * Creative Commons Attribution 4.0 International License.
 */

package br.inf.ufg.view;

import java.io.IOException;
import java.util.ArrayList;

import br.inf.ufg.controller.ControllerExecuta;
import br.inf.ufg.controller.ControllerRead;
import br.inf.ufg.model.Retorno;
import br.inf.ufg.retorno.RetornoJson;


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
            Retorno retorno = controllerExecuta.executa(resultado);
            RetornoJson json = new RetornoJson();
            json.retorno(retorno);
        }
        
    }
}
