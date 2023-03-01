package com.application.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
public class WalletControler {

    @Autowired
    private WalletService walletService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String greet(){
        return "Welcome to wallet application";
    }

    @PostMapping("/wallet")
    @ResponseStatus(value = HttpStatus.CREATED)
    public WalletDto addWallet(@Valid @RequestBody WalletDto wallet) throws WalletException{
        return this.walletService.registerWallet(wallet);
    }

    @GetMapping("/wallet/{id}")
    public WalletDto getWalletById(@PathVariable Integer id) throws WalletException{
        return this.walletService.getWalletById(id);
    }

    @PutMapping("/updatewallet")
    public WalletDto updateWallet(@RequestBody WalletDto wallet) throws WalletException{
        return this.walletService.updateWallet(wallet);
    }

    @DeleteMapping("/deletewallet/{walletid}")
    public WalletDto deleteWallet(@PathVariable Integer walletid) throws WalletException{
        return this.walletService.deleteWalletById(walletid);
    }

    @PutMapping("/addfund/{id}/{amount}")
    public Double addFunds(@PathVariable Integer id,@PathVariable Double amount) throws WalletException{
        return this.walletService.addFundsToWalletById(id,amount);
    }

    @PutMapping("/withdraw/{id}/{amount}")
    public Double withdrawFunds(@PathVariable Integer id, @PathVariable Double amount) throws WalletException{
        return this.walletService.withdrawFundsFromWalletById(id,amount);
    }

    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public Boolean transferFunds(Integer id,Integer toId, Double amount) throws WalletException{
        return walletService.fundTransfer(id, toId, amount);
    }
//
    @GetMapping("/wallets")
    public Collection<WalletDto> getAllWallets(){
        return this.walletService.getAllWallets();
    }
}
