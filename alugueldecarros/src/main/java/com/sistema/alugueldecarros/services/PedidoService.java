package com.sistema.alugueldecarros.services;

import com.sistema.alugueldecarros.models.Pedido;
import com.sistema.alugueldecarros.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido salvarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido getPedidoById(Long id) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(id);
        return optionalPedido.orElse(null);
    }

    public Pedido atualizarPedido(Long id, Pedido pedidoAtualizado) {
        Pedido pedidoExistente = getPedidoById(id);
        if (pedidoExistente != null) {
            pedidoExistente.setStatus(pedidoAtualizado.getStatus());
            pedidoExistente.setTipoContrato(pedidoAtualizado.getTipoContrato());
            pedidoExistente.setDuracaoContrato(pedidoAtualizado.getDuracaoContrato());
            return pedidoRepository.save(pedidoExistente);
        }
        return null;
    }

    public void deletarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
