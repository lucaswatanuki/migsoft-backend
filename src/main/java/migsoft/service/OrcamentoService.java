package migsoft.service;

import migsoft.model.OrcamentoEntity;
import migsoft.model.request.OrcamentoRequest;
import migsoft.model.response.OrcamentoResponse;

import java.util.List;

public interface OrcamentoService {
     OrcamentoResponse findById(Integer id);
     List<OrcamentoResponse> findAll();
     OrcamentoResponse save(OrcamentoRequest orcamento);
     OrcamentoResponse update(OrcamentoRequest orcamento);
     void deleteById(Integer id);
}
