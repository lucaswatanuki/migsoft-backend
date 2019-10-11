package migsoft.repository;

import migsoft.model.OrcamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrcamentoRepository extends JpaRepository<OrcamentoEntity, Integer> {
    OrcamentoEntity findById(int id);
    List<OrcamentoEntity> findAll();
    void delete(OrcamentoEntity orcamento);
}
