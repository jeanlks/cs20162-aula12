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
import java.util.List;

import br.inf.ufg.read.ReadFileInterface;


/**
 * @author Jean
 * Classe controller leitura de arquivo da internet.
 */
public class ControllerReadFileNet implements ReadFileInterface {

    /**
     * separador de strings.
     */
    private String separator = ";";

    /**
     * dados do texto.
     */
    private List<String[]> textData = new ArrayList<String[]>();

    /**
     * endereço http.
     */
    private String httpAddress;

    /**
     * buffer de leitura.
     */
    private BufferedReader textReader;

    /**
     * Funcao para leitura do arquivo.
     * @param filePath endereço do arquivo.
     */
    public ControllerReadFileNet(final String filePath) {
        httpAddress = filePath;
    }

    @Override
    public final List<String[]> read() throws IOException {
        final int numeroParams = 3;
        URL url = new URL(httpAddress);
       try {
         textReader = new BufferedReader(
                       new InputStreamReader(url.openStream()));
        String line;
        while ((line = textReader.readLine()) != null) {
            String[] output = line.split(separator);
            if (output.length == numeroParams) {
            textData.add(output);
            }
        }
        } catch (IOException e) {
           System.out.println("Arquivo não encontrado");
           throw new IOException(e);
         } finally {
            textReader.close();
        }
        return textData;
}
}
