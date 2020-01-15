package migsoft.service;

import migsoft.controller.request.FormulaRequest;
import migsoft.controller.response.FormulaResponse;

import java.util.List;

public interface FormulaService {
    FormulaResponse findById(Integer id);
    List<FormulaResponse> findAll();
    FormulaResponse save(FormulaRequest formula);
    FormulaResponse update(FormulaRequest formula, Integer id);
    void deleteById(Integer id);
}
