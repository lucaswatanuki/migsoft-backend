package migsoft.repository;

import migsoft.model.VendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<VendaEntity, Integer> {
}
