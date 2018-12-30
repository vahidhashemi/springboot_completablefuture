package com.devcrutch.controller;

import com.devcrutch.service.NetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1")
public class Service {

    @Autowired
    NetworkService networkService;

    @GetMapping("/isalive/{ip}")
    public CompletableFuture<Boolean> isAlive(@PathVariable("ip") String ip) {
        return networkService.isServerAlive(ip);
    }

}
