package com.devcrutch.service;

import java.util.concurrent.CompletableFuture;

public interface NetworkService {
    CompletableFuture<Boolean> isServerAlive(String ip);
}
