package com.sistema.alugueldecarros.controllers;

import com.sistema.alugueldecarros.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/pedidos")
    public String listarPedidosAdmin(Model model) {
        model.addAttribute("pedidos", pedidoService.listarTodosPedidos());
        return "pedidosAdmin"; 
    }

    @PostMapping("/pedidos/atualizar")
    public String atualizarStatusPedido(@RequestParam Long pedidoId, @RequestParam String status) {
        pedidoService.atualizarStatus(pedidoId, status);
        return "redirect:/admin/pedidos"; 
    }
}
