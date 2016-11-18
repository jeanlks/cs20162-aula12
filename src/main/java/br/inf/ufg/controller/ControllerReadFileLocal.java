/*
 * Copyright (c) 2016. Jean Lucas Monte Carvvalho
 * Creative Commons Attribution 4.0 International License.
 */

package br.inf.ufg.controller;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

import br.inf.ufg.read.ReadFileInterface;


/**
 * @author Jean
 * Classe para leitura de arquivo local.
 */
public class ControllerReadFileLocal implements ReadFileInterface {
    private String separator = ";";
    private ArrayList<String[]> textData = new ArrayList<String[]>();
    private String path;

    public ControllerReadFileLocal(final String filePath) {
        path = filePath;
    }

    /**
     *Metodo de ler arquivo locais.
     */
    @Override
    public final ArrayList<String[]> read()
                        throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);
        String line;
        while ((line = textReader.readLine()) != null) {
            String[] output = line.split(separator);
                textData.add(output);
        }
        textReader.close();
        return textData;

    }
}