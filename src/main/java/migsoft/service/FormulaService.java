package migsoft.service;

import migsoft.model.FormulaProdutoEntity;

import java.util.List;

public interface FormulaService {
    FormulaProdutoEntity findById(int id);
    List<FormulaProdutoEntity> findAll();
    FormulaProdutoEntity save(FormulaProdutoEntity formula);
    FormulaProdutoEntity update(FormulaProdutoEntity formula);
    void deleteById(int id);
}
