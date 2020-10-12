package beertech.becks.api.service.impl;

import beertech.becks.api.entities.Transfer;
import beertech.becks.api.model.TypeOperation;
import beertech.becks.api.repositories.TransferRepository;
import beertech.becks.api.service.TransactionService;
import beertech.becks.api.service.TransferService;
import beertech.becks.api.tos.TransactionRequestTO;
import beertech.becks.api.tos.TransferRequestTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.time.ZonedDateTime.now;

@Service
public class TransferServiceImpl implements TransferService {

  private TransferRepository transferRepository;
  private TransactionService transactionService;

  @Autowired
  public TransferServiceImpl(TransferRepository transferRepository, TransactionService transactionService) {
    this.transferRepository = transferRepository;
    this.transactionService = transactionService;
  }

  @Override
  public Transfer doTransfer(TransferRequestTO transferTO){
    Transfer transfer = new Transfer();

    transfer.setHashAccountOrigin(transferTO.getHashOrigin());
    transfer.setHashAccountDestination(transferTO.getHashDestination());
    transfer.setValueTransaction(transferTO.getValue());

    TransactionRequestTO transactionOrigin = new TransactionRequestTO();
    transactionOrigin.setHashAccount(transfer.getHashAccountOrigin());
    transactionOrigin.setOperation(TypeOperation.SAQUE.getDescription());
    transactionOrigin.setValue(transfer.getValueTransaction().negate());

    TransactionRequestTO transactionDestination = new TransactionRequestTO();
    transactionDestination.setHashAccount(transfer.getHashAccountDestination());
    transactionDestination.setOperation(TypeOperation.DEPOSITO.getDescription());
    transactionDestination.setValue(transfer.getValueTransaction());

    transactionService.createTransaction(transactionOrigin);
    transactionService.createTransaction(transactionDestination);

    transfer.setDateTime(now());

    return transferRepository.save(transfer);
  }

}
