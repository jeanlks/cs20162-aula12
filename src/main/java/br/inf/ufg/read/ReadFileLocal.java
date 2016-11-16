package br.inf.ufg.read;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class ReadFileLocal implements ReadFileInterface {
    String separator = ";";
    ArrayList<String> textData = new ArrayList<String>();
    private String path;

    public ReadFileLocal(String file_path) {
        path = file_path;

    }

    @Override
    public ArrayList<String> read() throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);
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
