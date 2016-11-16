package br.inf.ufg.read;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class ReadFile {
    ArrayList<String> textData = new ArrayList<String>();
    private String path;
    
    public ReadFile(String file_path){
        path = file_path;
        
    }
    
    public ArrayList<String> OpenFile() throws IOException{
        BufferedReader textReader;
        if(path.contains("http")){
        URL url = new URL(path);    
        textReader = new BufferedReader(
                new InputStreamReader(url.openStream()));
        }
        else{
        FileInputStream fr = new FileInputStream(path);
         textReader = new BufferedReader(new InputStreamReader(fr));
        
        }
        String line;
        while((line = textReader.readLine())!=null){
            textData.add(line);
        }
        
       textReader.close();
       return textData;
    }
}
