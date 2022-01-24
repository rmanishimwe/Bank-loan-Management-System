package com.example.bankloanmgt.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Loan {
    @Id
    Integer loanId;
    Integer amount;
    Integer interestRate;
    String startDate;
    String duedate;
    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;



}
