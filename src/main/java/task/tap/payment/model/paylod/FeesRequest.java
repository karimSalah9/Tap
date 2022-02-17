package task.tap.payment.model.paylod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeesRequest {

	private double amount;

	private String currency;
}
