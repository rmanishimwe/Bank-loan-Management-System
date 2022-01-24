package com.example.bankloanmgt.controller;

import com.example.bankloanmgt.entity.Loan;
import com.example.bankloanmgt.repository.ClientRepository;
import com.example.bankloanmgt.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoanController {

    @Autowired
    private LoanRepository repository;
    @Autowired
    ClientRepository clientRepository;
    @GetMapping("/LoanList")
    public String viewLoans(Model model){
        model.addAttribute("loanList",repository.findAll());
        return "LoanList";
    }
    @PostMapping("/addLoan")
    public String addloan(Loan loan, Model model){
        model.addAttribute("loan",new Loan());
        repository.save(loan);
        return "redirect:/LoanList";

    }

    @GetMapping("/deleteLoan/{id}")
    public String deleteLoan(@PathVariable("id") Integer id){
        repository.deleteById(id);
        return"redirect:/LoanList" ;

    }



    @GetMapping("/editLoan/{id}")

    public String editLoan(@PathVariable("id") Integer id, Model model){

        model.addAttribute("loans", repository.findById(id).get());
        model.addAttribute("clientList" ,clientRepository.findAll());

        return "editLoan1";


    }

}
