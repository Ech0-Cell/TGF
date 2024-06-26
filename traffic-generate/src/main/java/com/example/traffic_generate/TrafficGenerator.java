package com.example.traffic_generate;

import java.util.Set;

public class TrafficGenerator {

    private final HazelcastService hazelcastService;
    private final ChfService chfService;

    public TrafficGenerator() {
        this.hazelcastService = new HazelcastService();
        this.chfService = new ChfService();
    }

    public void run() {
        Set<String> msisdns = hazelcastService.getAllMsisdns();
        for (String msisdn : msisdns) {
            chfService.sendDummyUsageRequests(msisdn);
        }
        hazelcastService.shutdown();
    }
}