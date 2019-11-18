package migsoft.service;

import migsoft.model.CotacaoEntity;
import migsoft.model.request.CotacaoRequest;
import migsoft.model.response.CotacaoResponse;
import migsoft.model.response.FornecedorResponse;
import migsoft.model.response.PedidoResponse;
import migsoft.repository.CotacaoRepository;
import migsoft.repository.FornecedorRepository;
import migsoft.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
    public CotacaoResponse aprove(Integer id) {
        CotacaoEntity cotacaoEntity = cotacaoRepository.findById(id).orElse(null);
        cotacaoEntity.setStatus("Aprovado");
        CotacaoResponse cotacaoResponse = entitytoResponseConverter(cotacaoRepository.save(cotacaoEntity));
        return cotacaoResponse;
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
    public List<CotacaoResponse> findOnlyApproved() {
        ArrayList<CotacaoResponse> cotacaoResponses = new ArrayList<>();
        for (CotacaoEntity cotacaoEntity : cotacaoRepository.findAll()) {
            if (cotacaoEntity.getStatus().contains("Aprovado")){
                CotacaoResponse cotacaoResponse = new CotacaoResponse();
                cotacaoResponse = entitytoResponseConverter(cotacaoEntity);
                cotacaoResponses.add(cotacaoResponse);
            }
        }
        return cotacaoResponses;
    }

    @Override
    public CotacaoResponse save(CotacaoEntity cotacao) {
        cotacao.setTotal(cotacao.getQuantidade() * cotacao.getProduto().getPreco());
        cotacao.setStatus("Pendente");
        dateConverter(cotacao);
        CotacaoResponse cotacaoResponse = entitytoResponseConverter(cotacaoRepository.save(cotacao));
        return cotacaoResponse;
    }

    @Override
    public CotacaoResponse update(CotacaoRequest cotacao, Integer id) {
        CotacaoEntity cotacaoEntity = requestToEntityConverter(cotacao);
        cotacaoEntity.setTotal(cotacao.getQuantidade() * cotacaoEntity.getProduto().getPreco());
        dateConverter(cotacaoEntity);
        CotacaoResponse cotacaoResponse = entitytoResponseConverter(cotacaoRepository.save(cotacaoEntity));
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

    public CotacaoEntity requestToEntityConverter(CotacaoRequest cotacaoRequest){
        CotacaoEntity cotacaoEntity = new CotacaoEntity();
        cotacaoEntity.setProduto(produtoRepository.findByNome(cotacaoRequest.getProduto()));
        cotacaoEntity.setFornecedor(fornecedorRepository.findByNomeFantasia(cotacaoRequest.getFornecedor()));
        cotacaoEntity.setData(cotacaoRequest.getData());
        cotacaoEntity.setStatus(cotacaoRequest.getStatus());
        cotacaoEntity.setQuantidade(cotacaoRequest.getQuantidade());
        return cotacaoEntity;
    }

    public void dateConverter(CotacaoEntity cotacao){
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(cotacao.getData(), inputFormatter);
        String formattedDate = outputFormatter.format(date);
        cotacao.setData(formattedDate);
    }
}
