package com.base.delivery.service.impl;

import com.base.delivery.entity.Endereco;
import com.base.delivery.exception.IdNotFoundException;
import com.base.delivery.repository.EnderecoRepository;
import com.base.delivery.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public List<Endereco> listarEnderecos() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco buscarEnderecoPorId(Long id) {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Endereço não encontrado com ID: " + id));
    }

    @Override
    public Endereco adicionarEndereco(Endereco endereco) {
        try {
            return enderecoRepository.save(endereco);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Erro ao adicionar o endereço. Verifique as restrições de integridade de dados.", e);
        }
    }

    @Override
    public Endereco atualizarEndereco(Long id, Endereco endereco) {
        enderecoRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Endereço não encontrado com ID: " + id));
        return enderecoRepository.save(endereco);
    }

    @Override
    public void deletarEndereco(Long id) {
        enderecoRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Endereço não encontrado com ID: " + id));
        enderecoRepository.deleteById(id);
    }
}
