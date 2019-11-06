package migsoft.service;

import migsoft.model.ItemProduto;
import migsoft.model.VendaEntity;
import migsoft.model.response.ItemProdutoResponse;
import migsoft.model.response.VendaResponse;
import migsoft.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendaServiceImp implements VendaService {

    private final VendaRepository vendaRepository;

    @Autowired
    public VendaServiceImp(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    @Override
    public VendaResponse findById(Integer id) {
        return entitytoResponseConverter(vendaRepository.findById(id).orElse(null));
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
        VendaResponse vendaResponse = entitytoResponseConverter(vendaRepository.save(venda));
        return vendaResponse;
    }

    @Override
    public VendaResponse update(VendaEntity venda) {
        venda.setTotal(venda.getQuantidade() * venda.getProduto().getPreco());
        VendaResponse vendaResponse = entitytoResponseConverter(vendaRepository.save(venda));
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
}
