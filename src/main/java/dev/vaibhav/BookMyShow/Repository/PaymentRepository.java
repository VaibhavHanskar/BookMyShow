package dev.vaibhav.BookMyShow.Repository;

import dev.vaibhav.BookMyShow.Model.Payment;
import dev.vaibhav.BookMyShow.Model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
