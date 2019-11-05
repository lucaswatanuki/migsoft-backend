package migsoft.service;

import migsoft.model.ItemProduto;
import migsoft.model.PedidoEntity;
import migsoft.model.response.ItemProdutoResponse;
import migsoft.model.response.PedidoResponse;
import migsoft.model.response.ProdutoResponse;
import migsoft.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoServiceImp implements PedidoService{

    private PedidoRepository pedidoRepository;

    @Autowired
    public PedidoServiceImp(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public PedidoResponse findById(Integer id) {
        return entitytoResponseConverter(pedidoRepository.findById(id).orElse(null));
    }

    @Override
    public List<PedidoResponse> findAll() {
        ArrayList<PedidoResponse> pedidoResponses = new ArrayList<>();
        for (PedidoEntity pedidoEntity: pedidoRepository.findAll()){
            PedidoResponse pedidoResponse = new PedidoResponse();
            pedidoResponse = entitytoResponseConverter(pedidoEntity);
            pedidoResponses.add(pedidoResponse);
        }
        return pedidoResponses;
    }

    @Override
    public PedidoResponse save(PedidoEntity pedido) {
        PedidoResponse pedidoResponse = entitytoResponseConverter(pedidoRepository.save(pedido));
        return pedidoResponse;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void atualizarEstoque(Integer id, Integer qtdPedido) {
        PedidoResponse pedidoResponse = this.findById(id);
        pedidoResponse.getQuantidade();
    }

    @Override
    public PedidoResponse update(PedidoEntity pedido) {
        PedidoResponse pedidoResponse = entitytoResponseConverter(pedidoRepository.save(pedido));
        return pedidoResponse;
    }

    @Override
    public void deleteById(Integer id) {
        pedidoRepository.deleteById(id);
    }

    public PedidoResponse entitytoResponseConverter(PedidoEntity pedidoEntity){
        PedidoResponse pedidoResponse = new PedidoResponse();
        pedidoResponse.setId(pedidoEntity.getId());
        pedidoResponse.setData(pedidoEntity.getData());
        pedidoResponse.setFornecedor(pedidoEntity.getFornecedor().getNomeFantasia());
        pedidoResponse.setProduto(pedidoEntity.getProduto().getNome());
        pedidoResponse.setQuantidade(pedidoEntity.getQuantidade());
        return pedidoResponse;
    }


    public PedidoEntity entitytoResponseConverter(PedidoResponse pedidoResponse){
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setId(pedidoResponse.getId());
        pedidoEntity.setData(pedidoResponse.getData());
        pedidoEntity.setQuantidade(pedidoResponse.getQuantidade());
        return pedidoEntity;
    }
}
