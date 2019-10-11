package migsoft.repository;

import migsoft.model.LocalizacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalizacaoRepository extends JpaRepository<LocalizacaoEntity, Integer> {
    LocalizacaoEntity findById(int id);
    List<LocalizacaoEntity> findAll();
    void delete(LocalizacaoEntity localizacao);
}
