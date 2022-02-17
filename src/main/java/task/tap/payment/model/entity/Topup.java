package task.tap.payment.model.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import task.tap.payment.model.enums.Status;

@Getter
@Setter
@Entity(name = "topop")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Topup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "created_date", nullable = false, updatable = false)
	@CreatedDate
	private LocalDateTime createdDate;

	@Column(name = "status")
	@Enumerated(value = EnumType.STRING)
	private Status status = Status.INITIATED;

	@Column(name = "amount")
	private double amount;

	@Column(name = "currency")
	private String currency;

	@Column(name = "charge_id")
	private String charge_id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@OneToOne(mappedBy = "topop", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private Fees fees;

	public Fees getFees() {
		return fees;
	}

	public void setFees(Fees fees) {
		if (fees == null) {
			if (this.fees != null) {
				this.fees.setTopop(null);
			}
		} else {
			fees.setTopop(this);
		}
		this.fees = fees;
	}
}
