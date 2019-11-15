package migsoft.service;

import migsoft.model.CotacaoEntity;
import migsoft.model.response.CotacaoResponse;

import java.util.List;

public interface CotacaoService {
     CotacaoResponse updateStatus(Integer id);
     CotacaoResponse findById(Integer id);
     CotacaoResponse aprove(Integer id);
     CotacaoEntity getId(Integer id);
     List<CotacaoResponse> findAll();
     List<CotacaoResponse> findOnlyApproved();
     CotacaoResponse save(CotacaoEntity cotacao);
     CotacaoResponse update(CotacaoEntity cotacao);
     void deleteById(Integer id);
}
