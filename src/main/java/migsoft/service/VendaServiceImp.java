package migsoft.service;

import migsoft.Exceptions.EstoqueException;
import migsoft.model.VendaEntity;
import migsoft.model.request.VendaRequest;
import migsoft.model.response.VendaResponse;
import migsoft.repository.ClienteRepository;
import migsoft.repository.ProdutoRepository;
import migsoft.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
        ArrayList<VendaResponse> vendaResponses = new ArrayList<>();
        for (VendaEntity vendaEntity: vendaRepository.findAll()){
            VendaResponse vendaResponse = new VendaResponse();
            vendaResponse = entitytoResponseConverter(vendaEntity);
            vendaResponses.add(vendaResponse);
        }
        return vendaResponses;
    }

    @Override
    public VendaResponse save(VendaEntity venda) {
        venda.setTotal(venda.getQuantidade() * venda.getProduto().getPreco());
        dateConverter(venda);
        VendaResponse vendaResponse = entitytoResponseConverter(vendaRepository.save(venda));
        return vendaResponse;
    }



    @Override
    public VendaResponse update(VendaRequest venda, Integer id) throws EstoqueException {
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
        return vendaResponse;
    }

    public VendaEntity requestToEntityConverter(VendaRequest vendaRequest){
        VendaEntity vendaEntity = new VendaEntity();
        vendaEntity.setData(vendaRequest.getData());
        vendaEntity.setProduto(produtoRepository.findByNome(vendaRequest.getProduto()));
        vendaEntity.setCliente(clienteRepository.findByNome(vendaRequest.getCliente()));
        vendaEntity.setQuantidade(vendaRequest.getQuantidade());
        return vendaEntity;
    }

    public void dateConverter(VendaEntity venda){
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(venda.getData(), inputFormatter);
        String formattedDate = outputFormatter.format(date);
        venda.setData(formattedDate);
    }
}
