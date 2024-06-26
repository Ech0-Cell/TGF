package com.example.traffic_generate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;

public class ChfService {
    private static final String CHF_API_URL = "http://chf.api.url/usage"; // CHF API URL

    public void sendUsageRequest(String msisdn, String usageType) {
        try {
            String requestBody = String.format("{\"msisdn\": \"%s\", \"usageType\": \"%s\"}", msisdn, usageType);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(CHF_API_URL))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response: " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendDummyUsageRequests(String msisdn) {
        String[] usageTypes = {"VOICE", "DATA", "SMS"};
        Random random = new Random();
        String usageType = usageTypes[random.nextInt(usageTypes.length)];
        sendUsageRequest(msisdn, usageType);
    }
}