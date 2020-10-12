package beertech.becks.api.service.impl;

import beertech.becks.api.entities.Account;
import beertech.becks.api.entities.Balance;
import beertech.becks.api.entities.Transaction;
import beertech.becks.api.repositories.AccountRepository;
import beertech.becks.api.repositories.TransactionRepository;
import beertech.becks.api.service.AccountService;
import beertech.becks.api.service.TransactionService;
import beertech.becks.api.tos.TransactionRequestTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static beertech.becks.api.model.TypeOperation.*;
import static java.time.ZonedDateTime.now;

@Service
public class TransactionServiceImpl implements TransactionService {

  private TransactionRepository transactionRepository;
  private AccountRepository accountRepository;

  @Autowired
  public TransactionServiceImpl(TransactionRepository transactionRepository, AccountRepository accountRepository) {
    this.transactionRepository = transactionRepository;
    this.accountRepository = accountRepository;
  }

  @Override
  public Transaction createTransaction(TransactionRequestTO transactionTO) {
    Transaction transaction = new Transaction();

    transaction.setHashAccount(transactionTO.getHashAccount());

    if (SAQUE.getDescription().equals(transactionTO.getOperation())) {
      transaction.setValueTransaction(transactionTO.getValue().negate());
      transaction.setTypeOperation(SAQUE);
    } else {
      transaction.setValueTransaction(transactionTO.getValue());
      transaction.setTypeOperation(DEPOSITO);
    }

    transaction.setDateTime(now());

    updateBalance(transaction.getHashAccount(), transaction.getValueTransaction());

    return transactionRepository.save(transaction);
  }

  public void updateBalance(String hash, BigDecimal amount){
    Account account = accountRepository.findByHash(hash);

    account.setBalance(account.getBalance().add(amount));

    accountRepository.save(account);
  }

}
