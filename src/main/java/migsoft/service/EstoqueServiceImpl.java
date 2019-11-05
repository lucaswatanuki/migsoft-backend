package migsoft.service;

import migsoft.model.PedidoEntity;
import migsoft.model.ProdutoEntity;
import migsoft.model.response.PedidoResponse;
import migsoft.model.response.ProdutoResponse;
import migsoft.repository.PedidoRepository;
import migsoft.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstoqueServiceImpl implements EstoqueService {

    private final ProdutoRepository produtoRepository;
    private final PedidoRepository pedidoRepository;

    @Autowired
    public EstoqueServiceImpl(ProdutoRepository produtoRepository, PedidoRepository pedidoRepository) {
        this.produtoRepository = produtoRepository;
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public ProdutoEntity findProdutoById(Integer id) {
        return produtoRepository.findById(id).orElse(null);
    }


    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void updateProdutoEstoque(Integer id, Integer quantidade) {
        ProdutoEntity produto = this.findProdutoById(id);
        if (produto == null) {
            //Implementar exception customizada
            System.out.println("produto nao existe");
        }
        Integer qtdEstoque = produto.getQtdEstoque() + quantidade;
        if (qtdEstoque > 0){
            //implementar exception
            System.out.println("estoque insuficiente");
        }
        produto.setQtdEstoque(qtdEstoque);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addPedidoEstoque(Integer produtoId, Integer quantidade) {
        updateProdutoEstoque(produtoId, quantidade);
    }

    @Override
    public void subVendaEstoque(Integer produtoId, Integer quantidade) {
        updateProdutoEstoque(produtoId, -quantidade);
    }
}
