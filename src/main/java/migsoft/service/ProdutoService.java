package migsoft.service;

import migsoft.controller.request.ProdutoRequest;
import migsoft.model.ProdutoEntity;
import migsoft.controller.response.ProdutoResponse;

import java.util.List;

public interface ProdutoService {
     ProdutoResponse findById(Integer id);
     ProdutoResponse findByNome(String nome);
     List<ProdutoResponse> findAll();
     ProdutoResponse save(ProdutoRequest produto);
     ProdutoResponse update(ProdutoRequest produto, Integer id);
     void deleteById(Integer id);
}
