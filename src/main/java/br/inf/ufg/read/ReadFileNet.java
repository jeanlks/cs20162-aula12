/*
 * Copyright (c) 2016. Jean Lucas Monte Carvalho
 * Creative Commons Attribution 4.0 International License.
 */

package br.inf.ufg.read;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class ReadFileNet implements ReadFileInterface{

    String separator = ";";
    ArrayList<String[]> textData = new ArrayList<String[]>();
    private String httpAddress;

    public ReadFileNet(String file_path) {
        httpAddress = file_path;

    }

    @Override
    public ArrayList<String[]> read() throws IOException {
        URL url = new URL(httpAddress);

        BufferedReader textReader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        
        while ((line = textReader.readLine()) != null) {
            String[] output = line.split(separator);
            
                textData.add(output);
            
        }

        textReader.close();
        return textData;   
      
}
}