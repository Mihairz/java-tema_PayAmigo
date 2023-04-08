package com.db.PayAmigo.service;

import com.db.PayAmigo.entity.User;
import com.db.PayAmigo.entity.Wallet;
import com.db.PayAmigo.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WalletService {
    @Autowired
    WalletRepository walletRepository;

    public List<Wallet> findAllwallets() {
        return walletRepository.findAll();
    }

    public Wallet findBywalletId(int walletId) {
        return walletRepository.findById(walletId);
    }

    public Wallet save(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    public Wallet updateWallet(int walletId, Wallet wallet) {
        int id = walletId;
        String name = wallet.getName();
        double balance = wallet.getBalance();
        String currency = wallet.getCurrency();

        walletRepository.updateWallet(id,name,balance,currency);
        return wallet;
    }

    public void deleteWallet(int walletId) {
        walletRepository.deleteById(walletId);
    }
}
