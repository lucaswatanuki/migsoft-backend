package migsoft.service;

import migsoft.model.VendaEntity;

import java.util.List;

public interface VendaService {
     VendaEntity findById(int id);
     List<VendaEntity> findAll();
     VendaEntity save(VendaEntity venda);
     VendaEntity update(VendaEntity venda);
}
