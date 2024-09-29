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

    // Listar todos os clientes
    @GetMapping
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.listarTodos());
        return "clientes";
    }

    // Formulário para adicionar cliente
    @GetMapping("/novo")
    public String formNovoCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "formCliente";
    }

    @PostMapping("/salvar")
    public String salvarCliente(@ModelAttribute Cliente cliente) {
        System.out.println("Salvando cliente no controller: " + cliente.getNome());
        clienteService.adicionarCliente(cliente);
        return "redirect:/clientes";
    }

    // Editar cliente
    @GetMapping("/editar/{id}")
    public String formEditarCliente(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.buscarPorId(id);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "formCliente";
        }
        return "redirect:/clientes";
    }

    // Atualizar cliente
    @PostMapping("/editar/{id}")
    public String atualizarCliente(@PathVariable Long id, @ModelAttribute Cliente cliente) {
        clienteService.atualizarCliente(id, cliente);
        return "redirect:/clientes";
    }

    // Excluir cliente
    @GetMapping("/excluir/{id}")
    public String excluirCliente(@PathVariable Long id) {
        clienteService.removerCliente(id);
        return "redirect:/clientes";
    }
}
