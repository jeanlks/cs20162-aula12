/*
 * Copyright (c) 2016. Jean Lucas Monte Carvalho
 * Creative Commons Attribution 4.0 International License.
 */

package br.inf.ufg.write;


import java.io.IOException;
import java.util.ArrayList;

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
     * @throws caso haja algum problema
     */
    void write(ArrayList<Retorno> listaRetorno,Long tempoDecorrido) throws IOException;
}
