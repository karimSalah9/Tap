package task.tap.payment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import task.tap.payment.model.entity.CustomerWallet;

@Repository
public interface CustomerWalletRepository extends JpaRepository<CustomerWallet, Long> {

	Optional<CustomerWallet> findByIdAndCustomerId(Long id, Long customerId);
}
