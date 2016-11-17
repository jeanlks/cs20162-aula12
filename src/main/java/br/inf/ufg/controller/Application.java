/*
 * Copyright (c) 2016. Jean Lucas Monte Carvalho
 * Creative Commons Attribution 4.0 International License.
 */

package br.inf.ufg.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.github.kyriosdata.parser.Expressao;
import com.github.kyriosdata.parser.Lexer;
import com.github.kyriosdata.parser.Parser;
import com.github.kyriosdata.parser.Token;

import br.inf.ufg.model.Retorno;
import br.inf.ufg.read.ReadFileInterface;
import br.inf.ufg.read.ReadFileLocal;
import br.inf.ufg.read.ReadFileNet;
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
            controllerExecuta.executa(resultado);
        }
        
    }
}
