package migsoft.service;

import migsoft.model.CotacaoEntity;
import migsoft.controller.request.CotacaoRequest;
import migsoft.controller.response.CotacaoResponse;

import java.util.List;

public interface CotacaoService {
     CotacaoResponse updateStatus(Integer id);
     CotacaoResponse findById(Integer id);
     CotacaoResponse aproveById(Integer id);
     CotacaoEntity getId(Integer id);
     List<CotacaoResponse> findAll();
     List<CotacaoResponse> findOnlyApproved();
     CotacaoResponse save(CotacaoRequest cotacao);
     CotacaoResponse update(CotacaoRequest cotacao, Integer id);
     void deleteById(Integer id);
}
