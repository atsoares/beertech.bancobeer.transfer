package beertech.becks.api.tos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferRequestTO {
	/**
	 * The account origin
	 */
	private String hashOrigin;

	/**
	 * The account destination
	 */
	private String hashDestination;

	/**
	 * The amount to be transferred
	 */
	private BigDecimal value;
}
