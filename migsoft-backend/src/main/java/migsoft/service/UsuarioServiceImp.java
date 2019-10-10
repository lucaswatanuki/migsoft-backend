package migsoft.service;

import migsoft.model.UsuarioEntity;
import migsoft.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImp implements UsuarioService{

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImp(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioEntity findById(int id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public UsuarioEntity findByName(String nome) {
        UsuarioEntity filtered = new UsuarioEntity();
        for (UsuarioEntity user: usuarioRepository.findAll()){
            if (user == null){
                System.out.println("Usuario nao cadastrado");
            }
            else if(user.getNome().equals(nome)){
                filtered = user;
            }
        }
        return filtered;
    }

    @Override
    public List<UsuarioEntity> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioEntity save(UsuarioEntity user) {
        return usuarioRepository.save(user);
    }

    @Override
    public UsuarioEntity update(UsuarioEntity user) {
        return null;
    }

    @Override
    public void deleteById(int id) {
        usuarioRepository.delete(usuarioRepository.findById(id));
    }
}
