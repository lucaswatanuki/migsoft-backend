package migsoft.service;

import migsoft.model.LocalizacaoEntity;
import migsoft.repository.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalizacaoServiceImp implements LocalizacaoService{

    private final LocalizacaoRepository localizacaoRepository;

    @Autowired
    public LocalizacaoServiceImp(LocalizacaoRepository localizacaoRepository) {
        this.localizacaoRepository = localizacaoRepository;
    }

    @Override
    public LocalizacaoEntity findById(int id) {
        return localizacaoRepository.findById(id);
    }

    @Override
    public List<LocalizacaoEntity> findAll() {
        return localizacaoRepository.findAll();
    }

    @Override
    public LocalizacaoEntity save(LocalizacaoEntity local) {
        return localizacaoRepository.save(local);
    }

    @Override
    public LocalizacaoEntity update(LocalizacaoEntity local) {
        return localizacaoRepository.save(local);
    }

    @Override
    public void deleteById(int id) {
        localizacaoRepository.delete(localizacaoRepository.findById(id));
    }
}
