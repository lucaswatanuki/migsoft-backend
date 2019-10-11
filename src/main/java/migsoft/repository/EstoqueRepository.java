package migsoft.repository;

import migsoft.model.EstoqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstoqueRepository extends JpaRepository<EstoqueEntity, Integer> {
    EstoqueEntity findById(int id);
    List<EstoqueEntity> findAll();
    void delete(EstoqueEntity estoque);
}
