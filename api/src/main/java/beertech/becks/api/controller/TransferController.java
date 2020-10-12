package beertech.becks.api.controller;

import beertech.becks.api.entities.Account;
import beertech.becks.api.entities.Balance;
import beertech.becks.api.entities.Transfer;
import beertech.becks.api.service.AccountService;
import beertech.becks.api.service.TransferService;
import beertech.becks.api.tos.TransferRequestTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static beertech.becks.api.constants.Constants.*;

@RestController
@RequestMapping("/transfer")
@Api(value = "Bank Becks Service")
public class TransferController {

  @Autowired private TransferService transferService;

  @ApiResponses(
      value = {
        @ApiResponse(code = 201, message = STATUS_201_CREATED),
        @ApiResponse(code = 200, message = STATUS_200_GET_OK),
        @ApiResponse(code = 400, message = STATUS_400_BAD_REQUEST),
        @ApiResponse(code = 404, message = STATUS_404_NOTFOUND),
        @ApiResponse(code = 500, message = STATUS_500_INTERNAL_SERVER_ERROR)
      })
  @PostMapping
  public ResponseEntity<Transfer> doTransfer(@RequestBody TransferRequestTO transferRequestTO) {
    Transfer doneTransfer = transferService.doTransfer(transferRequestTO);

    return new ResponseEntity<>(doneTransfer, HttpStatus.CREATED);
  }

}
