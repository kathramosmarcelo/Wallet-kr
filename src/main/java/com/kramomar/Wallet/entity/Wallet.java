package com.kramomar.Wallet.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("wallet-kr")
public class Wallet implements Serializable {
    @Id
    private String id;
    private String numberCard;
    private String numberPhone;
    private String imei;
    private String document;
    private String email;
    private int status;

}
