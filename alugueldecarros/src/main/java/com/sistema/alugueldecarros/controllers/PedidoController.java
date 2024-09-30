package com.sistema.alugueldecarros.controllers;

import com.sistema.alugueldecarros.models.Cliente;
import com.sistema.alugueldecarros.models.Pedido;
import com.sistema.alugueldecarros.models.Carro;
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

        model.addAttribute("carrosDisponiveis", carroService.listarCarrosDisponiveis());
        model.addAttribute("pedidos", pedidoService.listarPedidosPorCliente(cliente.getId()));
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

    @PostMapping("/editar/{id}")
    public String atualizarPedido(@PathVariable("id") Long pedidoId, @RequestParam("carroId") Long carroId, HttpSession session) {
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        if (cliente == null) {
            return "redirect:/login";
        }

        Pedido pedido = pedidoService.buscarPedidoPorId(pedidoId);
        if (!pedido.getCliente().getId().equals(cliente.getId())) {
            return "redirect:/pedidos";
        }

        Carro carro = carroService.buscarCarroPorId(carroId);
        pedido.setCarro(carro);

        pedidoService.salvarPedido(pedido);
        return "redirect:/pedidos";
    }

    @PostMapping("/excluir/{id}")
    public String excluirPedido(@PathVariable("id") Long pedidoId, HttpSession session) {
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        if (cliente == null) {
            return "redirect:/login";
        }

        Pedido pedido = pedidoService.buscarPedidoPorId(pedidoId);
        if (!pedido.getCliente().getId().equals(cliente.getId())) {
            return "redirect:/pedidos";
        }

        pedidoService.excluirPedido(pedidoId);
        return "redirect:/pedidos";
    }
}
