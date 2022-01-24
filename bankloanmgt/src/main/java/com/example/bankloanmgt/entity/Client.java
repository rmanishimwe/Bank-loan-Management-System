package com.example.bankloanmgt.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {

    @Id
    Integer clientId;
    @Column(nullable = false, length = 40)
    String name;
    String phoneNumber;
    String address;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acc_Id")
    Account account;


}
