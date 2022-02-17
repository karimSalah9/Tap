package task.tap.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import task.tap.payment.model.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
