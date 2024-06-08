package com.example.trafficgenerator;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class App {
    public static void main(String[] args) {
        String url = "http://universities.hipolabs.com/search?name=bahcesehir";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String result = EntityUtils.toString(entity);
                JsonArray jsonArray = JsonParser.parseString(result).getAsJsonArray();
                System.out.println(jsonArray);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}