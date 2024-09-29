package com.sistema.alugueldecarros.services;

import com.sistema.alugueldecarros.models.Cliente;
import com.sistema.alugueldecarros.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

@Autowired
    private ClienteRepository clienteRepository;

    public Cliente autenticar(String nome, String cpf) {
        return clienteRepository.findByNomeAndCpf(nome, cpf)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }
}
    