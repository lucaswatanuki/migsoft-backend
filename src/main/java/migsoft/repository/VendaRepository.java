package migsoft.repository;

import migsoft.model.VendaEntity;
import migsoft.model.response.RelatorioProdutos;
import migsoft.model.response.VendaResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.Date;
import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<VendaEntity, Integer> {
}
