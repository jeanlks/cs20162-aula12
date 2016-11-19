/*
 * Copyright (c) 2016. Jean Lucas Monte Carvalho
 * Creative Commons Attribution 4.0 International License.
 */
package br.inf.ufg.controller;

import java.util.ArrayList;

import br.inf.ufg.model.Retorno;
/**
 * Implementação de controllerRetorno.
 *
 * Controller do retorno de expressoes ja calculadas.
 *
 */
public class ControllerRetorno {
    private ArrayList<Retorno> listaRetorno = new ArrayList<>();
    private Long tempoDecorrido,usoMemoria;
    
    
    public Long getUsoMemoria() {
        return usoMemoria;
    }
    public void setUsoMemoria(Long usoMemoria) {
        this.usoMemoria = usoMemoria;
    }
    /**
     * 
     * @return tempo decorrido
     */
    public Long getTempoDecorrido() {
        return tempoDecorrido;
    }
    /**
     * 
     * @param tempoDecorridoParam
     */
    public void setTempoDecorrido(final Long tempoDecorridoParam) {
        this.tempoDecorrido = tempoDecorridoParam;
    }
    /**
     * @return lista de expressoes calculadas.
     */
    public final ArrayList<Retorno> getListaRetorno() {
        return listaRetorno;
    }
    /**
     * @param listaRetornoParam retorno de expressoes
     *                     ja calculadas e prontas
     *                     para serem escritas.
     */
   public final void setListaRetorno(final ArrayList<Retorno>
                                           listaRetornoParam) {
        this.listaRetorno = listaRetornoParam;
    }
    /**
     * @param retorno adiciona objeto retorno na lista.
     */

}
