package migsoft.repository;

import migsoft.model.CotacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CotacaoRepository extends JpaRepository<CotacaoEntity, Integer> {

}
