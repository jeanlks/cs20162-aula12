/*
 * Copyright (c) 2016. Jean Lucas Monte Carvalho
 * Creative Commons Attribution 4.0 International License.
 */

package br.inf.ufg.controller;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import br.inf.ufg.model.Retorno;
import br.inf.ufg.write.WriteInterface;

/**
 * @author Jean
 * Classe controller para escrita de arquivo .json
 *  com resultados.
 */
public class ControllerWriteJson implements WriteInterface {
    private  PrintWriter writer;
    /**
     * @param listaRetorno
     *        lista para escrever no arquivo json
     * @throws UnsupportedEncodingException caso haja algum problema
     */
    @Override
    public final void write(final ArrayList<Retorno> listaRetorno,
                            final Long tempoDecorrido,
                            final Long usoMemoria) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(listaRetorno);
            writer = new PrintWriter("resultadoJson.json", "UTF-8");
            writer.println(json);
            writer.close();
            writer.close();    
    }

}
