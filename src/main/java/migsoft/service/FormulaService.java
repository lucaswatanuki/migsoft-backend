package migsoft.service;

import migsoft.model.FormulaProdutoEntity;
import migsoft.model.response.FormulaResponse;

import java.util.List;

public interface FormulaService {
    FormulaResponse findById(Integer id);
    List<FormulaResponse> findAll();
    FormulaResponse save(FormulaProdutoEntity formula);
    FormulaResponse update(FormulaProdutoEntity formula);
    void deleteById(Integer id);
}
