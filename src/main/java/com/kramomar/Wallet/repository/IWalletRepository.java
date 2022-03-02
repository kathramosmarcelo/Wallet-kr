package com.kramomar.Wallet.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.kramomar.Wallet.entity.Wallet;


@Repository
public interface IWalletRepository extends ReactiveMongoRepository<Wallet, String> {
}
