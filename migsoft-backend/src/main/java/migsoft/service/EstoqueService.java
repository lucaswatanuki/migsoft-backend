package migsoft.service;

import migsoft.model.EstoqueEntity;
import migsoft.model.ProdutoEntity;

import java.util.List;

public interface EstoqueService {
     EstoqueEntity findById(int id);
     EstoqueEntity findByProduto(ProdutoEntity produto);
     List<EstoqueEntity> findAll();
     EstoqueEntity save(EstoqueEntity estoque);
     EstoqueEntity update(EstoqueEntity estoque);
     void deleteById(int id);
}

