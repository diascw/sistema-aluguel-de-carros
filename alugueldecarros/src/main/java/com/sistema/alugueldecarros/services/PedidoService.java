package com.sistema.alugueldecarros.services;

import com.sistema.alugueldecarros.models.Pedido;
import com.sistema.alugueldecarros.models.Carro;
import com.sistema.alugueldecarros.repositories.PedidoRepository;
import com.sistema.alugueldecarros.repositories.CarroRepository;
import com.sistema.alugueldecarros.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CarroRepository carroRepository;

    public void criarPedido(Long clienteId, Long carroId) {
        var cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        var carro = carroRepository.findById(carroId).orElseThrow(() -> new RuntimeException("Carro não encontrado"));

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setCarro(carro);
        pedido.setStatus("Em andamento");

        pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidosPorCliente(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }
}
