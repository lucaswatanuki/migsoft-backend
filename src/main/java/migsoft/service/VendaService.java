package migsoft.service;

import migsoft.model.VendaEntity;
import migsoft.model.response.VendaResponse;

import java.util.List;

public interface VendaService {
     VendaResponse findById(Integer id);
     List<VendaResponse> findAll();
     VendaResponse save(VendaEntity venda);
     VendaResponse update(VendaEntity venda);
}
