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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
        List<PedidoResponse> pedidoResponses = new ArrayList<>();
        pedidoRepository.findAll().forEach(pedidoEntity -> {
            PedidoResponse pedidoResponse = entitytoResponseConverter(pedidoEntity);
            pedidoResponses.add(pedidoResponse);
        });
        return pedidoResponses;
    }

    @Override
    public PedidoResponse save(PedidoRequest pedido) {
        dateConverter(pedido);
        PedidoEntity pedidoEntity = requestToEntityConverter(pedido);
        pedidoEntity.setStatus("Aguardando transportadora");
        pedidoEntity.setTotal(pedido.getCotacaoResponse().getQuantidade() * pedidoEntity.getCotacao().getProduto().getPreco());
        PedidoResponse pedidoResponse = entitytoResponseConverter(pedidoRepository.save(pedidoEntity));
        return pedidoResponse;
    }

    @Override
    public PedidoResponse update(Integer id, PedidoRequest pedidoRequest) {
        PedidoEntity pedidoEntity = pedidoRepository.findById(id).orElse(null);
        dateConverter(pedidoRequest);
        pedidoEntity.setData(pedidoRequest.getData());
        pedidoEntity.setCotacao(cotacaoRepository.findById(pedidoRequest.getCotacaoResponse().getId()).orElse(null));
        pedidoEntity.setTotal(pedidoRequest.getCotacaoResponse().getTotal());
        PedidoResponse pedidoResponse = entitytoResponseConverter(pedidoRepository.save(pedidoEntity));
        return pedidoResponse;
    }

    @Override
    public PedidoResponse updateStatus(Integer id) {
        PedidoEntity pedidoEntity = pedidoRepository.findById(id).orElse(null);
        pedidoEntity.setStatus("Entregue");
        PedidoResponse pedidoResponse = entitytoResponseConverter(pedidoRepository.save(pedidoEntity));
        return pedidoResponse;
    }

    @Override
    public PedidoResponse cancel(Integer id) {
        PedidoEntity pedidoEntity = pedidoRepository.findById(id).orElse(null);
        pedidoEntity.setStatus("Cancelado");
        PedidoResponse pedidoResponse = entitytoResponseConverter(pedidoRepository.save(pedidoEntity));
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
        pedidoResponse.setStatus(pedidoEntity.getStatus());
        return pedidoResponse;
    }

    public PedidoEntity requestToEntityConverter(PedidoRequest pedidoRequest){
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setData(pedidoRequest.getData());
        pedidoEntity.setCotacao(cotacaoRepository.findById(pedidoRequest.getCotacaoResponse().getId()).orElse(null));
        return pedidoEntity;
    }

    public void dateConverter(PedidoRequest pedido){
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(pedido.getData(), inputFormatter);
        String formattedDate = outputFormatter.format(date);
        pedido.setData(formattedDate);
    }

}
