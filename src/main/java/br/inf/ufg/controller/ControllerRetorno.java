package br.inf.ufg.controller;

import java.util.ArrayList;

import br.inf.ufg.model.Retorno;

public class ControllerRetorno {
    private ArrayList<Retorno> listaRetorno = new ArrayList<>();

    public ArrayList<Retorno> getListaRetorno() {
        return listaRetorno;
    }

    public void setListaRetorno(ArrayList<Retorno> listaRetorno) {
        this.listaRetorno = listaRetorno;
    }
    public void add(Retorno retorno){
        listaRetorno.add(retorno);
      
    }
}
