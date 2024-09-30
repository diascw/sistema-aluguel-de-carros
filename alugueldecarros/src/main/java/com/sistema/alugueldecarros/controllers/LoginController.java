package com.sistema.alugueldecarros.controllers;

import com.sistema.alugueldecarros.models.Cliente;
import com.sistema.alugueldecarros.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String exibirLoginForm() {
        return "login"; 
    }

    @PostMapping
    public String processarLogin(@RequestParam String nome, @RequestParam String cpf, HttpSession session, Model model) {
        try {
            Cliente cliente = clienteService.login(nome, cpf);
            session.setAttribute("cliente", cliente);  
    
            if ("admin".equalsIgnoreCase(cliente.getProfissao())) {
                return "redirect:/admin/pedidos"; 
            }
    
           
            return "redirect:/pedidos";
        } catch (Exception e) {
            model.addAttribute("erro", "Credenciais inválidas");
            return "login";
        }
    }
}
