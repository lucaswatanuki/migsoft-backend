package migsoft.service;

import migsoft.model.CotacaoEntity;
import migsoft.model.response.CotacaoResponse;

import java.util.List;

public interface CotacaoService {
     CotacaoResponse updateStatus(Integer id);
     CotacaoResponse findById(Integer id);
     CotacaoEntity getId(Integer id);
     List<CotacaoResponse> findAll();
     CotacaoResponse save(CotacaoEntity cotacao);
     CotacaoResponse update(CotacaoEntity cotacao);
     void deleteById(Integer id);
}
