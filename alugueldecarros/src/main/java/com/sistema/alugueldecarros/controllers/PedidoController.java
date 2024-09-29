package com.sistema.alugueldecarros.controllers;

import com.sistema.alugueldecarros.models.Cliente;
import com.sistema.alugueldecarros.services.PedidoService;
import com.sistema.alugueldecarros.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private CarroService carroService;

    @GetMapping
    public String listarPedidos(@SessionAttribute("cliente") Cliente cliente, Model model) {
        model.addAttribute("carrosDisponiveis", carroService.listarCarrosDisponiveis());
        model.addAttribute("pedidos", pedidoService.listarPedidosPorCliente(cliente.getId()));  // Lista os pedidos do cliente logado
        return "pedidos";  // Exibe a página de pedidos
    }

    @PostMapping("/novo")
    public String fazerPedido(@SessionAttribute("cliente") Cliente cliente, @RequestParam("carroId") Long carroId) {
        pedidoService.criarPedido(cliente.getId(), carroId);  // Cria um novo pedido
        return "redirect:/pedidos";  // Redireciona para a página de pedidos após o pedido ser feito
    }
}
