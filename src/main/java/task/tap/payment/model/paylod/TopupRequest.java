package task.tap.payment.model.paylod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopupRequest {

	private double amount;
	private String currency;
	private String charge_id;
	private CustomerRequest customerRequest;
	private FeesRequest feesRequest;

}
