package br.inf.ufg.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.kyriosdata.parser.Lexer;
import com.github.kyriosdata.parser.Parser;
import com.github.kyriosdata.parser.Token;

import br.inf.ufg.model.Retorno;
import br.inf.ufg.retorno.RetornoJson;

public class ControllerExecuta {
    Retorno retorno = new Retorno();
    Map<String, Float> ctx = new HashMap<>();
    String[] variaveis;
    String separador = ",";
    String[] valores;
    Float resultadoEsperado;

    public void executa(ArrayList<String[]> resultado){
        for (int i = 0; i < resultado.size(); i++) {
            calcula(resultado.get(i)[0], resultado.get(i)[1], resultado.get(i)[2]);
          
         }
    }
    public void calcula(final String expr,final String variaveis,final String resultadoEsperado) {
        this.resultadoEsperado = Float.valueOf(resultadoEsperado);
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
        if (resultado != this.resultadoEsperado) {
            retorno.addRetorno(expr, resultado);
            RetornoJson json = new RetornoJson();
            json.retorno(retorno);
        }
    }

    public void calcula() {

    }
}