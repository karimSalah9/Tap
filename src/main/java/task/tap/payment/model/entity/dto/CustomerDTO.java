package task.tap.payment.model.entity.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
	private Long id;
	private List<CustomerWalletDTO> customerWalletDTO;
}
