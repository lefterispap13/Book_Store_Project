package com.groupproject.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="pricing")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pricing implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pricing_id")
    private Long pricingId;

    @Column(name="starting_price")
    private double startingPrice;

    @Column(name="discount")
    private double discount;

    @Column(name="starting_date")
    private Date startingDate;

    @Column(name="ending_date")
    private Date endingDate;

    @OneToOne(mappedBy = "pricing")
    @JsonIgnore
    private Book book;


}
