package com.sistema.alugueldecarros.repositories;

import com.sistema.alugueldecarros.models.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

    List<Carro> findByDisponivelTrue();
}
