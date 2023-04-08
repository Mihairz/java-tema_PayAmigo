package com.db.PayAmigo.controller;

import com.db.PayAmigo.entity.Wallet;
import com.db.PayAmigo.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    @Autowired
    WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    // Get all wallets---------------------------------------------------------------------------------------------

    @GetMapping("/all-json")
    public List<Wallet> getAllwalletsJSON() {
        return walletService.findAllwallets();
    }

    // Get wallet by walletId---------------------------------------------------------------------------------

    @GetMapping("/by-id-json/{walletId}")
    public Wallet findByIdJSON(@PathVariable(name = "walletId") int walletId) {
        return walletService.findBywalletId(walletId);
    }


    // Add wallet--------------------------------------------------------------------------------------------------

    @PutMapping("/add-json")
    public Wallet addWalletJSON(@RequestBody Wallet wallet) {
        return walletService.save(wallet);
    }

    // Update wallet-----------------------------------------------------------------------------------------------

    @PostMapping("/update-json/{id}")
    public Wallet updatewalletJSON(@PathVariable(name = "id") int id,
                                   @RequestBody Wallet wallet) {
        return walletService.updateWallet(id, wallet);
    }

    // Delete wallet-----------------------------------------------------------------------------------------------
    @DeleteMapping("/delete/{walletId}")
    public void deleteWallet(@PathVariable(name = "walletId") int walletId) {
        walletService.deleteWallet(walletId);
    }
}
