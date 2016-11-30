/*
 * Copyright (c) 2016. Jean Lucas Monte Carvalho
 * Creative Commons Attribution 4.0 International License.
 */
package br.inf.ufg.controller;

import java.util.ArrayList;
import java.util.List;

import br.inf.ufg.model.Retorno;
/**
 * Implementação de controllerRetorno.
 *
 * Controller do retorno de expressoes ja calculadas.
 *
 */
public class ControllerRetorno {
    /**
     * lista de retorno de solucoes.
     */
    private List<Retorno> listaRetorno = new ArrayList<>();
    /**
     * variaveis de tempo decorrido e uso de memoria.
     */
    private Long tempoDecorrido, usoMemoria;
    /**
     * retorna uso de memoria.
     * @return o uso de memoria.
     */
    public final Long getUsoMemoria() {
        return usoMemoria;
    }
    /**
     * seta uso de memoria.
     * @param usoMemoriaParam uso de memoria.
     */
    public final void setUsoMemoria(final Long usoMemoriaParam) {
        this.usoMemoria = usoMemoriaParam;
    }
    /**
     *
     * @return tempo decorrido
     */
    public final Long getTempoDecorrido() {
        return tempoDecorrido;
    }
    /**
     *
     * @param tempoDecorridoParam tempo decorrido
     */
    public final void setTempoDecorrido(final Long tempoDecorridoParam) {
        this.tempoDecorrido = tempoDecorridoParam;
    }
    /**
     * @return lista de expressoes calculadas.
     */
    public final List<Retorno> getListaRetorno() {
        return listaRetorno;
    }
    /**
     * @param listaRetornoParam retorno de expressoes
     *                     ja calculadas e prontas
     *                     para serem escritas.
     */
   public final void setListaRetorno(final List<Retorno>
                                           listaRetornoParam) {
        this.listaRetorno = listaRetornoParam;
    }
    /**
     * @param retorno adiciona objeto retorno na lista.
     */

}
