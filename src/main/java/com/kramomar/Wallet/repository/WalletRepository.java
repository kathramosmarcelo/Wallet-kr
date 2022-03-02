package com.kramomar.Wallet.repository;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;

import com.kramomar.Wallet.entity.Wallet;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class WalletRepository {


    private static final Logger logger = LoggerFactory.getLogger(WalletRepository.class);
    private static final String KEY = "Wallet";
    private final ReactiveRedisOperations<String, Wallet> redisOperations;
    private final ReactiveHashOperations<String, String, Wallet> hashOperations;


    @Autowired
    public WalletRepository(ReactiveRedisOperations<String, Wallet> redisOperations) {
        this.redisOperations = redisOperations;
        this.hashOperations = redisOperations.opsForHash();
    }

    public Mono<Wallet> create(Wallet wallet) {
        logger.info("inside methode create");
        if (wallet.getId() != null) {
            String id = UUID.randomUUID().toString();
            wallet.setId(id);
        }
        return hashOperations.put(KEY, wallet.getId(), wallet)
                .map(isSaved -> wallet);
    }

    public Mono<Boolean> existsById(String id) {
        return hashOperations.hasKey(KEY, id);
    }
    public Mono<Wallet> update(Wallet wallet ,String id) {
        Mono<Boolean> booleanMono=existsById(id);
        return booleanMono.flatMap(exist -> {
                    if (Boolean.TRUE.equals(exist)) {
                        return hashOperations.put(KEY, wallet.getId(), wallet)
                                .map(isSaved -> wallet);
                    } else {
                        return hashOperations.put(KEY, wallet.getId(), wallet)
                                .map(isSaved -> wallet);
                    }
                })
                .thenReturn(wallet);
    }

    public Flux<Wallet> read() {
        return hashOperations.values(KEY);
    }

    public Mono<Void> delete(String id) {
        return hashOperations.remove(KEY, id).then();
    }

    public Mono<Wallet> findById(String id) {
        return hashOperations.get(KEY, id);
    }

    public Mono<Wallet> findByNumberCard(String numberCard) {
        return hashOperations.values(KEY)
                .filter(w -> w.getNumberCard().equals(numberCard))
                .singleOrEmpty();
    }

    public Mono<Wallet> findByNumberPhone(String numberPhone) {
        return hashOperations.values(KEY)
                .filter(w -> w.getNumberPhone().equals(numberPhone))
                .singleOrEmpty();
    }
}
