package migsoft.repository;

import migsoft.model.FormulaProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormulaRepository extends JpaRepository<FormulaProdutoEntity, Integer> {
    FormulaProdutoEntity findById(int id);
    FormulaProdutoEntity findByIdMaterial(int id);
    List<FormulaProdutoEntity> findAll();
    void delete(FormulaProdutoEntity formula);
}
