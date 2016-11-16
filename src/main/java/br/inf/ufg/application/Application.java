package br.inf.ufg.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.github.kyriosdata.parser.Expressao;
import com.github.kyriosdata.parser.Lexer;
import com.github.kyriosdata.parser.Parser;
import com.github.kyriosdata.parser.Token;

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
            executa(operacoes.get(i));    
        }
        
    }

    public static void lerArquivoNet(final String path) throws IOException {
       
        readFileNet = new ReadFileNet(path);
        operacoes = readFileNet.read();
        for (int i = 0; i < operacoes.size(); i++) {
           executa(operacoes.get(i));    
        }
    }

    /**
     * @param expr expressao de calculo
     * @return valor da expressao
     */
     public final static float calculaValor(final String expr) {
        Expressao expressao = exprPara(expr);
        return expressao.valor();
     }
    /**
     * @param expressao expressao para calculo
     * @return expressao
     */
     private static Expressao exprPara(final String expressao) {
        List<Token> tokens = new Lexer(expressao).tokenize();
        Parser parser = new Parser(tokens);
        return parser.expressao();
     }

     /**
     * @param expr
     * expressao a ser executada
     */
    public final static void executa(final String expr) {
       try {
           float valor = calculaValor(expr);
           System.out.println(valor);
           
       } catch (IllegalArgumentException ex) {
           System.out.println(ex.getMessage());
           
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
