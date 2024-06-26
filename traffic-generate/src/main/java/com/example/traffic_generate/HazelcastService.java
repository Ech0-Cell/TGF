package com.example.traffic_generate;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.util.Set;

public class HazelcastService {
    private HazelcastInstance hazelcastInstance;

    public HazelcastService() {
        hazelcastInstance = HazelcastClient.newHazelcastClient();
    }

    public Set<String> getAllMsisdns() {
        IMap<String, String> msisdnMap = hazelcastInstance.getMap("msisdns");
        return msisdnMap.keySet();
    }

    public void shutdown() {
        hazelcastInstance.shutdown();
    }
}