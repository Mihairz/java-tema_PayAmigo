package com.db.PayAmigo.repository;

import com.db.PayAmigo.entity.Transaction;
import com.db.PayAmigo.entity.Wallet;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

//    @Modifying
//    @Transactional
//    @Query(value = "UPDATE transactions SET amount = :amount, commission_amount = :commission_amount, " +
//            "commission_percent = :commission_percent, created_at = :created_at, currency = :currency, " +
//            "destination_id = :destination_id, source_id = :source_id WHERE (id = :id);", nativeQuery = true)
//    void updateTransaction(@Param("id") int id,
//                           @Param("source_id") Wallet source_id,
//                           @Param("destination_id") Wallet destination_id,
//                           @Param("amount") Float amount,
//                           @Param("commission_percent") Float commission_percent,
//                           @Param("commission_amount") Float commission_amount,
//                           @Param("currency") String currency,
//                           @Param("created_at") String created_at);

//    @Modifying
//    @Transactional
//    @Query("UPDATE transactions t set t.source_id = :source_id, t.destination_id = :destination_id, t.amount = :amount, " +
//            "t.commission_percent = :commission_percent, t.commission_amount = :commission_amount," +
//            "t.currency = :currency, t.created_at = :created_at WHERE t.is = :id")
//    int updateTransaction(@Param("source_id") Wallet source_id,
//                          @Param("destination_id") Wallet destination_id,
//                          @Param("amount") float amount,
//                          @Param("commission_percent") float commission_percent,
//                          @Param("commission_amount") float commission_amount,
//                          @Param("currency") String currency,
//                          @Param("created_at") String created_at,
//                          @Param("id") int id);
}
