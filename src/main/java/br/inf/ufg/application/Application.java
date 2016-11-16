package br.inf.ufg.application;

import java.io.IOException;
import java.util.ArrayList;

import br.inf.ufg.read.ReadFileLocal;
import br.inf.ufg.read.ReadFileNet;

public class Application {
    static ArrayList<String> operacoes = new ArrayList<>();
    static ReadFileLocal readFile;
    static ReadFileNet readFileNet;
    public static void lerArquivoLocal(final String path) throws IOException {
        readFile = new ReadFileLocal(path);
        operacoes = readFile.read();
        for (int i = 0; i < operacoes.size(); i++) {
            System.out.println(operacoes.get(i));    
        }
        
    }

    public static void lerArquivoNet(final String path) throws IOException {
       
        readFileNet = new ReadFileNet(path);
        operacoes = readFileNet.read();
        for (int i = 0; i < operacoes.size(); i++) {
            System.out.println(operacoes.get(i));    
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            String path = (args[0]);

            if (path.contains("http")) {
                lerArquivoNet(path);
            } else {
                lerArquivoLocal(path);
            }

        }

    }
}
