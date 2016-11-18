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
    private String expr;
    private Float valorResultado;
    private Float valorEsperado;
    private int codigoErro;

    public final String getExpr() {
        return expr;
    }

    public final void setExpr(String expr) {
        this.expr = expr;
    }

    public final Float getValorResultado() {
        return valorResultado;
    }

    public final void setValorResultado(final Float valorResultado) {
        this.valorResultado = valorResultado;
    }

    public final Float getValorEsperado() {
        return valorEsperado;
    }

    public final void setValorEsperado(final Float valorEsperado) {
        this.valorEsperado = valorEsperado;
    }

    public final int getCodigoErro() {
        return codigoErro;
    }

    public final void setCodigoErro(final int codigoErro) {
        this.codigoErro = codigoErro;
    }

    public Retorno(final String exprParam,
                   final Float valorResultadoParam,
                   final Float valorEsperadoParam,
                   final int codigoErroParam) {
        super();
        this.expr = exprParam;
        this.valorResultado = valorResultadoParam;
        this.valorEsperado = valorEsperadoParam;
        this.codigoErro = codigoErroParam;
    }

}
