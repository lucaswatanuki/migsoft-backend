package migsoft.service;

import migsoft.controller.request.OrcamentoRequest;
import migsoft.controller.response.OrcamentoResponse;

import java.util.List;

public interface OrcamentoService {
     OrcamentoResponse findById(Integer id);
     List<OrcamentoResponse> findAll();
     OrcamentoResponse save(OrcamentoRequest orcamento);
     OrcamentoResponse update(OrcamentoRequest orcamento);
     void deleteById(Integer id);
}
