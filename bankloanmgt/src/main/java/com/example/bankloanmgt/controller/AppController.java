package com.example.bankloanmgt.controller;

import com.example.bankloanmgt.entity.Client;
import com.example.bankloanmgt.entity.Loan;
import com.example.bankloanmgt.repository.AccountRepository;
import com.example.bankloanmgt.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @Autowired
        ClientRepository clientRepository;
    @Autowired
        AccountRepository accountRepository;

    @GetMapping("/")

    public String viewIndex(Model model){
        model.addAttribute("loan", new Loan());
        model.addAttribute("client", new Client());

        model.addAttribute("clientList",clientRepository.findAll());
        model.addAttribute("account", accountRepository.findAll());

        return "index";
    }





}
