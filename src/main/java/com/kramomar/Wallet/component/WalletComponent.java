package com.kramomar.Wallet.component;

import org.springframework.stereotype.Component;

import com.kramomar.Wallet.entity.Wallet;
import com.kramomar.Wallet.repository.WalletRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class WalletComponent {

    private final WalletRepository walletRepository;

    public Mono<Wallet> create(Wallet wallet) {
        return walletRepository.create(wallet);
    }

    public Flux<Wallet> read() {
        return walletRepository.read();
    }

    public Mono<Wallet> update(Wallet wallet, String id) {
        return walletRepository.update(wallet, id);
    }

    public Mono<Void> delete(String id) {
        return walletRepository.delete(id);
    }

    public Mono<Wallet> findByNumberPhone(String numberPhone) {
       return  walletRepository.findByNumberPhone(numberPhone);
    }

    public Mono<Wallet> findByNumberCard(String numberCard) {
        return walletRepository.findByNumberCard(numberCard);
    }
    public Mono<Wallet> findById(String id) {
        return walletRepository.findById(id);
    }

}
