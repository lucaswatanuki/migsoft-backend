package migsoft.service;

import migsoft.model.ItemVendaEntity;
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
    public ItemVendaEntity findById(int id) {
        return itemVendaRepository.findById(id);
    }

    @Override
    public List<ItemVendaEntity> findAll() {
        return itemVendaRepository.findAll();
    }

    @Override
    public ItemVendaEntity save(ItemVendaEntity item) {
        return itemVendaRepository.save(item);
    }

    @Override
    public ItemVendaEntity update(ItemVendaEntity item) {
        return itemVendaRepository.save(item);
    }

    @Override
    public void deleteById(int id) {
        itemVendaRepository.delete(itemVendaRepository.findById(id));
    }
}
