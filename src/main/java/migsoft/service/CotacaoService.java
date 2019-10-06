package migsoft.service;

import migsoft.model.CotacaoEntity;

import java.util.List;

public interface CotacaoService {
     CotacaoEntity findById(int id);
     List<CotacaoEntity> findAll();
     CotacaoEntity save(CotacaoEntity cotacao);
     CotacaoEntity update(CotacaoEntity cotacao);
     void deleteById(int id);
}
