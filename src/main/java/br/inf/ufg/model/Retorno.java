/*
 * Copyright (c) 2016. Jean Lucas Monte Carvalho
 * Creative Commons Attribution 4.0 International License.
 */

package br.inf.ufg.model;

import java.util.HashMap;
import java.util.Map;

public class Retorno {
    private String expr;
    private Float valorResultado;
    private Float valorEsperado;
    private int codigoErro;

    public String getExpr() {
        return expr;
    }

    public void setExpr(String expr) {
        this.expr = expr;
    }

    public Float getValorResultado() {
        return valorResultado;
    }

    public void setValorResultado(Float valorResultado) {
        this.valorResultado = valorResultado;
    }

    public Float getValorEsperado() {
        return valorEsperado;
    }

    public void setValorEsperado(Float valorEsperado) {
        this.valorEsperado = valorEsperado;
    }

    public int getCodigoErro() {
        return codigoErro;
    }

    public void setCodigoErro(int codigoErro) {
        this.codigoErro = codigoErro;
    }

    public Retorno(String expr, Float valorResultado, Float valorEsperado, int codigoErro) {
        super();
        this.expr = expr;
        this.valorResultado = valorResultado;
        this.valorEsperado = valorEsperado;
        this.codigoErro = codigoErro;
    }

    // private Map<String, Float> mapRetorno = new HashMap<String, Float>();
    //
    // public Retorno() {
    // super();
    //
    // }
    //
    //
    // public Map<String, Float> getMapRetorno() {
    // return mapRetorno;
    // }
    //
    // public void setMapRetorno(Map<String, Float> mapRetorno) {
    // this.mapRetorno = mapRetorno;
    // }
    //
    // public void addRetorno(String operacao, float resultado){
    // this.mapRetorno.put(operacao, resultado);
    // }
    //

}
