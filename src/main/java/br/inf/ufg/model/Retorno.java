/*
 * Copyright (c) 2016. Jean Lucas Monte Carvalho
 * Creative Commons Attribution 4.0 International License.
 */

package br.inf.ufg.model;


/**
 * @author Jean
 * Classe modelo para gravacao dos resultados.
 */
public class Retorno {
    /**
     * expressao.
     */
    private String expr;

    /**
     * valor do resultado.
     */
    private Float valorResultado;

    /**
     * valor esperado.
     */
    private Float valorEsperado;

    /**
     * codigo do erro.
     */
    private int codigoErro;

    /**
     *
     * @return expressao.
     */
    public final String getExpr() {
        return expr;
    }

    /**
     *
     * @param exprParam expressao
     */
    public final void setExpr(final String exprParam) {
        this.expr = exprParam;
    }
    /**
     *
     * @return valor do resultado.
     */
    public final Float getValorResultado() {
        return valorResultado;
    }

    /**
     *
     * @param valorResultadoParam valor do resultado.
     */
    public final void setValorResultado(final Float valorResultadoParam) {
        this.valorResultado = valorResultadoParam;
    }

    /**
     *
     * @return valor esperado
     */
    public final Float getValorEsperado() {
        return valorEsperado;
    }

    /**
     *
     * @param valorEsperadoParam valor esperado.
     */
    public final void setValorEsperado(final Float valorEsperadoParam) {
        this.valorEsperado = valorEsperadoParam;
    }

    /**
     *
     * @return codigo de erro.
     */
    public final int getCodigoErro() {
        return codigoErro;
    }

    /**
     *
     * @param codigoErroParam codigo de erro.
     */
    public final void setCodigoErro(final int codigoErroParam) {
        this.codigoErro = codigoErroParam;
    }
    /**
     * Construtor vazio da classe.
     */
    public Retorno() {
    }

}
