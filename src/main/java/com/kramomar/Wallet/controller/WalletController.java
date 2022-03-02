package com.kramomar.Wallet.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kramomar.Wallet.entity.Wallet;
import com.kramomar.Wallet.service.WalletService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/wallet")
public class WalletController {

    private final WalletService walletService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Wallet> create(
            @RequestBody final Mono<Wallet> wallet) {
        return walletService.create(wallet);
    }

    @GetMapping
    public Flux<Wallet> read() {
        return walletService.read();
    }

    @PutMapping("/{id}")
    @CachePut(key = "id",value = "Wallet")
    public Mono<Wallet> update(@RequestBody final Mono<Wallet> wallet, @PathVariable String id) {
        return walletService.update(wallet, id);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(key = "id", value = "Wallet")
    public Mono<Void> delete(@PathVariable final String id) {
        return walletService.delete(id);
    }

    @GetMapping("/{id}")
    @Cacheable(key = "id",value = "Wallet")
    public Mono<Wallet> findById(@PathVariable final String id) {
        return walletService.findById(id);
    }

    @GetMapping("/{numberPhone}")
    @Cacheable(value = "Wallet", key = "numberPhone")
    public Mono<Wallet> findByNumberPhone(@PathVariable final String numberPhone) {
        return walletService.findByNumberPhone(numberPhone);
    }
}