package migsoft.service;

import migsoft.model.ProdutoEntity;

import java.util.List;

public interface ProdutoService {
     ProdutoEntity findById(int id);
     ProdutoEntity findByName(String nome);
     List<ProdutoEntity> findAll();
     ProdutoEntity save(ProdutoEntity produto);
     ProdutoEntity update(ProdutoEntity produto);
     void deleteById(int id);
}
