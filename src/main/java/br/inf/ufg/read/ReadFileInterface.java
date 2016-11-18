/*
 * Copyright (c) 2016. Jean Lucas Monte Carvalho
 * Creative Commons Attribution 4.0 International License.
 */

package br.inf.ufg.read;

import java.io.IOException;

import java.util.ArrayList;
/**
 *
 * Interface para leitura de arquivos.
 */
public interface ReadFileInterface {
/**
 * @return arrayList com arquivo lido.
 * @throws IOException caso haja excessao
 *      ao ler arquivo.
 * Metodo para ler arquivo.
 */
 ArrayList<String[]> read() throws IOException;
}
