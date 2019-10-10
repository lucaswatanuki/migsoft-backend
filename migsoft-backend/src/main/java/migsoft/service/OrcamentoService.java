package migsoft.service;

import migsoft.model.OrcamentoEntity;

import java.util.List;

public interface OrcamentoService {
     OrcamentoEntity findById(int id);
     List<OrcamentoEntity> findAll();
     OrcamentoEntity save(OrcamentoEntity orcamento);
     OrcamentoEntity update(OrcamentoEntity orcamento);
     void deleteById(int id);
}
