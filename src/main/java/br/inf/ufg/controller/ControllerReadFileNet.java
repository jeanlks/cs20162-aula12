/*
 * Copyright (c) 2016. Jean Lucas Monte Carvalho
 * Creative Commons Attribution 4.0 International License.
 */

package br.inf.ufg.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import br.inf.ufg.read.ReadFileInterface;


/**
 * @author Jean
 * Classe controller leitura de arquivo da internet.
 */
public class ControllerReadFileNet implements ReadFileInterface {
    private String separator = ";";
    private ArrayList<String[]> textData = new ArrayList<String[]>();
    private String httpAddress;
    BufferedReader textReader;
    public ControllerReadFileNet(final String filePath) {
        httpAddress = filePath;
    }
    @Override
    public final ArrayList<String[]> read() throws IOException {
        URL url = new URL(httpAddress);
       try{
         textReader = new BufferedReader(
                       new InputStreamReader(url.openStream()));
        String line;
        while ((line = textReader.readLine()) != null) {
            
            String[] output = line.split(separator);
            
            if(output.length==3){  
            textData.add(output);
            }
        }}
        catch (IOException e) {
           System.out.println("Arquivo não encontrado");
           throw new IOException(e);
         }finally {
            textReader.close(); 
        }
        
        return textData;
}
}
