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
 *
 * Classe para leitura de arquivo local.
 */
public class ControllerReadFileLocal implements ReadFileInterface {

    /**
     * separador de strings.
     */
    private String separator = ";";

    /**
     * Lista de retorno do texto.
     */
    private List<String[]> textData = new ArrayList<String[]>();

    /**
     * local do arquivo.
     */
    private String path;

    /**
     * leitor do arquivo.
     */
    private FileReader fr;

    /**
     * buffer para leitura.
     */
    private BufferedReader textReader;

    /**
     * Construtor da classe.
     * @param filePath local do arquivo
     */
    public ControllerReadFileLocal(final String filePath) {
        path = filePath;
    }

    /**
     *Metodo de ler arquivo locais.
     */
    @Override
    public final List<String[]> read()
                        throws IOException {
        final int numeroParams = 3;
        try {
        fr = new FileReader(path);
        textReader = new BufferedReader(fr);
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
            fr.close();
            textReader.close();
        }
        return textData;

    }
}
