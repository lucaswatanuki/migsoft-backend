package migsoft.service;


import migsoft.exceptions.EstoqueException;
import migsoft.model.ProdutoEntity;

public interface EstoqueService {
    ProdutoEntity findProdutoById(Integer id);
    ProdutoEntity findProdutoByNome(String nome);
    void updateProdutoEstoque(Integer id, Integer qtdPedido) throws EstoqueException;
    void addEstoque(Integer produtoId, Integer quantidade) throws EstoqueException;
    void subEstoque(Integer produtoId, Integer quantidade) throws EstoqueException;
}
