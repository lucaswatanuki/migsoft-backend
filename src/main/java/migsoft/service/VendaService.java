package migsoft.service;

import migsoft.Exceptions.EstoqueException;
import migsoft.model.VendaEntity;
import migsoft.model.request.VendaRequest;
import migsoft.model.response.VendaResponse;

import java.util.List;

public interface VendaService {
     VendaResponse findById(Integer id);
     VendaEntity findEntityById(Integer id);
     List<VendaResponse> findAll();
     VendaResponse save(VendaEntity venda);
     VendaResponse update(VendaRequest venda, Integer id) throws EstoqueException;
}
