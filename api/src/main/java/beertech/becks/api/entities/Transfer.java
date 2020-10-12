package beertech.becks.api.entities;

import beertech.becks.api.model.TypeOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transfer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "value_transaction")
	private BigDecimal valueTransaction;

	@Column(name = "data_transaction")
	private ZonedDateTime dateTime;

	@Column(name = "hash_account_origin")
	private String hashAccountOrigin;

	@Column(name = "hash_account_destination")
	private String hashAccountDestination;

}
