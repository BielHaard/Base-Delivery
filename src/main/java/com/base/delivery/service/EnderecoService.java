package com.base.delivery.service;

import com.base.delivery.entity.Endereco;

import java.util.List;

public interface EnderecoService {

    List<Endereco> listarEnderecos();

    Endereco buscarEnderecoPorId(Long id);

    Endereco adicionarEndereco(Endereco endereco);

    Endereco atualizarEndereco(Long id, Endereco endereco);

    void deletarEndereco(Long id);

}
