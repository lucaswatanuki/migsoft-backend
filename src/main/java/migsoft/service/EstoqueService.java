package migsoft.service;


import migsoft.Exceptions.EstoqueException;
import migsoft.model.PedidoEntity;
import migsoft.model.ProdutoEntity;
import migsoft.model.response.PedidoResponse;
import migsoft.model.response.ProdutoResponse;

public interface EstoqueService {
    ProdutoEntity findProdutoById(Integer id);
    void updateProdutoEstoque(Integer id, Integer qtdPedido) throws EstoqueException;
    void addPedidoEstoque(Integer produtoId, Integer quantidade) throws EstoqueException;
    void subVendaEstoque(Integer produtoId, Integer quantidade) throws EstoqueException;
}
