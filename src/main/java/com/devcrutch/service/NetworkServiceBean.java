package com.devcrutch.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class NetworkServiceBean implements NetworkService {

    @Override
    @Async
    public CompletableFuture<Boolean> isServerAlive(String ip) {
        CompletableFuture<Boolean> future = new CompletableFuture<Boolean>(){
            @Override
            public Boolean get() throws InterruptedException, ExecutionException {
                InetAddress address = null;
                try {
                    address = InetAddress.getByName(ip);
                    return address.isReachable(1000);
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                    return false;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
        return future;
    }
}
