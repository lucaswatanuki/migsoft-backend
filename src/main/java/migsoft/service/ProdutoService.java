package migsoft.service;

import migsoft.model.ProdutoEntity;
import migsoft.model.response.ProdutoResponse;

import java.util.List;

public interface ProdutoService {
     ProdutoResponse findById(Integer id);
     ProdutoResponse findByNome(String nome);
     List<ProdutoResponse> findAll();
     ProdutoResponse save(ProdutoEntity produto);
     ProdutoResponse update(ProdutoEntity produto);
     void deleteById(Integer id);
}
