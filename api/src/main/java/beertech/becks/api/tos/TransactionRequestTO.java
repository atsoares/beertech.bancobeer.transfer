package beertech.becks.api.tos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequestTO {
	/**
	 * The hash account
	 */
	private String hashAccount;

	/**
	 * The operation type (S || D || T)
	 */
	private String operation;

	/**
	 * The operation value
	 */
	private BigDecimal value;

}
