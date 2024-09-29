package com.sistema.alugueldecarros.controllers;

import com.sistema.alugueldecarros.models.Cliente;
import com.sistema.alugueldecarros.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

  
    @GetMapping
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.listarTodos());
        return "clientes"; 
    }


    @GetMapping("/novo")
    public String formNovoCliente(Model model) {
        model.addAttribute("cliente", new Cliente()); 
        return "formCliente"; 
    }

   
    @PostMapping("/salvar")
    public String salvarOuAtualizarCliente(@ModelAttribute Cliente cliente) {
        if (cliente.getId() != null) { 
            clienteService.atualizarCliente(cliente.getId(), cliente);
        } else {
            clienteService.adicionarCliente(cliente); 
        }
        return "redirect:/clientes";
    }


    @GetMapping("/editar/{id}")
    public String formEditarCliente(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.buscarPorId(id);
        if (cliente != null) {
            model.addAttribute("cliente", cliente); 
            return "formCliente"; 
        }
        return "redirect:/clientes"; 
    }

    @GetMapping("/excluir/{id}")
    public String excluirCliente(@PathVariable Long id) {
        clienteService.removerCliente(id); 
        return "redirect:/clientes";
    }
}
