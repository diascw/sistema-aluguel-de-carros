package com.sistema.alugueldecarros.repositories;

import com.sistema.alugueldecarros.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByClienteId(Long clienteId); 
}
