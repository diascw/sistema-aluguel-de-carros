package com.sistema.alugueldecarros.services;

import com.sistema.alugueldecarros.models.Cliente;
import com.sistema.alugueldecarros.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Método para listar todos os clientes (somente admin pode listar)
    public List<Cliente> listarTodos(Cliente clienteLogado) {
        if (clienteLogado != null && "admin".equalsIgnoreCase(clienteLogado.getProfissao())) {
            return clienteRepository.findAll();
        } else {
            throw new RuntimeException("Acesso negado! Apenas admins podem acessar esta página.");
        }
    }

    public void adicionarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente login(String nome, String cpf) {
        return clienteRepository.findByNomeAndCpf(nome, cpf)
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }
}
