/*
 * Copyright (c) 2016. Jean Lucas Monte Carvalho
 * Creative Commons Attribution 4.0 International License.
 */

package br.inf.ufg.controller;

import com.google.gson.Gson;
import java.io.PrintWriter;


import br.inf.ufg.model.Retorno;
import br.inf.ufg.write.WriteInterface;

public class ControllerWriteJson implements WriteInterface {

   
    
    @Override
    public void write(Retorno retorno) {
        Gson gson = new Gson();
        String json = gson.toJson(retorno.getMapRetorno());
        System.out.println(json);
        
        try{
            PrintWriter writer = new PrintWriter("resultadoJson.txt", "UTF-8");
            writer.println(json);
            writer.close();
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
    }
    


 

}
