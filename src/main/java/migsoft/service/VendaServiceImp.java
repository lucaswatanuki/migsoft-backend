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
        VendaResponse vendaResponse = entitytoResponseConverter(vendaRepository.save(venda));
        return vendaResponse;
    }

    @Override
    public VendaResponse update(VendaEntity venda) {
        VendaResponse vendaResponse = entitytoResponseConverter(vendaRepository.save(venda));
        return vendaResponse;
    }

    public VendaResponse entitytoResponseConverter(VendaEntity vendaEntity) {
        VendaResponse vendaResponse = new VendaResponse();
        vendaResponse.setId(vendaEntity.getId());
        vendaResponse.setCliente(vendaEntity.getCliente().getId());

        ArrayList<ItemProdutoResponse> itemProdutoList = new ArrayList<>();
        for (ItemProduto itemProduto : vendaEntity.getItemvenda()) {
            ItemProdutoResponse itemProdutoResponse = new ItemProdutoResponse();
            itemProdutoResponse.setId(itemProduto.getId());
            itemProdutoResponse.setQuantidade(itemProduto.getQuantidade());
            itemProdutoResponse.setProduto(itemProduto.getProduto().getNome());
            itemProdutoList.add(itemProdutoResponse);
        }
        vendaResponse.setItemProdutos(itemProdutoList);
        vendaResponse.setTotal(vendaEntity.getTotal());
        return vendaResponse;
    }
}
