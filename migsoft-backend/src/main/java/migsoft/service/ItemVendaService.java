package migsoft.service;

import migsoft.model.ItemVendaEntity;

import java.util.List;

public interface ItemVendaService {
     ItemVendaEntity findById(int id);
     List<ItemVendaEntity> findAll();
     ItemVendaEntity save(ItemVendaEntity item);
     ItemVendaEntity update(ItemVendaEntity item);
     void deleteById(int id);
}
