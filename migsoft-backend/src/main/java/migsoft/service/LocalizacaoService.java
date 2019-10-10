package migsoft.service;

import migsoft.model.LocalizacaoEntity;

import java.util.List;

public interface LocalizacaoService {
     LocalizacaoEntity findById(int id);
     List<LocalizacaoEntity> findAll();
     LocalizacaoEntity save(LocalizacaoEntity local);
     LocalizacaoEntity update(LocalizacaoEntity local);
     void deleteById(int id);
}
