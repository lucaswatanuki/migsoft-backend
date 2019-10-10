package migsoft.repository;

import migsoft.model.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    UsuarioEntity findById(int id);
    List<UsuarioEntity> findAll();
    void delete(UsuarioEntity user);
}
