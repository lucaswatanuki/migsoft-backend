package migsoft.service;

import migsoft.model.FormulaProdutoEntity;
import migsoft.repository.FormulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormulaServiceImp implements FormulaService {

    private final FormulaRepository formulaRepository;

    @Autowired
    public FormulaServiceImp(FormulaRepository formulaRepository) {
        this.formulaRepository = formulaRepository;
    }

    @Override
    public FormulaProdutoEntity findById(int id) {
        return formulaRepository.findById(id);
    }

    @Override
    public List<FormulaProdutoEntity> findAll() {
        return formulaRepository.findAll();
    }

    @Override
    public FormulaProdutoEntity save(FormulaProdutoEntity formula) {
        return formulaRepository.save(formula);
    }

    @Override
    public FormulaProdutoEntity update(FormulaProdutoEntity formula) {
        return formulaRepository.save(formula);
    }

    @Override
    public void deleteById(int id) {
        formulaRepository.delete(formulaRepository.findById(id));
    }
}
