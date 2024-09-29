package com.sistema.alugueldecarros.services;

import com.sistema.alugueldecarros.models.Pedido;
import com.sistema.alugueldecarros.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarTodosPedidos() {
        return pedidoRepository.findAll(); 
    }

    public void atualizarStatus(Long pedidoId, String status) {
        Pedido pedido = pedidoRepository.findById(pedidoId).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedido.setStatus(status);
        pedidoRepository.save(pedido);
    }
}
