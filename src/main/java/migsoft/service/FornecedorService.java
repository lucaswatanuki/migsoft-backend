package migsoft.service;

import migsoft.model.FornecedorEntity;

import java.util.List;

public interface FornecedorService {
     FornecedorEntity findById(int id);
     FornecedorEntity findByNomeFantasia(String nomeFantasia);
     FornecedorEntity findByCnpj(String cnpj);
     List<FornecedorEntity> findAll();
     FornecedorEntity save(FornecedorEntity fornecedor);
     FornecedorEntity update(FornecedorEntity fornecedor);
     void deleteById(int id);
}
