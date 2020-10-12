package beertech.becks.api.service;

import beertech.becks.api.entities.Account;
import beertech.becks.api.entities.Balance;

public interface AccountService {

    Account createAccount();

    Balance getBalance(String hash);

}
