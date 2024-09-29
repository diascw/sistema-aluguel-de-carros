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

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public void adicionarCliente(Cliente cliente) {
        System.out.println("Salvando cliente: " + cliente.getNome());
        clienteRepository.save(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public void atualizarCliente(Long id, Cliente cliente) {
        Cliente clienteExistente = buscarPorId(id);
        if (clienteExistente != null) {
            clienteExistente.setNome(cliente.getNome());
            clienteExistente.setCpf(cliente.getCpf());
            clienteExistente.setRg(cliente.getRg());
            clienteExistente.setEndereco(cliente.getEndereco());
            clienteExistente.setProfissao(cliente.getProfissao());
            clienteRepository.save(clienteExistente);
        }
    }

    public void removerCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
