package br.inf.ufg;

import java.io.IOException;
import java.util.ArrayList;

public class Application {

    public static void main(String[] args) throws IOException {
       ReadFile rf = new ReadFile("/Users/Jean/Documents/test.txt");
       ArrayList<String[]> listaDeExpressoes = new ArrayList<String[]>();
       ArrayList<String> lines = rf.OpenFile();
       for(int i =0;i<lines.size();i++){
           listaDeExpressoes.add(lines.get(i).split(";"));
       }
       
       for(int i = 0; i< listaDeExpressoes.size();i++){
           for(int j=0; j<listaDeExpressoes.get(i).length;j++){
               System.out.println(listaDeExpressoes.get(i)[j]);
           }
       }
    }
    
   

}
