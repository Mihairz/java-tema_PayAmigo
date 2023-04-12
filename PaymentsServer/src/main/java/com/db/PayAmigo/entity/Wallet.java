package com.db.PayAmigo.entity;

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
@Table(name = "wallets")
public class Wallet {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name", nullable = false)
    String name;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    User user_id;

    @Column(name = "balance", nullable = false)
    double balance;
    @Column(name = "currency", nullable = false)
    String currency;

    public Wallet(String name, User user_id, double balance, String currency) {
        this.name = name;
        this.user_id = user_id;
        this.balance = balance;
        this.currency = currency;
    }

    public void substract(double amount) {
        balance -= amount;
    }
}
