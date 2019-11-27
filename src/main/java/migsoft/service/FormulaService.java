package migsoft.service;

import migsoft.model.FormulaProdutoEntity;
import migsoft.model.request.FormulaRequest;
import migsoft.model.response.FormulaResponse;

import java.util.List;

public interface FormulaService {
    FormulaResponse findById(Integer id);
    List<FormulaResponse> findAll();
    FormulaResponse save(FormulaRequest formula);
    FormulaResponse update(FormulaRequest formula, Integer id);
    void deleteById(Integer id);
}
