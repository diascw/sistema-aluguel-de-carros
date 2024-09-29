package com.sistema.alugueldecarros.controllers;

import com.sistema.alugueldecarros.services.PedidoService;
import com.sistema.alugueldecarros.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private CarroService carroService;

    @GetMapping
    public String listarPedidos(Model model) {
        Long clienteId = 1L; 
        model.addAttribute("carrosDisponiveis", carroService.listarCarrosDisponiveis());
        model.addAttribute("pedidos", pedidoService.listarPedidosPorCliente(clienteId));
        return "pedidos";
    }

    @PostMapping("/novo")
    public String fazerPedido(@RequestParam("carroId") Long carroId, Model model) {
        Long clienteId = 1L;
        pedidoService.criarPedido(clienteId, carroId);
        model.addAttribute("mensagemSucesso", "Pedido realizado com sucesso!");
        return "redirect:/pedidos";
    }
}
