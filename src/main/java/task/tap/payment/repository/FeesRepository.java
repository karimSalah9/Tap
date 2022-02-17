package task.tap.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import task.tap.payment.model.entity.Fees;

@Repository
public interface FeesRepository extends JpaRepository<Fees, Long> {

}
