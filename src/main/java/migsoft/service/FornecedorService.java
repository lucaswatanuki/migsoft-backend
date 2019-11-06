package migsoft.service;

import migsoft.model.FornecedorEntity;
import migsoft.model.response.FornecedorResponse;

import java.util.List;

public interface FornecedorService {
     FornecedorResponse findById(Integer id);
     List<FornecedorResponse> findAll();
     FornecedorResponse save(FornecedorEntity fornecedor);
     FornecedorResponse update(FornecedorEntity fornecedor);
     void deleteById(Integer id);
}
