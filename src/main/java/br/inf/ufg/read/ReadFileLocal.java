/*
 * Copyright (c) 2016. Jean Lucas Monte Carvvalho
 * Creative Commons Attribution 4.0 International License.
 */

package br.inf.ufg.read;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

/*
 * Classe para leitura de arquivos locais.
 */
public class ReadFileLocal implements ReadFileInterface {
    String separator = ";";
    ArrayList<String[]> textData = new ArrayList<String[]>();
    private String path;

    public ReadFileLocal(String file_path) {
        path = file_path;

    }

    /**
     * 
     */
    @Override
    public ArrayList<String[]> read() throws IOException {
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
