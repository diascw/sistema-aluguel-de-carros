package com.sistema.alugueldecarros.controllers;

import com.sistema.alugueldecarros.models.Cliente;
import com.sistema.alugueldecarros.services.PedidoService;
import com.sistema.alugueldecarros.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private CarroService carroService;

    @GetMapping
    public String listarPedidos(HttpSession session, Model model) {
        Cliente cliente = (Cliente) session.getAttribute("cliente"); 
        if (cliente == null) {
            return "redirect:/login";  
        }

        model.addAttribute("carrosDisponiveis", carroService.listarCarrosDisponiveis()); // Lista de carros disponíveis
        model.addAttribute("pedidos", pedidoService.listarPedidosPorCliente(cliente.getId())); // Lista pedidos do cliente
        return "pedidos";  
    }

    @PostMapping("/novo")
    public String fazerPedido(HttpSession session, @RequestParam("carroId") Long carroId) {
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        if (cliente == null) {
            return "redirect:/login";  
        }

        pedidoService.criarPedido(cliente.getId(), carroId);  
        return "redirect:/pedidos";  
    }
}
