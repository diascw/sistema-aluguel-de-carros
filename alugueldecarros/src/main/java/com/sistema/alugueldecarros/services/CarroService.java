package com.sistema.alugueldecarros.services;

import com.sistema.alugueldecarros.models.Carro;
import com.sistema.alugueldecarros.repositories.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> listarCarrosDisponiveis() {
        return carroRepository.findByDisponivelTrue();
    }
}
