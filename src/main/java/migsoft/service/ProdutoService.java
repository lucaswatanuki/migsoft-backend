package migsoft.service;

import migsoft.model.ProdutoEntity;
import migsoft.controller.response.ProdutoResponse;

import java.util.List;

public interface ProdutoService {
     ProdutoEntity findById(Integer id);
     ProdutoEntity findByNome(String nome);
     List<ProdutoEntity> findAll();
     ProdutoEntity save(ProdutoEntity produto);
     ProdutoEntity update(ProdutoEntity produto);
     void deleteById(Integer id);
}
