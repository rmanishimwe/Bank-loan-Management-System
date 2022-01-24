package com.example.bankloanmgt.controller;

import com.example.bankloanmgt.entity.Account;
import com.example.bankloanmgt.entity.Client;
import com.example.bankloanmgt.entity.Loan;
import com.example.bankloanmgt.repository.AccountRepository;
import com.example.bankloanmgt.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    @Autowired
    private AccountRepository repository;
    @GetMapping("/AccountList")
    public String viewAccounts(Model model){
        model.addAttribute("accountList",repository.findAll());
        return "AccountList";
    }
    @PostMapping("/Accounttadd")
    public String addAccount(Account account, Model model){
        model.addAttribute("account",new Account());
        repository.save(account);
        return "redirect:/AccountList";

    }

    @GetMapping("/deleteaccount/{id}")
    public String deleteAccount(@PathVariable("id") Integer id){
        repository.deleteById(id);
        return"redirect:/AccountList" ;

    }



    @GetMapping("/editaccount/{id}")

    public String editAccount(@PathVariable("id") Integer id, Model model){

        model.addAttribute("editaccount", repository.findById(id).get());
        model.addAttribute("AccountList" ,repository.findAll());

        return "editAccount";


    }

}
