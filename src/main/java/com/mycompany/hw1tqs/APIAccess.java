/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw1tqs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;

/**
 *
 * @author Carlos Soares
 */
public class APIAccess {

    public JSONObject getData() {
        String sURL = "http://www.apilayer.net/api/live?access_key=1e53ee3ddd8c07ab8068ea95519d054b";
        String info = "";
        HttpURLConnection request = null;
        BufferedReader reader = null;
        String line;
        // Connect to the URL using java's native library
        try {
            URL url = new URL(sURL);
            request = (HttpURLConnection) url.openConnection();
            request.connect();
            InputStream inputStream = request.getInputStream();
            StringBuilder buffer = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = reader.readLine()) != null) {
                buffer.append(line).append("\n");
            }
            info = buffer.toString();
        } catch (IOException e) {
            info = null;
        }
        request.disconnect();
        if (info == null) {info=importData();
        } else {
            saveData(info);
        }
        return new JSONObject(info);
    }
    
    public String importData(){
        try {
                byte[] encoded = Files.readAllBytes(Paths.get("C:\\Users\\Carlos Soares\\Documents\\NetBeansProjects\\HW1TQS\\cache.txt"));
                return new String(encoded, "utf-8");
            } catch (IOException ex) {
                
                return null;
            }
    }
    public void saveData(String info){
        try {   
                Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\Carlos Soares\\Documents\\NetBeansProjects\\HW1TQS\\cache.txt"), "utf-8"));
                writer.write(info);
                writer.close();
            } catch (IOException ex) {
                System.out.println("IOException Found");
            }
    }
}
