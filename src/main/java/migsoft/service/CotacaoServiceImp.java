package migsoft.service;

import migsoft.model.CotacaoEntity;
import migsoft.model.response.CotacaoResponse;
import migsoft.model.response.FornecedorResponse;
import migsoft.model.response.PedidoResponse;
import migsoft.repository.CotacaoRepository;
import migsoft.repository.FornecedorRepository;
import migsoft.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CotacaoServiceImp implements CotacaoService {

    private final CotacaoRepository cotacaoRepository;
    private final ProdutoRepository produtoRepository;
    private final FornecedorRepository fornecedorRepository;

    @Autowired
    public CotacaoServiceImp(CotacaoRepository cotacaoRepository, ProdutoRepository produtoRepository, FornecedorRepository fornecedorRepository) {
        this.cotacaoRepository = cotacaoRepository;
        this.produtoRepository = produtoRepository;
        this.fornecedorRepository = fornecedorRepository;
    }


    @Override
    public CotacaoResponse updateStatus(Integer id) {
        CotacaoEntity cotacao = cotacaoRepository.findById(id).orElse(null);
        cotacao.setStatus("Aprovado");
        return entitytoResponseConverter(cotacao);
    }

    @Override
    public CotacaoResponse findById(Integer id) {
        return entitytoResponseConverter(cotacaoRepository.findById(id).orElse(null));
    }

    @Override
    public CotacaoEntity getId(Integer id) {
        return cotacaoRepository.findById(id).orElse(null);
    }

    @Override
    public List<CotacaoResponse> findAll() {
        ArrayList<CotacaoResponse> cotacaoResponses = new ArrayList<>();
        for (CotacaoEntity cotacaoEntity : cotacaoRepository.findAll()) {
            CotacaoResponse cotacaoResponse = new CotacaoResponse();
            cotacaoResponse = entitytoResponseConverter(cotacaoEntity);
            cotacaoResponses.add(cotacaoResponse);
        }
        return cotacaoResponses;
    }

    @Override
    public CotacaoResponse save(CotacaoEntity cotacao) {
        cotacao.setTotal(cotacao.getQuantidade() * cotacao.getProduto().getPreco());
        cotacao.setStatus("Aguardando");
        CotacaoResponse cotacaoResponse = entitytoResponseConverter(cotacaoRepository.save(cotacao));
        return cotacaoResponse;
    }

    @Override
    public CotacaoResponse update(CotacaoEntity cotacao) {
        cotacao.setTotal(cotacao.getQuantidade() * cotacao.getProduto().getPreco());
        CotacaoResponse cotacaoResponse = entitytoResponseConverter(cotacaoRepository.save(cotacao));
        return cotacaoResponse;
    }

    @Override
    public void deleteById(Integer id) {
        cotacaoRepository.deleteById(id);
    }


    public CotacaoResponse entitytoResponseConverter(CotacaoEntity cotacaoEntity) {
        CotacaoResponse cotacaoResponse = new CotacaoResponse();
        cotacaoResponse.setId(cotacaoEntity.getId());
        cotacaoResponse.setData(cotacaoEntity.getData());
        cotacaoResponse.setFornecedor(cotacaoEntity.getFornecedor().getNomeFantasia());
        cotacaoResponse.setProduto(cotacaoEntity.getProduto().getNome());
        cotacaoResponse.setQuantidade(cotacaoEntity.getQuantidade());
        cotacaoResponse.setTotal(cotacaoEntity.getTotal());
        cotacaoResponse.setStatus(cotacaoEntity.getStatus());
        return cotacaoResponse;
    }
}
