package migsoft.service;


import migsoft.model.PedidoEntity;
import migsoft.model.ProdutoEntity;
import migsoft.model.response.PedidoResponse;
import migsoft.model.response.ProdutoResponse;

public interface EstoqueService {
    ProdutoEntity findProdutoById(Integer id);
    void updateProdutoEstoque(Integer id, Integer qtdPedido);
    void addPedidoEstoque(Integer produtoId, Integer quantidade);
    void subVendaEstoque(Integer produtoId, Integer quantidade);
}
