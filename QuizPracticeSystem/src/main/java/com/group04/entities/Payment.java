/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.entities;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
/**
 *
 * @author HP
 */
@Entity
@Table(name = "Payment")
@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentID;
    
    @NotBlank(message = "paymentType can't be empty")
    @Size(max = 100, min = 1, message="paymentType must have more than 1 characters")
    @Column(name = "paymentType")
    private String paymentType;
    
    @NotBlank(message = "paymentDescription can't be empty")
    @Size(max = 100, min = 5, message="paymentDescription must have more than 5 characters")
    @Column(name = "paymentDescription")
    private String paymentDescription;
    
    @Column(name = "payDate")
    private String payDate;
    
    @ManyToOne
    @JoinColumn(name = "PaymentID", nullable = false)
    
    @OneToOne(mappedBy = "StudentRegistration", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn 
    private StudentRegistration StudentRegistration;
    
    public Payment(Payment payment) {
        this.paymentID = payment.paymentID;
        this.paymentType = payment.paymentType;
        this.paymentDescription = payment.paymentDescription;
        this.payDate = payment.payDate;
        
    }
}
