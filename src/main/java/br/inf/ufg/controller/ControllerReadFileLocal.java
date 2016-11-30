/*
 * Copyright (c) 2016. Jean Lucas Monte Carvvalho
 * Creative Commons Attribution 4.0 International License.
 */

package br.inf.ufg.controller;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import br.inf.ufg.read.ReadFileInterface;


/**
 * @author Jean
 * Classe para leitura de arquivo local.
 */
public class ControllerReadFileLocal implements ReadFileInterface {
    private String separator = ";";
    private List<String[]> textData = new ArrayList<String[]>();
    private String path;
    private FileReader fr;
    private BufferedReader textReader;
    public ControllerReadFileLocal(final String filePath) {
        path = filePath;
    }

    /**
     *Metodo de ler arquivo locais.
     */
    @Override
    public final List<String[]> read()
                        throws IOException {
        try {
        fr = new FileReader(path);
        textReader = new BufferedReader(fr);
        String line;
        while ((line = textReader.readLine()) != null ) {
            String[] output = line.split(separator);
            if(output.length==3){    
            textData.add(output);
            }
        } }
        catch (IOException e) {
           System.out.println("Arquivo não encontrado");
          throw new IOException(e);
        }
        finally {
            fr.close();
            textReader.close();
        }
        
        return textData;

    }
}
