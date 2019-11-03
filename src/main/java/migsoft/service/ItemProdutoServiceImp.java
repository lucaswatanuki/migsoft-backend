package migsoft.service;

import migsoft.model.ItemProduto;
import migsoft.model.response.ItemProdutoResponse;
import migsoft.repository.ItemProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemProdutoServiceImp implements ItemProdutoService {

    private final ItemProdutoRepository itemVendaRepository;

    @Autowired
    public ItemProdutoServiceImp(ItemProdutoRepository itemVendaRepository) {
        this.itemVendaRepository = itemVendaRepository;
    }

    @Override
    public ItemProdutoResponse findById(Integer id) {
        return entitytoResponseConverter(itemVendaRepository.findById(id).orElse(null));
    }

    @Override
    public List<ItemProdutoResponse> findAll() {
        ArrayList<ItemProdutoResponse> itemProdutoResponses = new ArrayList<>();
        for (ItemProduto itemProduto: itemVendaRepository.findAll()){
            ItemProdutoResponse itemProdutoResponse = new ItemProdutoResponse();
            itemProdutoResponse = entitytoResponseConverter(itemProduto);
            itemProdutoResponses.add(itemProdutoResponse);
        }
        return itemProdutoResponses;
    }

    @Override
    public ItemProdutoResponse save(ItemProduto item) {
        ItemProdutoResponse itemProdutoResponse = entitytoResponseConverter(itemVendaRepository.save(item));
        return itemProdutoResponse;
    }

    @Override
    public ItemProdutoResponse update(ItemProduto item) {
        ItemProdutoResponse itemProdutoResponse = entitytoResponseConverter(itemVendaRepository.save(item));
        return itemProdutoResponse;
    }

    @Override
    public void deleteById(Integer id) {
        itemVendaRepository.deleteById(id);
    }

    public ItemProdutoResponse entitytoResponseConverter(ItemProduto itemProduto){
        ItemProdutoResponse itemProdutoResponse = new ItemProdutoResponse();
        itemProdutoResponse.setId(itemProduto.getId());
        itemProdutoResponse.setProduto(itemProduto.getProduto().getNome());
        itemProdutoResponse.setQuantidade(itemProduto.getQuantidade());
        return itemProdutoResponse;
    }
}
