package migsoft.service;

import migsoft.controller.mappers.OrcamentoMapper;
import migsoft.model.OrcamentoEntity;
import migsoft.controller.request.OrcamentoRequest;
import migsoft.controller.response.OrcamentoResponse;
import migsoft.repository.ClienteRepository;
import migsoft.repository.OrcamentoRepository;
import migsoft.repository.ProdutoRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrcamentoServiceImp implements OrcamentoService {

    private final OrcamentoRepository orcamentoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    @Autowired
    public OrcamentoServiceImp(OrcamentoRepository orcamentoRepository, ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
        this.orcamentoRepository = orcamentoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    @Override
    public OrcamentoResponse findById(Integer id) {
        return Mappers.getMapper(OrcamentoMapper.class).toOrcamentoResponse(orcamentoRepository.findById(id).orElse(null));
    }

    @Override
    public List<OrcamentoResponse> findAll() {
        ArrayList<OrcamentoResponse> orcamentos = new ArrayList<>();
        for (OrcamentoEntity orcamentoEntity: orcamentoRepository.findAll()){
            OrcamentoResponse orcamentoResponse = new OrcamentoResponse();
            orcamentos.add(orcamentoResponse);
        }
        return orcamentos;
    }

    @Override
    public OrcamentoResponse save(OrcamentoRequest orcamento) {
        OrcamentoEntity orcamentoEntity = requestToEntityConverter(orcamento);
        orcamentoEntity.setTotal(orcamento.getQuantidade() * orcamentoEntity.getProduto().getPreco());
        return entitytoResponseConverter(orcamentoRepository.save(orcamentoEntity));
    }

    @Override
    public OrcamentoResponse update(OrcamentoRequest orcamento) {
        OrcamentoEntity orcamentoEntity = requestToEntityConverter(orcamento);
        orcamentoEntity.setTotal(orcamento.getQuantidade() * orcamentoEntity.getProduto().getPreco());
        return entitytoResponseConverter(orcamentoRepository.save(orcamentoEntity));
    }

    @Override
    public void deleteById(Integer id) {
        orcamentoRepository.deleteById(id);
    }

    public OrcamentoResponse entitytoResponseConverter(OrcamentoEntity orcamentoEntity){
        OrcamentoResponse orcamentoResponse = new OrcamentoResponse();
        orcamentoResponse.setId(orcamentoEntity.getId());
        orcamentoResponse.setData(orcamentoEntity.getData());
        orcamentoResponse.setCliente(orcamentoEntity.getCliente().getNome());
        orcamentoResponse.setProduto(orcamentoEntity.getProduto().getNome());
        orcamentoResponse.setQuantidade(orcamentoEntity.getQuantidade());
        orcamentoResponse.setTotal(orcamentoEntity.getTotal());
        return orcamentoResponse;
    }

    public OrcamentoEntity requestToEntityConverter(OrcamentoRequest orcamentoRequest){
        OrcamentoEntity orcamentoEntity = new OrcamentoEntity();
        orcamentoEntity.setData(orcamentoRequest.getData());
        orcamentoEntity.setCliente(clienteRepository.findByNome(orcamentoRequest.getCliente()));
        orcamentoEntity.setProduto(produtoRepository.findByNome(orcamentoRequest.getProduto()));
        orcamentoEntity.setQuantidade(orcamentoRequest.getQuantidade());
        return orcamentoEntity;
    }
}
