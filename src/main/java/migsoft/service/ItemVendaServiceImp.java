package migsoft.service;

import migsoft.model.ItemProduto;
import migsoft.repository.ItemVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemVendaServiceImp implements ItemVendaService {

    private final ItemVendaRepository itemVendaRepository;

    @Autowired
    public ItemVendaServiceImp(ItemVendaRepository itemVendaRepository) {
        this.itemVendaRepository = itemVendaRepository;
    }

    @Override
    public ItemProduto findById(int id) {
        return itemVendaRepository.findById(id);
    }

    @Override
    public List<ItemProduto> findAll() {
        return itemVendaRepository.findAll();
    }

    @Override
    public ItemProduto save(ItemProduto item) {
        return itemVendaRepository.save(item);
    }

    @Override
    public ItemProduto update(ItemProduto item) {
        return itemVendaRepository.save(item);
    }

    @Override
    public void deleteById(int id) {
        itemVendaRepository.delete(itemVendaRepository.findById(id));
    }
}
