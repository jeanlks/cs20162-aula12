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

/**
 *@author Jean
 * Classe controller para execução dos calculos.
 */
public class ControllerExecuta {
   private Retorno retorno;
   private  Map<String, Float> ctx = new HashMap<>();
   private String[] variaveis;
   private String separador = ",";
   private String[] valores;
   private Float resultadoEsperado;
   private final float precisao = (float) 0.00000001;
   private ArrayList<Retorno> listaRetorno = new ArrayList<>();
   private  ControllerRetorno controllerRetorno;
   private final int CODIGO_RETORNO_SUCESSO = 0;
   private final int CODIGO_RETORNO_ERRADO = 1;
    /**
     * @param resultado lista de expressoes
     *                  para calculo
     * @return retorna uma lista de solucoes
     *         para as expressoes e
     *         impressao posterior.
     */
    public final ArrayList<Retorno> executa(
                                final ArrayList<String[]> resultado) {
        for (int i = 0; i < resultado.size(); i++) {
            calcula(resultado.get(i)[0], resultado.get(i)[1],
                            Float.valueOf(resultado.get(i)[2]));

        }
        return listaRetorno;
    }
    /**
     * @param expr expressão para cálculo.
     * @param variaveisAtbr variaveis de atribuicao.
     * @param resultadoEsperadoExpr resultado esperado pelo teste.
     * @return retorna lista de expressoes calculadas.
     */
    public final ArrayList<Retorno> calcula(final String expr,
                                      final String variaveisAtbr,
                                      final Float resultadoEsperadoExpr) {
        controllerRetorno = new ControllerRetorno();
        retorno = new Retorno();
        this.resultadoEsperado = resultadoEsperadoExpr;
        if (variaveisAtbr.length() != 0) {
            this.variaveis = variaveisAtbr.split(separador);
            for (int i = 0; i < this.variaveis.length; i++) {
                valores = this.variaveis[i].split("=");
                ctx.put(valores[0], Float.valueOf(valores[1]));
            }
        }

        List<Token> tokens = new Lexer(expr).tokenize();
        Parser parser = new Parser(tokens);
        float resultado = parser.expressao().valor(ctx);
        if (Math.abs(resultado - this.resultadoEsperado) > precisao) {
            retorno.setExpr(expr);
            retorno.setValorEsperado(resultadoEsperadoExpr);
            retorno.setValorResultado(resultado);
            retorno.setCodigoErro(CODIGO_RETORNO_ERRADO);
            listaRetorno.add(retorno);
            return controllerRetorno.getListaRetorno();
        } else {

            retorno.setExpr(expr);
            retorno.setValorEsperado(resultadoEsperadoExpr);
            retorno.setValorResultado(resultado);
            retorno.setCodigoErro(CODIGO_RETORNO_SUCESSO);
            
            listaRetorno.add(retorno);
            return controllerRetorno.getListaRetorno();
        }

    }

}
