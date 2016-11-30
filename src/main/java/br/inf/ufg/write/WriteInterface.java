/*
 * Copyright (c) 2016. Jean Lucas Monte Carvalho
 * Creative Commons Attribution 4.0 International License.
 */

package br.inf.ufg.write;


import java.io.IOException;
import java.util.List;

import br.inf.ufg.model.Retorno;
/**
 *
 * Interface para escrita de arquivos.
 */
@FunctionalInterface
public interface WriteInterface  {
    /**
     * @param listaRetorno lista de retorno para
     * escrita no arquivo.
     * Escreve arquivo em json ou html dependendo da
     * entrada do usuario.
     * @param usoMemoria uso de Memoria.
     * @param tempoDecorrido tempo decorrido.
     * @throws IOException caso haja algum problema
     */
    void write(List<Retorno> listaRetorno,
            Long tempoDecorrido,
            Long usoMemoria) throws IOException;
}
