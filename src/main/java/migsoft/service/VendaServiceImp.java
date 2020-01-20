package migsoft.service;

import migsoft.exceptions.ClienteInexistenteException;
import migsoft.exceptions.EstoqueException;
import migsoft.exceptions.ProdutoInexistenteException;
import migsoft.model.VendaEntity;
import migsoft.controller.request.VendaRequest;
import migsoft.controller.response.VendaResponse;
import migsoft.repository.ClienteRepository;
import migsoft.repository.ProdutoRepository;
import migsoft.repository.VendaRepository;
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
        return entitytoResponseConverter(vendaRepository.findById(id).orElse(null));
    }

    @Override
    public VendaEntity findEntityById(Integer id) {
        return vendaRepository.findById(id).orElse(null);
    }

    @Override
    public List<VendaResponse> findAll() {
        List<VendaResponse> vendaResponses = new ArrayList<>();
        vendaRepository.findAll().forEach(vendaEntity -> {
            VendaResponse vendaResponse = entitytoResponseConverter(vendaEntity);
            vendaResponses.add(vendaResponse);
        });
        return vendaResponses;
    }

    @Override
    public VendaResponse cancel(Integer id) {
        VendaEntity vendaEntity = vendaRepository.findById(id).orElse(null);
        vendaEntity.setStatus("Cancelado");
        VendaResponse vendaResponse = entitytoResponseConverter(vendaRepository.save(vendaEntity));
        return vendaResponse;
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
        VendaResponse vendaResponse = entitytoResponseConverter(vendaRepository.save(vendaEntity));
        return vendaResponse;
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
        VendaResponse vendaResponse = entitytoResponseConverter(vendaRepository.save(vendaEntity));
        return vendaResponse;
    }

    public VendaResponse entitytoResponseConverter(VendaEntity vendaEntity) {
        VendaResponse vendaResponse = new VendaResponse();
        vendaResponse.setId(vendaEntity.getId());
        vendaResponse.setCliente(vendaEntity.getCliente().getNome());
        vendaResponse.setQuantidade(vendaEntity.getQuantidade());
        vendaResponse.setTotal(vendaEntity.getTotal());
        vendaResponse.setProduto(vendaEntity.getProduto().getNome());
        vendaResponse.setData(vendaEntity.getData());
        vendaResponse.setStatus(vendaEntity.getStatus());
        return vendaResponse;
    }

    public VendaEntity requestToEntityConverter(VendaRequest vendaRequest) {
        VendaEntity vendaEntity = new VendaEntity();
        vendaEntity.setData(vendaRequest.getData());
        vendaEntity.setProduto(produtoRepository.findByNome(vendaRequest.getProduto()));
        vendaEntity.setCliente(clienteRepository.findByNome(vendaRequest.getCliente()));
        vendaEntity.setQuantidade(vendaRequest.getQuantidade());
        return vendaEntity;
    }

 /*   public void dateConverter(VendaEntity venda){
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(venda.getData(), inputFormatter);
        String formattedDate = outputFormatter.format(date);
        venda.setData(formattedDate);
    }*/
}
