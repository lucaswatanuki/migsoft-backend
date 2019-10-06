package migsoft.service;

import migsoft.model.EstoqueEntity;
import migsoft.model.ProdutoEntity;
import migsoft.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueServiceImp implements EstoqueService{

    private final EstoqueRepository estoqueRepository;

    @Autowired
    public EstoqueServiceImp(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    @Override
    public EstoqueEntity findById(int id) {
        return estoqueRepository.findById(id);
    }

    @Override
    public EstoqueEntity findByProduto(ProdutoEntity produto) {
        EstoqueEntity estoqueProd = new EstoqueEntity();
        for (EstoqueEntity estoque : estoqueRepository.findAll()){
            if (estoque == null){
                System.out.println("estoque vazio");
            }
            else if(estoque.getIdProduto().equals(produto.getId())){
                estoqueProd = estoque;
            }
        }
        return estoqueProd;
    }

    @Override
    public List<EstoqueEntity> findAll() {
        return estoqueRepository.findAll();
    }

    @Override
    public EstoqueEntity save(EstoqueEntity estoque) {
        return estoqueRepository.save(estoque);
    }

    @Override
    public EstoqueEntity update(EstoqueEntity estoque) {
        return null;
    }

    @Override
    public void deleteById(int id) {
        estoqueRepository.delete(estoqueRepository.findById(id));
    }
}
