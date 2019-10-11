package migsoft.repository;

import migsoft.model.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer> {
    PedidoEntity findById(int id);
    List<PedidoEntity> findAll();
    void delete(PedidoEntity pedido);
}
