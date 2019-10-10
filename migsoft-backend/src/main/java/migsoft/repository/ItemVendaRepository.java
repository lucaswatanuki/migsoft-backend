package migsoft.repository;

import migsoft.model.ItemVendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVendaEntity, Integer> {
    ItemVendaEntity findById(int id);
    List<ItemVendaEntity> findAll();
    void delete(ItemVendaEntity item);
}
