/*
 * Copyright (c) 2016. Jean Lucas Monte Carvalho
 * Creative Commons Attribution 4.0 International License.
 */

package br.inf.ufg.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.kyriosdata.parser.Lexer;
import com.github.kyriosdata.parser.Parser;
import com.github.kyriosdata.parser.Token;

import br.inf.ufg.model.Retorno;

public class ControllerExecuta {
    Retorno retorno;
    Map<String, Float> ctx = new HashMap<>();
    String[] variaveis;
    String separador = ",";
    String[] valores;
    Float resultadoEsperado;
    ControllerRetorno controllerRetorno = new ControllerRetorno();;

    public ControllerRetorno executa(ArrayList<String[]> resultado) {
        for (int i = 0; i < resultado.size(); i++) {
            calcula(resultado.get(i)[0], resultado.get(i)[1], Float.valueOf(resultado.get(i)[2]));

        }
        return controllerRetorno;
    }

    public ArrayList<Retorno> calcula(final String expr, final String variaveis, final Float resultadoEsperado) {
        float precisao = (float) 0.00000001;
        this.resultadoEsperado = resultadoEsperado;
        if (variaveis.length() != 0) {
            this.variaveis = variaveis.split(separador);
            for (int i = 0; i < this.variaveis.length; i++) {
                valores = this.variaveis[i].split("=");
                ctx.put(valores[0], Float.valueOf(valores[1]));
            }
        }

        List<Token> tokens = new Lexer(expr).tokenize();
        Parser parser = new Parser(tokens);
        float resultado = parser.expressao().valor(ctx);
        
        if (Math.abs(resultado - this.resultadoEsperado) > precisao) {
            retorno = new Retorno(expr, resultado, resultadoEsperado, 1);
            controllerRetorno.add(retorno);
            return controllerRetorno.getListaRetorno();
        } else {

            retorno = new Retorno(expr, resultado, resultadoEsperado, 0);
            controllerRetorno.add(retorno);
            return controllerRetorno.getListaRetorno();
        }

    }

}
