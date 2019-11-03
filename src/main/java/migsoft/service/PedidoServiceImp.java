package migsoft.service;

import migsoft.model.ItemProduto;
import migsoft.model.PedidoEntity;
import migsoft.model.response.ItemProdutoResponse;
import migsoft.model.response.PedidoResponse;
import migsoft.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

/*
        ArrayList<ItemProdutoResponse> itemProdutoList = new ArrayList<>();
        for (ItemProduto itemProduto : pedidoEntity.getItemProdutos()){
            ItemProdutoResponse itemProdutoResponse = new ItemProdutoResponse();
            itemProdutoResponse.setId(itemProduto.getId());
            itemProdutoResponse.setProduto(itemProduto.getProduto().getNome());
            itemProdutoResponse.setQuantidade(itemProduto.getQuantidade());
            itemProdutoList.add(itemProdutoResponse);
        }

        pedidoResponse.setItemProduto(itemProdutoList);*/

        return pedidoResponse;
    }
}
