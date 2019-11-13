package migsoft.service;

import migsoft.model.FormulaProdutoEntity;
import migsoft.model.response.FormulaResponse;
import migsoft.repository.FormulaRepository;
import org.hibernate.mapping.Formula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormulaServiceImp implements FormulaService {

    private final FormulaRepository formulaRepository;

    @Autowired
    public FormulaServiceImp(FormulaRepository formulaRepository) {
        this.formulaRepository = formulaRepository;
    }

    @Override
    public FormulaResponse findById(Integer id) {
        return entitytoResponseConverter(formulaRepository.findById(id).orElse(null));
    }

    @Override
    public List<FormulaResponse> findAll() {
        ArrayList<FormulaResponse> formulaResponses = new ArrayList<>();
        for (FormulaProdutoEntity formulaProdutoEntity : formulaRepository.findAll()) {
            FormulaResponse formulaResponse = new FormulaResponse();
            formulaResponse = entitytoResponseConverter(formulaProdutoEntity);
            formulaResponses.add(formulaResponse);
        }
        return formulaResponses;
    }

    @Override
    public FormulaResponse save(FormulaProdutoEntity formula) {
        FormulaResponse formulaResponse = entitytoResponseConverter(formulaRepository.save(formula));
        return formulaResponse;
    }

    @Override
    public FormulaResponse update(FormulaProdutoEntity formula) {
        FormulaResponse formulaResponse = entitytoResponseConverter(formulaRepository.save(formula));
        return formulaResponse;
    }

    @Override
    public void deleteById(Integer id) {
        formulaRepository.findById(id);
    }

    public FormulaResponse entitytoResponseConverter(FormulaProdutoEntity formulaProdutoEntity) {
        FormulaResponse formulaResponse = new FormulaResponse();
        formulaResponse.setId(formulaProdutoEntity.getId());
        formulaResponse.setProduto(formulaProdutoEntity.getProduto().getNome());
        formulaResponse.setDescricao(formulaProdutoEntity.getDescricao());
        formulaResponse.setQuantidade(formulaProdutoEntity.getQuantidade());
        formulaResponse.setMaterial(formulaProdutoEntity.getMaterial());
        return formulaResponse;
    }
}
