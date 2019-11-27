package migsoft.service;

import migsoft.model.FormulaProdutoEntity;
import migsoft.model.request.FormulaRequest;
import migsoft.model.response.FormulaResponse;
import migsoft.repository.FormulaRepository;
import migsoft.repository.ProdutoRepository;
import org.hibernate.mapping.Formula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormulaServiceImp implements FormulaService {

    private final FormulaRepository formulaRepository;
    private final ProdutoRepository produtoRepository;

    @Autowired
    public FormulaServiceImp(FormulaRepository formulaRepository, ProdutoRepository produtoRepository) {
        this.formulaRepository = formulaRepository;
        this.produtoRepository = produtoRepository;
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
    public FormulaResponse save(FormulaRequest formula) {
        FormulaProdutoEntity formulaProdutoEntity = requestToEntityConverter(formula);
        FormulaResponse formulaResponse = entitytoResponseConverter(formulaRepository.save(formulaProdutoEntity));
        return formulaResponse;
    }

    @Override
    public FormulaResponse update(FormulaRequest formula, Integer id) {
        FormulaProdutoEntity formulaProdutoEntity = requestToEntityConverter(formula);
        formulaProdutoEntity.setId(id);
        FormulaResponse formulaResponse = entitytoResponseConverter(formulaRepository.save(formulaProdutoEntity));
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

    public FormulaProdutoEntity requestToEntityConverter(FormulaRequest formulaRequest){
        FormulaProdutoEntity formulaProdutoEntity = new FormulaProdutoEntity();
        formulaProdutoEntity.setDescricao(formulaRequest.getDescricao());
        formulaProdutoEntity.setMaterial(formulaRequest.getMaterial());
        formulaProdutoEntity.setQuantidade(formulaRequest.getQuantidade());
        formulaProdutoEntity.setProduto(produtoRepository.findByNome(formulaRequest.getProduto()));
        return formulaProdutoEntity;
    }
}
