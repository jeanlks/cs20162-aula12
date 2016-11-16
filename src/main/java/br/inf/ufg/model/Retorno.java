package br.inf.ufg.model;

import java.util.HashMap;
import java.util.Map;

public class Retorno {
    private Map<String, Integer> mapRetorno = new HashMap<String, Integer>();

    public Retorno() {
        super();
       
    }
    
    
    public Map<String, Integer> getMapRetorno() {
        return mapRetorno;
    }

    public void setMapRetorno(Map<String, Integer> mapRetorno) {
        this.mapRetorno = mapRetorno;
    }
    
    public void addRetorno(String operacao, int valorRetorno){
       this.mapRetorno.put(operacao, valorRetorno);
    }
   

}
