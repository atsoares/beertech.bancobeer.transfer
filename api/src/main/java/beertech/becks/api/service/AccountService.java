package beertech.becks.api.service;

import beertech.becks.api.entities.Account;
import beertech.becks.api.entities.Balance;
import beertech.becks.api.entities.Transaction;
import beertech.becks.api.tos.TransactionRequestTO;

public interface AccountService {

    Account createAccount();

    Balance getBalance(String hash);

}
