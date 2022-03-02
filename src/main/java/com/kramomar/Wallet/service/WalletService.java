package com.kramomar.Wallet.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.kramomar.Wallet.entity.Wallet;
import com.kramomar.Wallet.repository.IWalletRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class WalletService {

    private final static Logger logger = LoggerFactory.getLogger(WalletService.class);
    private final IWalletRepository customerRepository;
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    public Mono<Wallet> create(final Mono<Wallet> entityToDto) {
        return entityToDto
                .flatMap(customerRepository::save);

    }

    public Flux<Wallet> read() {
        return customerRepository.findAll();
    }

    public Mono<Wallet> update(
            final Mono<Wallet> customerDtoMono, final String id) {
        return customerRepository.findById(id)
                .flatMap(p -> customerDtoMono
                        .doOnNext(e -> e.setId(id)))
                .flatMap(customerRepository::save);
    }

    public Mono<Void> delete(final String id) {
        return customerRepository.deleteById(id);
    }


    public Mono<Wallet> findByNumberPhone(String numberPhone) {
        logger.info("inside methode find by number Phone ");
        Query query = new Query();
        query.addCriteria(Criteria.where("numberPhone").is(numberPhone));
        return reactiveMongoTemplate.findOne(query, Wallet.class);

    }

    public Mono<Wallet> findById(final String id) {
        return customerRepository.findById(id);
    }


}
