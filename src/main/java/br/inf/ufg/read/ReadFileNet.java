package br.inf.ufg.read;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class ReadFileNet implements ReadFile{

    String separator = ";";
    ArrayList<String> textData = new ArrayList<String>();
    private String HTTP_ADDRESS;

    public ReadFileNet(String file_path) {
        HTTP_ADDRESS = file_path;

    }

    @Override
    public ArrayList<String> read() throws IOException {
        URL url = new URL(HTTP_ADDRESS);

        BufferedReader textReader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        
        while ((line = textReader.readLine()) != null) {
            String[] output = line.split(separator);
            for (int i = 0; i < output.length; i++) {
                textData.add(output[i]);
            }
        }

        textReader.close();
        return textData;   
      
}
}