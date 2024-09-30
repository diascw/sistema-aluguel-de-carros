package com.sistema.alugueldecarros.controllers;

import com.sistema.alugueldecarros.models.Cliente;
import com.sistema.alugueldecarros.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/novo")
    public String formNovoCliente(Model model) {
        model.addAttribute("cliente", new Cliente());  
        return "formCliente";  
    }

    @PostMapping("/salvar")
    public String salvarCliente(@ModelAttribute("cliente") Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            return "formCliente";  
        }

        clienteService.adicionarCliente(cliente); 
        return "redirect:/login";  
    }
}
