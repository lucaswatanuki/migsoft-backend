package migsoft.service;

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
    public List<ProdutoResponse> findAll() {
        ArrayList<ProdutoResponse> produtoResponses = new ArrayList<>();
        for (ProdutoEntity produtoEntity: produtoRepository.findAll()){
            ProdutoResponse produtoResponse = new ProdutoResponse();
            produtoResponse = entitytoResponseConverter(produtoEntity);
            produtoResponses.add(produtoResponse);
        }
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
