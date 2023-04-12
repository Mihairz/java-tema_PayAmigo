package com.db.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "source_id",nullable = false)
    Wallet source_id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "destination_id",nullable = false)
    Wallet destination_id;

    @Column(name = "amount",nullable = false)
    Float amount;
    @Column(name = "commission_percent", nullable = false)
    Float commission_percent;
    @Column(name = "commission_amount",nullable = false)
    Float commission_amount;
    @Column(name = "currency", nullable = false)
    String currency;
    @Column(name = "created_at",nullable = false)
    String created_at;

    public Transaction(Wallet source_id, Wallet destination_id, Float amount, Float commission_percent, Float commission_amount, String currency, String created_at) {
        this.source_id = source_id;
        this.destination_id = destination_id;
        this.amount = amount;
        this.commission_percent = commission_percent;
        this.commission_amount = commission_amount;
        this.currency = currency;
        this.created_at = created_at;
    }
}
