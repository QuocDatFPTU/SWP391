/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@Table(name = "Sale")
@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
public class Sale implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "saleID", nullable = false, updatable = false)
    private Long saleID;
    
    @Column(name = "startSale")
    private String startSale;
    
    @Column(name = "expiSale")
    private String expiSale;
    
    @Column(name = "isActive")
    private boolean isActive;
    
    @NotBlank(message = "value can't be empty")
    @Column(name = "value")
    private String value;
    
    @ManyToOne
    @JoinColumn(name="packageID")
    private Packages packages;
    
    public Sale(Sale sale) {
        this.saleID = sale.saleID;
        this.startSale = sale.startSale;
        this.expiSale = sale.expiSale;
        this.isActive = sale.isActive;
        this.value = sale.value;
    }
}
