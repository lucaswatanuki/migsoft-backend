package migsoft.repository;

import migsoft.model.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Integer> {
    ProdutoEntity findById(int id);
    List<ProdutoEntity> findAll();
    void delete(ProdutoEntity produto);
}
