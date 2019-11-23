package migsoft.service;


import migsoft.Exceptions.EstoqueException;
import migsoft.model.PedidoEntity;
import migsoft.model.ProdutoEntity;
import migsoft.model.response.PedidoResponse;
import migsoft.model.response.ProdutoResponse;

public interface EstoqueService {
    ProdutoEntity findProdutoById(Integer id);
    ProdutoEntity findProdutoByNome(String nome);
    void updateProdutoEstoque(Integer id, Integer qtdPedido) throws EstoqueException;
    void addEstoque(Integer produtoId, Integer quantidade) throws EstoqueException;
    void subEstoque(Integer produtoId, Integer quantidade) throws EstoqueException;
}
