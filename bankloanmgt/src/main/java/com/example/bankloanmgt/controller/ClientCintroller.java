package com.example.bankloanmgt.controller;

import com.example.bankloanmgt.entity.Client;
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
public class ClientCintroller {

    @Autowired
    private ClientRepository repository;
    @GetMapping("/ClientList")
    public String viewClients(Model model){
        model.addAttribute("clientList",repository.findAll());
        return "ClientList";
    }
    @PostMapping("/Clienttadd")
    public String addCat(Client client, Model model){
        model.addAttribute("client",new Client());
        repository.save(client);
        return "redirect:/ClientList";

    }

    @GetMapping("/deleteclient/{id}")
    public String deleteClient(@PathVariable("id") Integer id){
        repository.deleteById(id);
        return"redirect:/ClientList" ;

    }



    @GetMapping("/editclient/{id}")

    public String editClient(@PathVariable("id") Integer id, Model model){

        model.addAttribute("clients", repository.findById(id).get());
        model.addAttribute("ClientList" ,repository.findAll());

        return "editClient";


    }
}
