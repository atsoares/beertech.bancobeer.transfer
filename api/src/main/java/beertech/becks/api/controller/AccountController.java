package beertech.becks.api.controller;

import beertech.becks.api.entities.Account;
import beertech.becks.api.entities.Balance;
import beertech.becks.api.entities.Transaction;
import beertech.becks.api.service.AccountService;
import beertech.becks.api.service.TransactionService;
import beertech.becks.api.tos.TransactionRequestTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static beertech.becks.api.constants.Constants.*;

@RestController
@RequestMapping("/account")
@Api(value = "Bank Becks Service")
public class AccountController {

  @Autowired private AccountService accountService;

  @ApiResponses(
      value = {
        @ApiResponse(code = 201, message = STATUS_201_CREATED),
        @ApiResponse(code = 500, message = STATUS_500_INTERNAL_SERVER_ERROR)
      })
  @PostMapping
  public ResponseEntity<Account> createAccount() {
    Account createdAccount = accountService.createAccount();

    return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
  }

  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = STATUS_200_GET_OK),
        @ApiResponse(code = 400, message = STATUS_400_BAD_REQUEST),
        @ApiResponse(code = 404, message = STATUS_404_NOTFOUND),
        @ApiResponse(code = 500, message = STATUS_500_INTERNAL_SERVER_ERROR)
      })
  @GetMapping
  public ResponseEntity<Balance> getBalance(@RequestParam String hash) {
    Balance balance = accountService.getBalance(hash);
    return new ResponseEntity<>(balance, HttpStatus.OK);
  }
}
