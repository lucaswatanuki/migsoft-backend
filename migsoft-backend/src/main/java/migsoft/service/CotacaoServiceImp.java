package migsoft.service;

import migsoft.model.CotacaoEntity;
import migsoft.repository.CotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CotacaoServiceImp implements CotacaoService {

    private final CotacaoRepository cotacaoRepository;

    @Autowired
    public CotacaoServiceImp(CotacaoRepository cotacaoRepository) {
        this.cotacaoRepository = cotacaoRepository;
    }

    @Override
    public CotacaoEntity findById(int id) {
        return cotacaoRepository.findById(id);
    }

    @Override
    public List<CotacaoEntity> findAll() {
        return cotacaoRepository.findAll();
    }

    @Override
    public CotacaoEntity save(CotacaoEntity cotacao) {
        return cotacaoRepository.save(cotacao);
    }

    @Override
    public CotacaoEntity update(CotacaoEntity cotacao) {
        return null;
    }

    @Override
    public void deleteById(int id) {
        cotacaoRepository.delete(cotacaoRepository.findById(id));
    }
}
