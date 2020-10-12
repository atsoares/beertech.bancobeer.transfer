package beertech.becks.api.service.impl;

import beertech.becks.api.entities.Account;
import beertech.becks.api.entities.Balance;
import beertech.becks.api.repositories.AccountRepository;
import beertech.becks.api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

import static java.time.ZonedDateTime.now;

@Service
public class AccountServiceImpl implements AccountService {

  private AccountRepository accountRepository;

  @Autowired
  public AccountServiceImpl(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override
  public Account createAccount() {
    Account account = new Account();
    account.setBalance(BigDecimal.valueOf(0));
    account.setHash(UUID.randomUUID().toString());

    return accountRepository.save(account);
  }

  @Override
  public Balance getBalance(String hash) {
    Balance balance = new Balance();
    balance.setBalance(accountRepository.findByHash(hash).getBalance());
    return balance;
  }


}
