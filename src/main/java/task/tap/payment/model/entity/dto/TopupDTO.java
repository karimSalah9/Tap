package task.tap.payment.model.entity.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import task.tap.payment.model.enums.Status;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopupDTO {
	private LocalDateTime createdDate;
	private Long id;
	private Status status = Status.INITIATED;
	private double amount;
	private String currency;
	private String charge_id;
	private Long customerId;
	private Long customerWalletId;
	private double feesAmount;
	private String feesCurrency;
	private double balanceAmount;

}
