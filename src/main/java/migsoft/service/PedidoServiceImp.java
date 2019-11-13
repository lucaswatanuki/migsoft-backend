package migsoft.service;

import migsoft.model.CotacaoEntity;
import migsoft.model.PedidoEntity;
import migsoft.model.request.PedidoRequest;
import migsoft.model.response.CotacaoResponse;
import migsoft.model.response.PedidoResponse;
import migsoft.repository.CotacaoRepository;
import migsoft.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoServiceImp implements PedidoService{

    private final PedidoRepository pedidoRepository;
    private final CotacaoRepository cotacaoRepository;

    @Autowired
    public PedidoServiceImp(PedidoRepository pedidoRepository, CotacaoRepository cotacaoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.cotacaoRepository = cotacaoRepository;
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
    public PedidoResponse save(PedidoRequest pedido) {
        PedidoEntity pedidoEntity = requestToEntityConverter(pedido);
        pedidoEntity.setTotal(pedido.getCotacaoResponse().getQuantidade() * pedidoEntity.getCotacao().getProduto().getPreco());
        PedidoResponse pedidoResponse = entitytoResponseConverter(pedidoRepository.save(pedidoEntity));
        return pedidoResponse;
    }

    @Override
    public PedidoResponse update(PedidoEntity pedido) {
        pedido.setTotal(pedido.getQuantidade() * pedido.getCotacao().getProduto().getPreco());
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
        pedidoResponse.setCotacao(pedidoEntity.getCotacao().getId());
        pedidoResponse.setFornecedor(pedidoEntity.getCotacao().getFornecedor().getNomeFantasia());
        pedidoResponse.setProduto(pedidoEntity.getCotacao().getProduto().getNome());
        pedidoResponse.setProduto_id(pedidoEntity.getCotacao().getProduto().getId());
        pedidoResponse.setQuantidade(pedidoEntity.getCotacao().getQuantidade());
        pedidoResponse.setTotal(pedidoEntity.getTotal());
        return pedidoResponse;
    }

    public PedidoEntity requestToEntityConverter(PedidoRequest pedidoRequest){
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setData(pedidoRequest.getData());
        pedidoEntity.setCotacao(cotacaoRepository.findById(pedidoRequest.getCotacaoResponse().getId()).orElse(null));
        return pedidoEntity;
    }

}
