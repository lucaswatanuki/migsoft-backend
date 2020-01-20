package migsoft.service;

import migsoft.controller.mappers.ProdutoMapper;
import migsoft.controller.request.ProdutoRequest;
import migsoft.controller.response.ProdutoResponse;
import migsoft.model.ProdutoEntity;
import migsoft.repository.ProdutoRepository;
import org.mapstruct.factory.Mappers;
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
        return Mappers.getMapper(ProdutoMapper.class).toProdutoResponse(produtoRepository.findById(id).orElse(null));
    }

    @Override
    public ProdutoResponse findByNome(String nome) {
        return Mappers.getMapper(ProdutoMapper.class).toProdutoResponse(produtoRepository.findByNome(nome));
    }

    @Override
    public List<ProdutoResponse> findAll() {
        List<ProdutoResponse> listaProdutosResponse = new ArrayList<>();
        produtoRepository.findAll().forEach(produtoEntity -> {
            listaProdutosResponse.add(Mappers.getMapper(ProdutoMapper.class).toProdutoResponse(produtoEntity));
        });
        return listaProdutosResponse;
    }

    @Override
    public ProdutoResponse save(ProdutoRequest request) {
        ProdutoEntity produto = Mappers.getMapper(ProdutoMapper.class).toProdutoEntity(request);
        return Mappers.getMapper(ProdutoMapper.class).toProdutoResponse(produtoRepository.save(produto));
    }

    @Override
    public ProdutoResponse update(ProdutoRequest request, Integer id) {
        ProdutoEntity produto = Mappers.getMapper(ProdutoMapper.class).toProdutoEntity(request);
        produto.setId(id);
        return Mappers.getMapper(ProdutoMapper.class).toProdutoResponse(produtoRepository.save(produto));
    }

    @Override
    public void deleteById(Integer id) {
        produtoRepository.deleteById(id);
    }

}
