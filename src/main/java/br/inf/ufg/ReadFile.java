package br.inf.ufg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
    ArrayList<String> textData = new ArrayList<String>();
    private String path;
    public ReadFile(String file_path){
        path = file_path;
    }
    
    public ArrayList<String> OpenFile() throws IOException{
        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);
        String line;
        while((line = textReader.readLine())!=null){
            textData.add(line);
        }
        
       textReader.close();
       return textData;
    }
}
