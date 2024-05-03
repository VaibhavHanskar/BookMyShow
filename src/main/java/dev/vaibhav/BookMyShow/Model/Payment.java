package dev.vaibhav.BookMyShow.Model;

import dev.vaibhav.BookMyShow.Model.Constants.PaymentMode;
import dev.vaibhav.BookMyShow.Model.Constants.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.apache.bcel.classfile.LocalVariable;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "Payment")
public class Payment extends BaseClass{
    private LocalDateTime paymentTime;
    private double amount;
    private String referenceId;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;
    @ManyToOne
    private Ticket ticket;
}
