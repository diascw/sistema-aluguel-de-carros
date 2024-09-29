package com.sistema.alugueldecarros.repositories;

import com.sistema.alugueldecarros.models.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    List<Carro> findByDisponivelTrue(); 
}
