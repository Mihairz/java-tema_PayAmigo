package com.db.PayAmigo.repository;

import com.db.PayAmigo.entity.User;
import com.db.PayAmigo.entity.Wallet;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WalletRepository extends JpaRepository<Wallet,Integer> {
    Wallet findById(int id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE wallets SET name = :name, balance = :balance, currency = :currency" +
            " WHERE (id = :id);", nativeQuery = true)
    int updateWallet(@Param("id") int id,
                        @Param("name") String name,
                        @Param("balance") double balance,
                        @Param("currency") String currency);
}
