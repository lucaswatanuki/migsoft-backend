package migsoft.service;

import migsoft.Exceptions.ProdutoInexistenteException;
import migsoft.model.ProdutoEntity;
import migsoft.model.response.PedidoResponse;
import migsoft.model.response.ProdutoResponse;
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
    public ProdutoResponse findById(Integer id) {
        return entitytoResponseConverter(produtoRepository.findById(id).orElse(null));
    }

    @Override
    public ProdutoResponse findByNome(String nome) {
        if (produtoRepository.findByNome(nome) == null){
            throw new ProdutoInexistenteException("Produto não cadastrado");
        }
        ProdutoResponse response = entitytoResponseConverter(produtoRepository.findByNome(nome));
        return response;
    }

    @Override
    public List<ProdutoResponse> findAll() {
        List<ProdutoResponse> produtoResponses = new ArrayList<>();
        produtoRepository.findAll().forEach(produtoEntity -> {
            ProdutoResponse produtoResponse = entitytoResponseConverter(produtoEntity);
            produtoResponses.add(produtoResponse);
        });
        return produtoResponses;
    }

    @Override
    public ProdutoResponse save(ProdutoEntity produto) {
        ProdutoResponse produtoResponse = entitytoResponseConverter(produtoRepository.save(produto));
        return produtoResponse;
    }


    @Override
    public ProdutoResponse update(ProdutoEntity produto) {
        ProdutoResponse produtoResponse = entitytoResponseConverter(produtoRepository.save(produto));
        return produtoResponse;
    }

    @Override
    public void deleteById(Integer id) {
        produtoRepository.deleteById(id);
    }

    public ProdutoResponse entitytoResponseConverter(ProdutoEntity produtoEntity){
        ProdutoResponse produtoResponse = new ProdutoResponse();
        produtoResponse.setId(produtoEntity.getId());
        produtoResponse.setNome(produtoEntity.getNome());
        produtoResponse.setPreco(produtoEntity.getPreco());
        produtoResponse.setQtdEstoque(produtoEntity.getQtdEstoque());
        return produtoResponse;
    }
}
