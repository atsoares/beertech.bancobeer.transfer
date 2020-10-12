package beertech.becks.api.service;

import beertech.becks.api.entities.Transfer;
import beertech.becks.api.tos.TransferRequestTO;

public interface TransferService {

    Transfer doTransfer(TransferRequestTO transferTO);

}
