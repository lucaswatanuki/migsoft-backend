package migsoft.service;

import migsoft.model.UsuarioEntity;

import java.util.List;

public interface UsuarioService {
     UsuarioEntity findById(int id);
     UsuarioEntity findByName(String nome);
     List<UsuarioEntity> findAll();
     UsuarioEntity save(UsuarioEntity user);
     UsuarioEntity update(UsuarioEntity user);
     void deleteById(int id);
}
