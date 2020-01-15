package migsoft.service;

import migsoft.Exceptions.ProdutoInexistenteException;
import migsoft.model.ProdutoEntity;
import migsoft.controller.response.ProdutoResponse;
import migsoft.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoServiceImp implements ProdutoService{

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoServiceImp(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoEntity findById(Integer id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @Override
    public ProdutoEntity findByNome(String nome) {
        return produtoRepository.findByNome(nome);
    }

    @Override
    public List<ProdutoEntity> findAll() {
        List<ProdutoEntity> listaProdutos = new ArrayList<>();
        produtoRepository.findAll().forEach(produtoEntity -> {
            listaProdutos.add(produtoEntity);
        });
        return listaProdutos;
    }

    @Override
    public ProdutoEntity save(ProdutoEntity produto) {
        return produtoRepository.save(produto);
    }


    @Override
    public ProdutoEntity update(ProdutoEntity produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public void deleteById(Integer id) {
        produtoRepository.deleteById(id);
    }

}
