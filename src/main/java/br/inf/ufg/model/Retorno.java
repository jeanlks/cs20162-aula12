/*
 * Copyright (c) 2016. Jean Lucas Monte Carvalho
 * Creative Commons Attribution 4.0 International License.
 */

package br.inf.ufg.model;

import java.util.HashMap;
import java.util.Map;

public class Retorno {
    private Map<String, Float> mapRetorno = new HashMap<String, Float>();

    public Retorno() {
        super();
       
    }
    
    
    public Map<String, Float> getMapRetorno() {
        return mapRetorno;
    }

    public void setMapRetorno(Map<String, Float> mapRetorno) {
        this.mapRetorno = mapRetorno;
    }
    
    public void addRetorno(String operacao, float resultado){
       this.mapRetorno.put(operacao, resultado);
    }
   

}
