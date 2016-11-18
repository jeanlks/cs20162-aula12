/*
 * Copyright (c) 2016. Jean Lucas Monte Carvalho
 * Creative Commons Attribution 4.0 International License.
 */

package br.inf.ufg.controller;

import java.io.IOException;
import java.util.ArrayList;


import br.inf.ufg.read.ReadFileInterface;

/**
 *
 * @author Jean
 * Classe controller leitura dos arquivos sejam locais ou
 * pela internet.
 */
public class ControllerRead {
    private ReadFileInterface readFile;
    private ArrayList<String[]> resultado = new ArrayList<String[]>();
    /**
     *
     * @param path local do arquivo.
     * @return lista de expressoes
     *          para calculo.
     * @throws IOException caso haja excessao
     *                      ao ler arquivo.
     */
    public final ArrayList<String[]> lerArquivo(final String path)
                                        throws IOException {
        if (path.contains("http")) {
          return  lerArquivoNet(path);
        } else {
          return  lerArquivoLocal(path);
        }
    }
   /**
    * @param path local do arquivo.
    * @return lista de expressoes
     *          para calculo.
    * @throws IOException casa hoja excessao
    *                     ao ler arquivo.
    */
    public final ArrayList<String[]> lerArquivoLocal(final String path)
                                            throws IOException {
        readFile = new ControllerReadFileLocal(path);
        resultado = readFile.read();
        return resultado;
    }
    /**
     * @param path local do arquivo.
     * @return lista de expressoes
      *          para calculo.
     @throws IOException casa hoja excessao
     *                     ao ler arquivo.
     */
    public final ArrayList<String[]> lerArquivoNet(final String path)
                                            throws IOException {
        readFile = new ControllerReadFileNet(path);
        resultado = readFile.read();
        return resultado;
    }

}
