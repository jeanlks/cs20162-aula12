package br.inf.ufg.controller;

import java.io.IOException;
import java.util.ArrayList;

import br.inf.ufg.model.Retorno;
import br.inf.ufg.read.ReadFileInterface;
import br.inf.ufg.read.ReadFileLocal;
import br.inf.ufg.read.ReadFileNet;

public class ControllerRead {
    ReadFileInterface readFile;
    ArrayList<String[]> resultado = new ArrayList<String[]>();

    public ArrayList<String[]> lerArquivo(String path) throws IOException {
        if (path.contains("http")) {
          return  lerArquivoNet(path);
        } else {
          return  lerArquivoLocal(path);
        }
    }

    public ArrayList<String[]> lerArquivoLocal(final String path) throws IOException {

        readFile = new ReadFileLocal(path);
        resultado = readFile.read();
        return resultado;
    }

    public ArrayList<String[]> lerArquivoNet(final String path) throws IOException {

        readFile = new ReadFileNet(path);
        resultado = readFile.read();
        return resultado;
    }

}