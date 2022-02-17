package task.tap.payment.model.paylod;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import task.tap.payment.model.entity.dto.TopupDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopupResponse {
	private LocalDateTime createdDate;
	private TopupDTO topopDTO;
}
