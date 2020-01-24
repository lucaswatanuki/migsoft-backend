package migsoft.service;

import migsoft.controller.mappers.VendaMapper;
import migsoft.exceptions.ClienteInexistenteException;
import migsoft.exceptions.EstoqueException;
import migsoft.exceptions.ProdutoInexistenteException;
import migsoft.model.VendaEntity;
import migsoft.controller.request.VendaRequest;
import migsoft.controller.response.VendaResponse;
import migsoft.repository.ClienteRepository;
import migsoft.repository.ProdutoRepository;
import migsoft.repository.VendaRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendaServiceImp implements VendaService {

    private final VendaRepository vendaRepository;
    private final ProdutoRepository produtoRepository;
    private final ClienteRepository clienteRepository;
    private final EstoqueService estoqueService;

    @Autowired
    public VendaServiceImp(VendaRepository vendaRepository, ProdutoRepository produtoRepository, ClienteRepository clienteRepository, EstoqueService estoqueService) {
        this.vendaRepository = vendaRepository;
        this.produtoRepository = produtoRepository;
        this.clienteRepository = clienteRepository;
        this.estoqueService = estoqueService;
    }

    @Override
    public VendaResponse findById(Integer id) {
        return Mappers.getMapper(VendaMapper.class).toVendaResponse(vendaRepository.findById(id).orElse(null));
    }

    @Override
    public VendaEntity findEntityById(Integer id) {
        return vendaRepository.findById(id).orElse(null);
    }

    @Override
    public List<VendaResponse> findAll() {
        List<VendaResponse> vendaResponses = new ArrayList<>();
        vendaRepository.findAll().forEach(vendaEntity -> {
            vendaResponses.add(Mappers.getMapper(VendaMapper.class).toVendaResponse(vendaEntity));
        });
        return vendaResponses;
    }

    @Override
    public VendaResponse cancel(Integer id) {
        VendaEntity vendaEntity = vendaRepository.findById(id).orElse(null);
        vendaEntity.setStatus("Cancelado");
        return Mappers.getMapper(VendaMapper.class).toVendaResponse(vendaRepository.save(vendaEntity));
    }

    @Override
    public VendaResponse save(VendaRequest venda) {
        VendaEntity vendaEntity = requestToEntityConverter(venda);
        if (produtoRepository.findByNome(vendaEntity.getProduto().getNome()) == null) {
            throw new ProdutoInexistenteException("Produto não cadastrado");
        }
        if (clienteRepository.findByNome(vendaEntity.getCliente().getNome()) == null) {
            throw new ClienteInexistenteException("Cliente não cadastrado");
        }
        vendaEntity.setTotal(venda.getQuantidade() * vendaEntity.getProduto().getPreco());
        vendaEntity.setStatus("OK");
        return Mappers.getMapper(VendaMapper.class).toVendaResponse(vendaRepository.save(vendaEntity));
    }


    @Override
    public VendaResponse update(VendaRequest venda, Integer id) throws EstoqueException {
        if (produtoRepository.findByNome(venda.getProduto()) == null) {
            throw new ProdutoInexistenteException("Produto não cadastrado");
        }
        if (clienteRepository.findByNome(venda.getCliente()) == null) {
            throw new ClienteInexistenteException("Cliente não cadastrado");
        }
        VendaEntity vendaEntity = requestToEntityConverter(venda);
        vendaEntity.setId(id);
        vendaEntity.setTotal(vendaEntity.getQuantidade() * vendaEntity.getProduto().getPreco());
        return Mappers.getMapper(VendaMapper.class).toVendaResponse(vendaEntity);
    }

    public VendaEntity requestToEntityConverter(VendaRequest vendaRequest) {
        VendaEntity vendaEntity = new VendaEntity();
        vendaEntity.setData(vendaRequest.getData());
        vendaEntity.setProduto(produtoRepository.findByNome(vendaRequest.getProduto()));
        vendaEntity.setCliente(clienteRepository.findByNome(vendaRequest.getCliente()));
        vendaEntity.setQuantidade(vendaRequest.getQuantidade());
        return vendaEntity;
    }
}
