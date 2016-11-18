/*
 * Copyright (c) 2016. Jean Lucas Monte Carvalho
 * Creative Commons Attribution 4.0 International License.
 */

package br.inf.ufg.controller;

import com.google.gson.Gson;
import java.io.PrintWriter;
import java.util.ArrayList;
import br.inf.ufg.model.Retorno;
import br.inf.ufg.write.WriteInterface;

/**
 * @author Jean
 * Classe controller para escrita de arquivo .json 
 *  com resultados.
 */
public class ControllerWriteJson implements WriteInterface {
    /**
     * @param listaRetorno
     *        lista para escrever no arquivo json 
     */
    @Override
    public void write(final ArrayList<Retorno> listaRetorno) {
        Gson gson = new Gson();
        String json = gson.toJson(listaRetorno);
        try{
            PrintWriter writer = new PrintWriter("resultadoJson.json", "UTF-8");
            writer.println(json);
            writer.close();
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
    }
    


 

}
