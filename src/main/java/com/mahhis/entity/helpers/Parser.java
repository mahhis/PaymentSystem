package com.mahhis.entity.helpers;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Parser {

    private static final String URLforAPItoGetCardInformation = "https://api.freebinchecker.com/bin/";

    public static String information(long numberCard, String jsonObject, String fieldName){

        URL url;
        HttpURLConnection httpURLConnection;
        OutputStream os = null;
        InputStreamReader isR = null;
        BufferedReader bfR =null;
        StringBuilder stringBuilder = new StringBuilder();

        String result = null;

        try {
            Map<String, Long> bin = new HashMap<>();

            bin.put("bin",numberCard);

            byte[] out = bin.toString().getBytes();


            url = new URL(URLforAPItoGetCardInformation+numberCard);
            httpURLConnection =(HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            httpURLConnection.addRequestProperty("User-Agent", "Mozilla/5.0");
            httpURLConnection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            httpURLConnection.setConnectTimeout(200);
            httpURLConnection.setReadTimeout(200);
            httpURLConnection.connect();

            try {
                os = httpURLConnection.getOutputStream();
                os.write(out);
            } catch (Exception e){
                System.err.print(e.getMessage());
            }
            if(HttpURLConnection.HTTP_OK == httpURLConnection.getResponseCode()){
                isR = new InputStreamReader(httpURLConnection.getInputStream());
                bfR = new BufferedReader(isR);
                String line;
                while ((line=bfR.readLine()) != null){
                    stringBuilder.append(line);
                }
            }
            String jsonString = stringBuilder.toString();
            JSONObject obj = new JSONObject(jsonString);
            result = obj.getJSONObject(jsonObject).getString(jsonString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.print(e.getMessage());
        }
        return result;
    }
}
