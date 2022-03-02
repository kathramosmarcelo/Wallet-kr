package com.kramomar.Wallet.util;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kramomar.Wallet.entity.Wallet;
import com.kramomar.Wallet.service.WalletService;

import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class DefaultLoad implements CommandLineRunner {

    private final WalletService walletService;

    @Override
    public void run(String... args) throws Exception {

        Wallet walletOne = new Wallet("WAL-001", "4214-1001", "985783209", "IMEI-001", "752342467", "@gmail.co", 0);
        walletService.create(Mono.just(walletOne));
        Wallet walletTwo = new Wallet("WAL-002", "4214-1002", "985673209", "IMEI-002", "767342467", "@gmail.co", 0);
        walletService.create(Mono.just(walletTwo));
        Wallet walletThree = new Wallet("WAL-003", "4214-1003", "985603209", "IMEI-003", "722342467", "@gmail.co", 0);
        walletService.create(Mono.just(walletThree));
        Wallet walletFour = new Wallet("WAL-004", "4214-1004", "985613209", "IMEI-004", "732342467", "@gmail.co", 0);
        walletService.create(Mono.just(walletFour));
        Wallet walletFive = new Wallet("WAL-005", "4214-1005", "985683409", "IMEI-005", "762382467", "@gmail.co", 0);
        walletService.create(Mono.just(walletFive));
        Wallet walletSix = new Wallet("WAL-006", "4214-1006", "985683509", "IMEI-006", "762372467", "@gmail.co", 0);
        walletService.create(Mono.just(walletSix));
        Wallet walletSeven = new Wallet("WAL-007", "4214-1007", "995683209", "IMEI-007", "752342467", "@gmail.co", 0);
        walletService.create(Mono.just(walletSeven));
        Wallet walletEight = new Wallet("WAL-008", "4214-1008", "989683209", "IMEI-008", "762332467", "@gmail.co", 0);
        walletService.create(Mono.just(walletEight));
        Wallet walletNine = new Wallet("WAL-009", "4214-1009", "985583209", "IMEI-009", "762347467", "@gmail.co", 0);
        walletService.create(Mono.just(walletNine));
        Wallet walletTen = new Wallet("WAL-010", "4214-1010", "985483209", "IMEI-010", "762342967", "@gmail.co", 0);
        walletService.create(Mono.just(walletTen));
    }
}
