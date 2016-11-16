package br.inf.ufg.application;

import java.io.IOException;
import java.util.ArrayList;

import br.inf.ufg.read.ReadFile;

public class Application {

    public static void lerArquivoLocal(String path) throws IOException {
        ReadFile rf = new ReadFile(path);
        ArrayList<String[]> listaDeExpressoes = new ArrayList<String[]>();
        ArrayList<String> lines = rf.OpenFile();
        for (int i = 0; i < lines.size(); i++) {
            listaDeExpressoes.add(lines.get(i).split(";"));
        }

        for (int i = 0; i < listaDeExpressoes.size(); i++) {
            for (int j = 0; j < listaDeExpressoes.get(i).length; j++) {
                System.out.println(listaDeExpressoes.get(i)[j]);

            }
        }

    }

    public static void lerArquivoNet(String path) {
        System.out.println(path);
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
