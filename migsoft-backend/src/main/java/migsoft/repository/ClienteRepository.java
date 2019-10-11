package migsoft.repository;

import migsoft.model.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {
    ClienteEntity findById(int id);
    List<ClienteEntity> findAll();
    void delete(ClienteEntity clienteEntity);
}