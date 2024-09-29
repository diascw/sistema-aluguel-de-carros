package com.sistema.alugueldecarros.controllers;

import com.sistema.alugueldecarros.models.Cliente;
import com.sistema.alugueldecarros.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String exibirLoginForm() {
        return "login";  // Exibe o formulário de login
    }

    @PostMapping
    public String processarLogin(@RequestParam String nome, @RequestParam String cpf, HttpSession session, Model model) {
        try {
            Cliente cliente = clienteService.login(nome, cpf);
            session.setAttribute("cliente", cliente);  // Armazena o cliente na sessão

            if ("admin".equalsIgnoreCase(cliente.getProfissao())) {
                return "redirect:/clientes";  // Redireciona para a página de administração se for admin
            }

            return "redirect:/pedidos";  // Redireciona para a página de pedidos se for cliente comum
        } catch (Exception e) {
            model.addAttribute("erro", "Credenciais inválidas");
            return "login";
        }
    }
}
