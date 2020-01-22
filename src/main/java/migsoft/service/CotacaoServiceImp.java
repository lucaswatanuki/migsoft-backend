package migsoft.service;

import migsoft.controller.mappers.CotacaoMapper;
import migsoft.model.CotacaoEntity;
import migsoft.controller.request.CotacaoRequest;
import migsoft.controller.response.CotacaoResponse;
import migsoft.repository.CotacaoRepository;
import migsoft.repository.FornecedorRepository;
import migsoft.repository.ProdutoRepository;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
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
        return Mappers.getMapper(CotacaoMapper.class).toCotacaoResponse(cotacao);
    }

    @Override
    public CotacaoResponse findById(Integer id) {
        return Mappers.getMapper(CotacaoMapper.class).toCotacaoResponse(cotacaoRepository.findById(id).orElse(null));
    }

    @Override
    public CotacaoResponse aproveById(Integer id) {
        CotacaoEntity cotacao = cotacaoRepository.findById(id).orElse(null);
        cotacao.setStatus("Aprovado");
        return Mappers.getMapper(CotacaoMapper.class).toCotacaoResponse(cotacaoRepository.save(cotacao));
    }

    @Override
    public CotacaoEntity getId(Integer id) {
        return cotacaoRepository.findById(id).orElse(null);
    }

    @Override
    public List<CotacaoResponse> findAll() {
        List<CotacaoResponse> cotacaoResponses = new ArrayList<>();
        cotacaoRepository.findAll().forEach(cotacaoEntity -> cotacaoResponses.add(Mappers.getMapper(CotacaoMapper.class).toCotacaoResponse(cotacaoEntity)));
        return cotacaoResponses;
    }

    @Override
    public List<CotacaoResponse> findOnlyApproved() {
        List<CotacaoResponse> cotacaoResponses = new ArrayList<>();
        cotacaoRepository.findAll().stream().filter(cotacao -> cotacao.getStatus().contains("Aprovado"))
                .forEach(cotacaoEntity -> cotacaoResponses.add(Mappers.getMapper(CotacaoMapper.class).toCotacaoResponse(cotacaoEntity)));
        return cotacaoResponses;
    }

    @Override
    public CotacaoResponse save(CotacaoRequest cotacaoRequest) {
        CotacaoEntity cotacaoEntity = Mappers.getMapper(CotacaoMapper.class).toCotacaoEntity(cotacaoRequest);
        cotacaoRepository.save(cotacaoEntity);
        CotacaoResponse response = Mappers.getMapper(CotacaoMapper.class).toCotacaoResponse(cotacaoEntity);
        return response;
    }

    @Override
    public CotacaoResponse update(CotacaoRequest cotacao, Integer id) {
        CotacaoEntity cotacaoEntity = cotacaoRepository.findById(id).orElse(null);
        cotacaoEntity.setQuantidade(cotacao.getQuantidade());
        cotacaoEntity.setData(cotacao.getData());
        dateConverter(cotacaoEntity);
        cotacaoEntity.setTotal(cotacao.getQuantidade() * cotacaoEntity.getProduto().getPreco());
        return Mappers.getMapper(CotacaoMapper.class).toCotacaoResponse(cotacaoRepository.save(cotacaoEntity));
    }

    @Override
    public void deleteById(Integer id) {
        cotacaoRepository.deleteById(id);
    }


    public void dateConverter(CotacaoEntity cotacao) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(cotacao.getData(), inputFormatter);
        String formattedDate = outputFormatter.format(date);
        cotacao.setData(formattedDate);
    }
}
