package migsoft.service;

import migsoft.model.ProdutoEntity;
import migsoft.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImp implements ProdutoService{

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoServiceImp(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoEntity findById(int id) {
        return produtoRepository.findById(id);
    }

    @Override
    public ProdutoEntity findByName(String nome) {
        ProdutoEntity filtered = new ProdutoEntity();
        for (ProdutoEntity produto: produtoRepository.findAll()){
            if (produto == null){
                System.out.println("produto nao cadastrado");
            }
            else if(produto.getNome().equals(nome)){
                filtered = produto;
            }
        }
        return filtered;
    }

    @Override
    public List<ProdutoEntity> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public ProdutoEntity save(ProdutoEntity produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public ProdutoEntity update(ProdutoEntity produto) {
        return null;
    }

    @Override
    public void deleteById(int id) {
        produtoRepository.delete(produtoRepository.findById(id));
    }
}
