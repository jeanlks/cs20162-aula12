package br.inf.ufg.retorno;

import java.util.Map;

import com.google.gson.Gson;

import br.inf.ufg.model.Retorno;

public class RetornoJson implements RetornoInterface {

    @Override
    public void retorno(Retorno retorno) {
        Gson gson = new Gson();
        String json = gson.toJson(retorno.getMapRetorno());
        System.out.println(json);
        
       //Escrever em arquivo inves de printar
    }

}
