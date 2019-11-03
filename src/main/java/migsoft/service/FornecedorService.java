package migsoft.service;

import migsoft.model.FornecedorEntity;
import migsoft.model.response.FornecedorResponse;

import java.util.List;

public interface FornecedorService {
     FornecedorResponse findById(Integer id);
     FornecedorEntity findByNomeFantasia(String nomeFantasia);
     FornecedorEntity findByCnpj(String cnpj);
     List<FornecedorResponse> findAll();
     FornecedorResponse save(FornecedorEntity fornecedor);
     FornecedorResponse update(FornecedorEntity fornecedor);
     void deleteById(Integer id);
}
