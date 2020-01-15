package migsoft.service;

import migsoft.Exceptions.EstoqueException;
import migsoft.model.VendaEntity;
import migsoft.controller.request.VendaRequest;
import migsoft.controller.response.VendaResponse;

import java.util.List;

public interface VendaService {
     VendaResponse findById(Integer id);
     VendaEntity findEntityById(Integer id);
     List<VendaResponse> findAll();
     public VendaResponse cancel(Integer id);
     VendaResponse save(VendaRequest venda);
     VendaResponse update(VendaRequest venda, Integer id) throws EstoqueException;
}
