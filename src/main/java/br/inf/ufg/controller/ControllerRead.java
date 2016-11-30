/*
 * Copyright (c) 2016. Jean Lucas Monte Carvalho
 * Creative Commons Attribution 4.0 International License.
 */

package br.inf.ufg.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.inf.ufg.read.ReadFileInterface;

/**
 *
 * @author Jean
 * Classe que faz a decisao de leitura de arquivos
 * via local ou via net.
 */
public class ControllerRead {

    /**
     * leitor de arquivo.
     */
    private ReadFileInterface readFile;

    /**
     * Lista de resultados de texto.
     */
    private List<String[]> resultado = new ArrayList<String[]>();
    /**
     *
     * @param path local do arquivo.
     * @return lista de expressoes
     *          para calculo.
     * @throws IOException caso haja excessao
     *                      ao ler arquivo.
     */
    public final List<String[]> lerArquivo(final String path)
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
    public final List<String[]> lerArquivoLocal(final String path)
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
    public final List<String[]> lerArquivoNet(final String path)
                                            throws IOException {
        readFile = new ControllerReadFileNet(path);
        resultado = readFile.read();
        return resultado;
    }

}
