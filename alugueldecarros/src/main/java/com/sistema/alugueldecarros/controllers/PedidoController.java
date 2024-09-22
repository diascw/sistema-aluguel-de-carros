package com.sistema.alugueldecarros.controllers;

import com.sistema.alugueldecarros.models.Pedido;
import com.sistema.alugueldecarros.services.PedidoService;
import com.sistema.alugueldecarros.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;  // Adicione o ClienteService para listar os clientes

    @GetMapping("/listar")
    public String listarPedidos(Model model) {
        model.addAttribute("pedidos", pedidoService.listarPedidos());
        return "pedidos/listar";
    }

    @GetMapping("/cadastrar")
    public String cadastrarPedidoForm(Model model) {
        model.addAttribute("pedido", new Pedido());
        model.addAttribute("clientes", clienteService.listarClientes());  // Carregar a lista de clientes
        return "pedidos/cadastrar";
    }

    @PostMapping("/salvar")
    public String salvarPedido(@ModelAttribute Pedido pedido) {
        pedidoService.salvarPedido(pedido);
        return "redirect:/pedidos/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarPedido(@PathVariable Long id, Model model) {
        Pedido pedido = pedidoService.getPedidoById(id);
        if (pedido != null) {
            model.addAttribute("pedido", pedido);
            model.addAttribute("clientes", clienteService.listarClientes());
            return "pedidos/cadastrar";
        }
        return "redirect:/pedidos/listar";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarPedido(@PathVariable Long id, @ModelAttribute Pedido pedido) {
        pedidoService.atualizarPedido(id, pedido);
        return "redirect:/pedidos/listar";
    }

    @GetMapping("/deletar/{id}")
    public String deletarPedido(@PathVariable Long id) {
        pedidoService.deletarPedido(id);
        return "redirect:/pedidos/listar";
    }
}
